package net.geozen.lhc2.service.base;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.impl.CommonDAO;
import net.geozen.lhc2.domain.Tm;
import net.geozen.lhc2.domain.base.PosBaseEntity;
import net.geozen.lhc2.dto.MaxInfo;
import net.geozen.lhc2.jpa.TmRepository;
import net.geozen.lhc2.utils.SystemConstants;

public abstract class BasePosYzCalculationService<Y extends PosBaseEntity> {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected TmRepository tmRepository;

	@Autowired
	private CommonDAO commonDAO;

	protected abstract BaseYzRepository<Y> getRepository();

	protected abstract BaseZfCalculationService<Y, ?> getZfCalculationService();

	protected abstract BaseSwCalculationService<Y, ?> getSwCalculationService();

	protected abstract CalculationHandler getHandler();

	public abstract int getEndPos();

	protected void calSmallAndLarge(int index, Y yz, Y lastYz) throws Exception {

	}

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
				Method m = ReflectionUtils.findMethod(yzClass, "getW" + i);
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
			Method m = ReflectionUtils.findMethod(yzClass, "getW" + i);
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
				if (getHandler().isFiltered(data.getNum())) {
					continue;
				}
				Y yz = null;
				if (getHandler().isDelete()) {
					yz = yzClass.newInstance();
					yz.setPhase(data.getPhase());
					yz.setNum(data.getNum());
				} else {
					yz = getRepository().findByPhase(data.getPhase());
				}
				int pos = getHandler().getPos(data.getNum());
				yz.setPos(pos);
				for (int j = 0; j < getHandler().getLength(); j++) {
					Method setMethod = ReflectionUtils.findMethod(yz.getClass(), "set" + getHandler().getIndexStr(j), int.class);
					if (pos == j) {
						setMethod.invoke(yz, 0);
					} else {
						Method getMethod = ReflectionUtils.findMethod(yz.getClass(), "get" + getHandler().getIndexStr(j));
						int value = (int) getMethod.invoke(lastYz);
						setMethod.invoke(yz, value + 1);
					}
				}
				lastYz = yz;
				yzList.add(yz);
			}
			lastYz = null;
			for (int i = 0; i < yzList.size(); i++) {
				Y yz = yzList.get(i);
				calSmallAndLarge(i, yz, lastYz);
				lastYz = yz;
			}
			if (getHandler().isDelete()) {
				getRepository().deleteAll();
			}
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
