package net.geozen.lhc3.service.base;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
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
public abstract class BaseZfZValueCalService<Y extends PosBaseEntity, Z extends PosBaseEntity> {

	protected abstract BaseRepository<Z> getZfRepository();

	protected abstract BaseRepository<Y> getYzRepository();

	private int length = 12;

	@Async
	public Future<ZInfo> process(Lhc3Tm tm, int order) {
		ZInfo info = null;
		try {
			Optional<Z> zfOp = getZfRepository().findByPhase(tm.getPhase());
			if (zfOp.isPresent()) {
				Z zf = zfOp.get();
				BigDecimal z = new BigDecimal(zf.getRColsYz()).divide(new BigDecimal(zf.getMaxColYz()), 2, RoundingMode.HALF_UP);

				int pos = 1;
				int max = 0;
				for (int i = 1; i <= length; i++) {
					Method m = ReflectionUtils.findMethod(zf.getClass(), "getLt" + i);
					int value = (int) m.invoke(zf);
					if (value > max) {
						max = value;
						pos = i;
					}
				}
				Y yz = getYzRepository().findByPhase(tm.getPhase()).get();
				pos = yz.getPos() + pos;
				if (pos > length) {
					pos -= length;
				}

				info = new ZInfo();
				info.setOrder(order);
				info.setZ(z);
				List<Integer> list = getNums(pos - 1);
				info.setNums(list);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return new AsyncResult<ZInfo>(info);
	}

	protected abstract List<Integer> getNums(int pos);

}
