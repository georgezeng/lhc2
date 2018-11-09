package net.geozen.lhc2.service.base;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.impl.CommonDAO;
import net.geozen.lhc2.domain.Tm;
import net.geozen.lhc2.domain.base.PosBaseEntity;
import net.geozen.lhc2.dto.MaxInfo;
import net.geozen.lhc2.jpa.TmRepository;
import net.geozen.lhc2.utils.SystemConstants;

@Slf4j
public abstract class BasePosYzCalculationService<Y extends PosBaseEntity> {

	@Autowired
	protected TmRepository tmRepository;

	@Autowired
	private CommonDAO commonDAO;

	protected abstract BaseYzRepository<Y> getRepository();

	protected abstract BaseZfCalculationService<Y, ?> getZfCalculationService();

	protected abstract BaseSwCalculationService<Y, ?> getSwCalculationService();

	protected abstract CalculationHandler getHandler();

	public abstract int getEndPos();

	public int getStartPos() {
		return 0;
	}

	protected Class<Y> yzClass;

	@SuppressWarnings("unchecked")
	public BasePosYzCalculationService() {
		yzClass = (Class<Y>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public int getTotalAvgForLastPhases(int offset, int size) throws Exception {
		List<Y> list = commonDAO.findAllByOffsetAndSize(yzClass, offset, size);
		int total = 0;
		for (Y yz : list) {
			for (int i = getStartPos(); i < getEndPos(); i++) {
				Method m = yzClass.getDeclaredMethod("getW" + i);
				Integer value = (Integer) m.invoke(yz);
				total += value;
			}
		}
		return total / size;
	}

	public MaxInfo getMax(int phase) throws Exception {
		Y yz = getRepository().findByPhase(phase);
		int max = 0;
		int pos = 0;
		for (int i = getStartPos(); i < getEndPos(); i++) {
			Method m = yzClass.getDeclaredMethod("getW" + i);
			Integer value = (Integer) m.invoke(yz);
			if (value > max) {
				max = value;
				if (getStartPos() == 0) {
					pos = i;
				} else {
					pos = i - 1;
				}
			}
		}
		return new MaxInfo(phase, max, pos);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getNumbers(Class<?> numsClass, MaxInfo info) throws Exception {
		List<List<Integer>> nums = (List<List<Integer>>) numsClass.getDeclaredField("LISTS").get(null);
		return nums.get(info.getPos());
	}

	@Transactional
	@Async
	public Future<Exception> process() {
		Exception t = null;
		try {
			Pageable pageable = PageRequest.of(0, SystemConstants.CALCULATION_SIZE, Direction.DESC, "phase");
			List<Tm> datas = tmRepository.findAll(pageable).getContent();
			Y lastYz = yzClass.newInstance();
			List<Y> yzList = new ArrayList<>();
			for (int i = datas.size() - 1; i > -1; i--) {
				Tm data = datas.get(i);
				Y yz = yzClass.newInstance();
				yz.setPhase(data.getPhase());
				yz.setNum(data.getNum());
				int pos = getHandler().getPos(data.getNum());
				yz.setPos(pos);
				for (int j = 0; j < getHandler().getLength(); j++) {
					Method setMethod = yz.getClass().getDeclaredMethod("set" + getHandler().getIndexStr(j), int.class);
					if (pos == j) {
						setMethod.invoke(yz, 0);
					} else {
						Method getMethod = yz.getClass().getDeclaredMethod("get" + getHandler().getIndexStr(j));
						int value = (int) getMethod.invoke(lastYz);
						setMethod.invoke(yz, value + 1);
					}
				}
				lastYz = yz;
				yzList.add(yz);
			}
			getRepository().deleteAll();
			getRepository().saveAll(yzList);
			if (getZfCalculationService() != null) {
				getZfCalculationService().process(yzList);
			}
			if (getSwCalculationService() != null) {
				getSwCalculationService().process(yzList);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<>(t);
	}

}
