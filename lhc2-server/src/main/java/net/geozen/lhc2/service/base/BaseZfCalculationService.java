package net.geozen.lhc2.service.base;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.domain.PosBaseEntity;

@Slf4j
public abstract class BaseZfCalculationService<Y extends PosBaseEntity, Z extends PosBaseEntity> {

	protected abstract PagingAndSortingRepository<Z, Long> getRepository();

	protected abstract Class<Z> getZfClass();
	
	protected abstract int getLength();

	@Transactional
	@Async
	public Future<Exception> process(List<Y> yzList) {
		Exception t = null;
		try {
			int len = getLength();
			Z lastZf = getZfClass().newInstance();
			List<Z> list = new ArrayList<>();
			for (int i = 1; i < yzList.size(); i++) {
				Y lastYz = yzList.get(i - 1);
				Y yz = yzList.get(i);
				int delta = yz.getPos() - lastYz.getPos();
				if (delta < 0) {
					delta += len;
				}
				Z zf = getZfClass().newInstance();
				zf.setPhase(yz.getPhase());
				zf.setNum(yz.getNum());
				zf.setPos(yz.getPos());
				for (int j = 0; j < len; j++) {
					Method setMethod = zf.getClass().getDeclaredMethod("setZf" + j, int.class);
					if (j != delta) {
						Method getMethod = zf.getClass().getDeclaredMethod("getZf" + j);
						int value = (int) getMethod.invoke(lastZf);
						setMethod.invoke(zf, value + 1);
					} else {
						setMethod.invoke(zf, 0);
					}
				}
				lastZf = zf;
				list.add(zf);
			}
			getRepository().deleteAll();
			getRepository().saveAll(list);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<>(t);
	}

}
