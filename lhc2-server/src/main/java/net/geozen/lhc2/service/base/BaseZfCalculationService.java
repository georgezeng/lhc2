package net.geozen.lhc2.service.base;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.def.jpa.impl.CommonDAO;
import net.geozen.lhc2.domain.base.PosBaseEntity;
import net.geozen.lhc2.dto.MaxInfo;

public abstract class BaseZfCalculationService<Y extends PosBaseEntity, Z extends PosBaseEntity> {

	protected abstract BaseYzRepository<Y> getYzRepository();

	protected abstract BaseZfRepository<Z> getRepository();

	protected Class<Z> zfClass;

	@Autowired
	private CommonDAO commonDAO;

	protected abstract CalculationHandler getHandler();

	@SuppressWarnings("unchecked")
	public BaseZfCalculationService() {
		zfClass = (Class<Z>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	public abstract int getEndPos();

	public int getTotalAvgForLastPhases(int offset, int size) throws Exception {
		List<Z> list = commonDAO.findAllByOffsetAndSize(zfClass, offset, size);
		int total = 0;
		for (Z zf : list) {
			for (int i = 0; i < getEndPos(); i++) {
				Method m = zfClass.getDeclaredMethod("getZf" + i);
				Integer value = (Integer) m.invoke(zf);
				total += value;
			}
		}
		return total / size;
	}

	public MaxInfo getMax(int phase) throws Exception {
		Z zf = getRepository().findByPhase(phase);
		if (zf == null) {
			return new MaxInfo(phase, 0, 0);
		}
		int max = 0;
		int pos = 0;
		for (int i = 0; i < getEndPos(); i++) {
			Method m = zfClass.getDeclaredMethod("getZf" + i);
			Integer value = (Integer) m.invoke(zf);
			if (value > max) {
				max = value;
				pos = i;
			}
		}
		return new MaxInfo(phase, max, pos);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getNumbers(Class<?> numsClass, MaxInfo info) throws Exception {
		int endPos = getEndPos();
		Y yz = getYzRepository().findByPhase(info.getPhase());
		int pos = yz.getPos() + info.getPos();
		if (pos >= endPos) {
			pos = pos - endPos;
		}
		List<List<Integer>> nums = (List<List<Integer>>) numsClass.getDeclaredField("LISTS").get(null);
		return nums.get(pos);
	}

	@Transactional
	public void process(List<Y> yzList) throws Exception {
		int len = getHandler().getLength();
		Z lastZf = zfClass.newInstance();
		List<Z> list = new ArrayList<>();
		for (int i = 1; i < yzList.size(); i++) {
			Y lastYz = yzList.get(i - 1);
			Y yz = yzList.get(i);
			int delta = yz.getPos() - lastYz.getPos();
			if (delta < 0) {
				delta += len;
			}
			Z zf = zfClass.newInstance();
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
	}

}
