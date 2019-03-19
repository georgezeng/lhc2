package net.geozen.lhc2.service.base;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.Tm;
import net.geozen.lhc2.domain.base.BaseEntity;
import net.geozen.lhc2.dto.ZInfo;

@Service
@Slf4j
public abstract class BaseYzZValueCalService<O, Y extends BaseEntity, S extends BaseEntity> {
	protected abstract BaseYzRepository<Y> getYzRepository();

	protected abstract BaseSwRepository<S> getSwRepository();

	@Async
	public Future<ZInfo> process(Tm tm) {
		ZInfo info = null;
		try {
//			int len = 20;
//			int count = 0;
//			BigDecimal avg = BigDecimal.ZERO;
//			while (count < len) {
//				Y yz = getYzRepository().findByPhase(tm.getPhase() - count);
//				if (yz == null) {
//					break;
//				}
//				for (O o : getColumns()) {
//					Method m = ReflectionUtils.findMethod(yz.getClass(), "get" + getColumnName(o));
//					Integer value = (Integer) m.invoke(yz);
//					BigDecimal decimal = new BigDecimal(value);
//					avg = avg.add(decimal);
//				}
//				count++;
//			}
//			if (count >= len) {
//				avg = avg.divide(new BigDecimal(count), 2, RoundingMode.HALF_UP);
			
				Y yz = getYzRepository().findByPhase(tm.getPhase());
				BigDecimal bmax = BigDecimal.ZERO; // b for max
//				BigDecimal bmin = new BigDecimal("999999");
				BigDecimal c = BigDecimal.ZERO; // d for total
//				O max = null;
//				O min = null;
				for (O o : getColumns()) {
					Method m = ReflectionUtils.findMethod(yz.getClass(), "get" + getColumnName(o));
					Integer value = (Integer) m.invoke(yz);
					BigDecimal decimal = new BigDecimal(value);
					if (bmax.compareTo(decimal) < 0) {
						bmax = decimal;
//						max = o;
					}
//					if (bmin.compareTo(decimal) > 0) {
//						bmin = decimal;
//						min = o;
//					}
					c = c.add(decimal);
				}

				BigDecimal d = c.divide(new BigDecimal(getEndPos()), 2, RoundingMode.HALF_UP); // d for avg
				BigDecimal x = d.divide(bmax, 2, RoundingMode.HALF_UP);
				S sw = getSwRepository().findByPhase(tm.getPhase());
				BigDecimal f = BigDecimal.ZERO; // f for d1+d2+d3+d4+d5
				for (int i = getEndPos() - 5; i < getEndPos(); i++) {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getSw" + i);
					Integer value = (Integer) m.invoke(sw);
					BigDecimal decimal = new BigDecimal(value);
					f = f.add(decimal);
				}
				BigDecimal y = f.divide(c, 2, RoundingMode.HALF_UP);
				// BigDecimal z = avg.multiply(x.multiply(y));
				BigDecimal z = new BigDecimal("7").multiply(x.multiply(y));

				info = new ZInfo();
				info.setZ(z);
//				info.setNums(getNums(max));
//				info.setMinNums(getNums(min));
				int pos = getPos(tm.getPhase());
				List<Integer> list = getNums(pos);
//				if(list == null) {
//					System.out.println("phase:"+tm.getPhase()+", pos: " + pos + ", class: " + yz.getClass());
//				}
				info.setNums(list);
//			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return new AsyncResult<ZInfo>(info);
	}

	protected abstract int getEndPos();

	protected abstract List<O> getColumns() throws Exception;

	protected String getColumnName(O o) {
		return "W" + o.toString();
	}
	
	protected abstract String[] getFields();
	
	protected abstract List<Integer> getNums(int pos);
	
	protected int getPos(int phase) throws Exception {
		List<Y> list = getYzRepository().findAllByPhaseLessThanEqual(phase);
		Map<String, Integer> redCount = new HashMap<>();
		String[] fields = getFields();
		for (Y yz : list) {
			for (String field : fields) {
				Integer count = redCount.get(field);
				if (count == null) {
					count = 0;
				}
				String name = "get" + StringUtils.capitalize(field);
				Method m = ReflectionUtils.findMethod(yz.getClass(), name);
				Assert.notNull(m, "cannot find method " + name + " in " + yz.getClass());
				Integer value = (Integer) m.invoke(yz);
				if (value != null && value == 0) {
					count++;
				}
				redCount.put(field, count);
			}
		}
		Map.Entry<String, Integer> lessEntry = null;
		int lessPos = 0;
		int index = 0;
		for (Map.Entry<String, Integer> entry : redCount.entrySet()) {
			if (lessEntry == null) {
				lessEntry = entry;
			} else {
				lessEntry = entry.getValue() < lessEntry.getValue() ? entry : lessEntry;
				lessPos = index;
			}
			index++;
		}
		return lessPos;
	}

}
