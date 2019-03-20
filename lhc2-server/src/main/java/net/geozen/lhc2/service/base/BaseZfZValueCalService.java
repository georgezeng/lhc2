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
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.Tm;
import net.geozen.lhc2.domain.base.BaseEntity;
import net.geozen.lhc2.domain.base.PosBaseEntity;
import net.geozen.lhc2.domain.sx.Sxyz;
import net.geozen.lhc2.dto.ZInfo;

@Slf4j
public abstract class BaseZfZValueCalService<Y extends BaseEntity, Z extends BaseEntity, S extends BaseEntity> {
	protected abstract BaseYzRepository<Y> getYzRepository();

	protected abstract BaseZfRepository<Z> getZfRepository();

	protected abstract BaseSwRepository<S> getSwRepository();

	@Async
	public Future<ZInfo> process(Tm tm, int order) {
		ZInfo info = null;
		try {
			// int len = 20;
			// int count = 0;
			// BigDecimal avg = BigDecimal.ZERO;
			// while (count < len) {
			// Z zf = getZfRepository().findByPhase(tm.getPhase() - count);
			// if (zf == null) {
			// break;
			// }
			// for (int i = 0; i < getEndPos(); i++) {
			// Method m = ReflectionUtils.findMethod(zf.getClass(), "getZf" + i);
			// Integer value = (Integer) m.invoke(zf);
			// BigDecimal decimal = new BigDecimal(value);
			// avg = avg.add(decimal);
			// }
			// count++;
			// }
			// if (count >= len - 1) {
			// avg = avg.divide(new BigDecimal(count), 2, RoundingMode.HALF_UP);
			Z zf = getZfRepository().findByPhase(tm.getPhase());
//			BigDecimal bmax = BigDecimal.ZERO; // b for max
			// BigDecimal bmin = new BigDecimal("999999"); // b for min
			BigDecimal c = BigDecimal.ZERO; // d for total
			// MaxInfo max = null;
			// MaxInfo min = null;
			for (int i = 0; i < getEndPos(); i++) {
				Method m = ReflectionUtils.findMethod(zf.getClass(), "getZf" + i);
				Integer value = (Integer) m.invoke(zf);
				BigDecimal decimal = new BigDecimal(value);
//				if (bmax.compareTo(decimal) < 0) {
//					bmax = decimal;
					// max = new MaxInfo(tm.getPhase(), bmax.intValue(), i);
//				}
				// if (bmin.compareTo(decimal) > 0) {
				// bmin = decimal;
				// min = new MaxInfo(tm.getPhase(), bmin.intValue(), i);
				// }
				c = c.add(decimal);
			}

			BigDecimal d = c.divide(new BigDecimal(getEndPos()), 2, RoundingMode.HALF_UP); // d for avg
//			BigDecimal x = d.divide(bmax, 2, RoundingMode.HALF_UP);
			S sw = getSwRepository().findByPhase(tm.getPhase());
			BigDecimal f = BigDecimal.ZERO; // f for d1+d2+d3+d4+d5
			for (int i = getEndPos() - 5; i < getEndPos(); i++) {
				Method m = ReflectionUtils.findMethod(sw.getClass(), "getSw" + i);
				Integer value = (Integer) m.invoke(sw);
				BigDecimal decimal = new BigDecimal(value);
				f = f.add(decimal);
			}
//			BigDecimal y = f.divide(c, 2, RoundingMode.HALF_UP);
			// BigDecimal z = avg.divide(x.add(y), 2, RoundingMode.HALF_UP);
//			BigDecimal z = new BigDecimal("7").divide(x.add(y), 2, RoundingMode.HALF_UP);
			BigDecimal z = f.divide(d, 2, RoundingMode.HALF_UP);

			info = new ZInfo();
			info.setOrder(order);
			info.setZ(z);
			// info.setNums(getNums(getNumsClass(), max));
			// info.setMinNums(getNums(getNumsClass(), min));
			// }
			info.setNums(getNums(getNumsClass(), tm.getPhase()));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return new AsyncResult<ZInfo>(info);
	}

	protected abstract int getEndPos();

	protected abstract Class<?> getNumsClass();

	protected abstract String[] getFields();

	@SuppressWarnings("unchecked")
	protected List<Integer> getNums(Class<?> numsClass, int phase) throws Exception {
		List<Z> list = getZfRepository().findAllByPhaseLessThanEqual(phase);
		Map<String, Integer> redCount = new HashMap<>();
		String[] fields = getFields();
		for (Z yz : list) {
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
		List<List<Integer>> nums = (List<List<Integer>>) numsClass.getDeclaredField("LISTS").get(null);

		int endPos = getEndPos();
		BaseEntity baseYz = getYzRepository().findByPhase(phase);
		int pos = 0;
		if(baseYz instanceof PosBaseEntity) {
			PosBaseEntity yz = (PosBaseEntity) baseYz;
			pos = yz.getPos() + lessPos;
		} else {
			pos = ((Sxyz) baseYz).getSx().getNumsPos() + lessPos;
		}
		if (pos >= endPos) {
			pos = pos - endPos;
		}
		
		List<Integer> numsList = nums.get(pos);
//		if(numsList == null) {
//			System.out.println("phase:"+phase+", pos: " + lessPos +", zpos: "+ pos + ", class: " + yz.getClass());
//		}
		return numsList;
	}

}
