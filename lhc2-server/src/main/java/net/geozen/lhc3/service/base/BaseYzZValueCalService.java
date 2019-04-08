package net.geozen.lhc3.service.base;

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
import net.geozen.lhc2.dto.ZInfo;
import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.domain.base.PosBaseEntity;

@Service
@Slf4j
public abstract class BaseYzZValueCalService<Y extends PosBaseEntity> {

	protected abstract BaseRepository<Y> getRepository();

	private int length = 12;

	@Async
	public Future<ZInfo> process(Lhc3Tm tm, int order) {
		ZInfo info = null;
		try {
			Y yz = getRepository().findByPhase(tm.getPhase()).get();
			BigDecimal z = new BigDecimal(yz.getRColsYz()).divide(new BigDecimal(yz.getMaxColYz()), 2, RoundingMode.HALF_UP);

			int pos = 0;
			int max = 0;
			for (int i = 1; i <= length; i++) {
				Method m = ReflectionUtils.findMethod(yz.getClass(), "getLt" + i);
				int value = (int) m.invoke(yz);
				if (value > max) {
					max = value;
					pos = i - 1;
				}
			}

			info = new ZInfo();
			info.setOrder(order);
			info.setZ(z);
			List<Integer> list = getNums(pos);
			info.setNums(list);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return new AsyncResult<ZInfo>(info);
	}

	protected abstract List<Integer> getNums(int pos);

}
