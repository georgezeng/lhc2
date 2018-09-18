package net.geozen.lhc2.service.base;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Slf4j
public abstract class BaseSwCalculationService<Y extends PosBaseEntity, S extends PosBaseEntity> {

	protected abstract PagingAndSortingRepository<S, Long> getRepository();

	protected abstract CalculationHandler getHandler();

	protected Class<S> swClass;

	@SuppressWarnings("unchecked")
	public BaseSwCalculationService() {
		swClass = (Class<S>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@Transactional
	@Async
	public Future<Exception> process(List<Y> yzList) {
		Exception t = null;
		try {
			S lastSw = swClass.newInstance();
			List<S> list = new ArrayList<>();
			for (int i = 1; i < yzList.size(); i++) {
				Y lastYz = yzList.get(i - 1);
				Y yz = yzList.get(i);
				List<PosYzInfo> lastInfoList = new ArrayList<>();
				for (int j = 0; j < getHandler().getLength(); j++) {
					Method getMethod = yz.getClass().getDeclaredMethod("get" + getHandler().getIndexStr(j));
					PosYzInfo info = new PosYzInfo(j, (int) getMethod.invoke(lastYz));
					lastInfoList.add(info);
				}
				Collections.sort(lastInfoList, new Comparator<PosYzInfo>() {

					@Override
					public int compare(PosYzInfo o1, PosYzInfo o2) {
						return Integer.valueOf(o1.getYz()).compareTo(Integer.valueOf(o2.getYz()));
					}

				});
				int redPointPos = yz.getPos();
				int pos = 0;
				List<PosYzInfo> infoList = new LinkedList<>();
				boolean found = false;
				for (PosYzInfo info : lastInfoList) {
					if (info.getPos() == redPointPos) {
						found = true;
					} else {
						infoList.add(info);
					}
					if (!found) {
						pos++;
					}
				}
				infoList.add(0, lastInfoList.get(pos));
				S sw = swClass.newInstance();
				sw.setPhase(yz.getPhase());
				sw.setNum(yz.getNum());
				sw.setPos(redPointPos);
				for (int j = 0; j < infoList.size(); j++) {
					Method setPosMethod = sw.getClass().getDeclaredMethod("setSw" + (j + 1) + "Pos", int.class);
					setPosMethod.invoke(sw, infoList.get(j).getPos());
					Method setMethod = sw.getClass().getDeclaredMethod("setSw" + (j + 1), int.class);
					if (pos != j) {
						Method getMethod = sw.getClass().getDeclaredMethod("getSw" + (j + 1));
						int value = (int) getMethod.invoke(lastSw);
						setMethod.invoke(sw, value + 1);
					} else {
						setMethod.invoke(sw, 0);
					}
				}
				lastSw = sw;
				list.add(sw);
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
