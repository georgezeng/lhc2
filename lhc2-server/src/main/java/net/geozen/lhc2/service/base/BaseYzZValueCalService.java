package net.geozen.lhc2.service.base;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

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
			int len = 20;
			int count = 0;
			BigDecimal avg = BigDecimal.ZERO;
			while (count < len) {
				Y yz = getYzRepository().findByPhase(tm.getPhase() - count);
				if (yz == null) {
					break;
				}
				for (O o : getColumns()) {
					Method m = ReflectionUtils.findMethod(yz.getClass(), "get" + getColumnName(o));
					Integer value = (Integer) m.invoke(yz);
					BigDecimal decimal = new BigDecimal(value);
					avg = avg.add(decimal);
				}
				count++;
			}
			if (count >= len) {
				avg = avg.divide(new BigDecimal(count), 2, RoundingMode.HALF_UP);
				Y yz = getYzRepository().findByPhase(tm.getPhase());
				BigDecimal b = BigDecimal.ZERO; // b for max
				BigDecimal c = BigDecimal.ZERO; // d for total
				O max = null;
				for (O o : getColumns()) {
					Method m = ReflectionUtils.findMethod(yz.getClass(), "get" + getColumnName(o));
					Integer value = (Integer) m.invoke(yz);
					BigDecimal decimal = new BigDecimal(value);
					if (b.compareTo(decimal) < 0) {
						b = decimal;
						max = o;
					}
					c = c.add(decimal);
				}

				BigDecimal d = c.divide(new BigDecimal(getEndPos()), 2, RoundingMode.HALF_UP); // d for avg
				BigDecimal x = d.divide(b, 2, RoundingMode.HALF_UP);
				S sw = getSwRepository().findByPhase(tm.getPhase());
				BigDecimal f = BigDecimal.ZERO; // f for d1+d2+d3+d4+d5
				for (int i = getEndPos() - 5; i < getEndPos(); i++) {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getSw" + i);
					Integer value = (Integer) m.invoke(sw);
					BigDecimal decimal = new BigDecimal(value);
					f = f.add(decimal);
				}
				BigDecimal y = f.divide(c, 2, RoundingMode.HALF_UP);
				BigDecimal z = avg.divide(x.add(y), 2, RoundingMode.HALF_UP);

				info = new ZInfo();
				info.setZ(z);
				info.setNums(getNums(max));
			}
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

	protected abstract List<Integer> getNums(O max);

}
