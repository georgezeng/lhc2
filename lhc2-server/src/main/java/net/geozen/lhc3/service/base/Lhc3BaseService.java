package net.geozen.lhc3.service.base;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.ReflectionUtils;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.service.base.PosYzInfo;
import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.domain.base.PosBaseEntity;
import net.geozen.lhc3.domain.base.SwBaseEntity;
import net.geozen.lhc3.jpa.Lhc3TmRepository;

@Slf4j
public abstract class Lhc3BaseService<Y extends PosBaseEntity, Z extends PosBaseEntity, S extends SwBaseEntity> {

	@Autowired
	protected Lhc3TmRepository tmRepository;

	protected abstract BaseYzRepository<Y> getYzRepository();

	protected abstract BaseZfRepository<Z> getZfRepository();

	protected abstract BaseSwRepository<S> getSwRepository();

	protected abstract List<List<Integer>> getNums();

	private int reverseCols = 5;

	private int length = 12;

	protected Class<Y> yzClass;

	protected Class<Z> zfClass;

	protected Class<S> swClass;

	@SuppressWarnings("unchecked")
	public Lhc3BaseService() {
		yzClass = (Class<Y>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		zfClass = (Class<Z>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		swClass = (Class<S>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
	}

	@Async
	public Future<Exception> cal(List<Lhc3Tm> tmList, int limitedRows) {
		Exception t = null;
		try {
			for (Lhc3Tm newTm : tmList) {
				Long lastId = newTm.getId() - 1;
				Optional<Y> lastYzOp = getYzRepository().findById(lastId);
				Y lastYz = lastYzOp.orElse(yzClass.newInstance());
				Y yz = yzClass.newInstance();
				yz.setNum(newTm.getNum());
				yz.setPhase(newTm.getPhase());
				int index = 1;
				List<Integer> yzValueList = new ArrayList<>();
				for (List<Integer> nums : getNums()) {
					Method tm = ReflectionUtils.findMethod(yz.getClass(), "getT" + index);
					Method wm = ReflectionUtils.findMethod(yz.getClass(), "getW" + index);
					Method ltm = ReflectionUtils.findMethod(yz.getClass(), "getLt" + index);
					Method swm = ReflectionUtils.findMethod(yz.getClass(), "setW" + index, int.class);
					Method stm = ReflectionUtils.findMethod(yz.getClass(), "setT" + index, int.class);
					Method sltm = ReflectionUtils.findMethod(yz.getClass(), "setLt" + index, int.class);
					if (nums.contains(newTm.getNum())) {
						swm.invoke(yz, 0);
						yz.setPos(index);
					} else {
						Integer value = ((Integer) wm.invoke(lastYz)) + 1;
						yzValueList.add(value);
						swm.invoke(yz, value);
					}
					stm.invoke(yz, ((Integer) tm.invoke(lastYz)) + ((Integer) wm.invoke(yz)));
					Optional<Y> lastLimitedYzOp = getYzRepository().findById(lastId - limitedRows + 1);
					if (lastLimitedYzOp.isPresent()) {
						sltm.invoke(yz, ((Integer) ltm.invoke(lastYz)) + ((Integer) wm.invoke(yz)) - ((Integer) wm.invoke(lastLimitedYzOp.get())));
					} else {
						sltm.invoke(yz, ((Integer) ltm.invoke(lastYz)) + ((Integer) wm.invoke(yz)));
					}
					index++;
				}
				if(yz.getPos() == 0) {
					String numsStr = "";
					for(List<Integer> nums : getNums()) {
						for(Integer num : nums) {
							numsStr+=num+",";
						}
					}
					log.info(numsStr);
				}
				Collections.sort(yzValueList);
				Collections.reverse(yzValueList);
				yz.setMaxColYz(yzValueList.get(0));
				int rColsYz = 0;
				int totalColsYz = 0;
				index = 0;
				for (Integer value : yzValueList) {
					if (index < reverseCols) {
						rColsYz += value;
					}
					totalColsYz += value;
					index++;
				}
				yz.setRColsYz(rColsYz);
				yz.setTotalColsYz(totalColsYz);
				yz = getYzRepository().save(yz);
				if (getZfRepository() != null) {
					calZf(yz, limitedRows);
				}
				if (getSwRepository() != null) {
					calSw(yz, limitedRows);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<>(t);
	}

	protected void calZf(PosBaseEntity yz, int limitedRows) throws Exception {
		Long lastId = yz.getId() - 1;
		Optional<Y> lastYzOp = getYzRepository().findById(lastId);
		if (!lastYzOp.isPresent()) {
			return;
		}
		Y lastYz = lastYzOp.get();
		Optional<Z> lastZfOp = getZfRepository().findById(lastId);
		Z lastZf = lastZfOp.orElse(zfClass.newInstance());
		Z zf = zfClass.newInstance();
		zf.setNum(yz.getNum());
		zf.setPhase(yz.getPhase());
		zf.setPos(yz.getPos());
		int delta = yz.getPos() - lastYz.getPos();
		if (delta < 0) {
			delta += length;
		}
		List<Integer> zfValueList = new ArrayList<>();
		for (int j = 1; j <= length; j++) {
			Method wm = ReflectionUtils.findMethod(zf.getClass(), "getW" + j);
			Method tm = ReflectionUtils.findMethod(zf.getClass(), "getT" + j);
			Method ltm = ReflectionUtils.findMethod(zf.getClass(), "getLt" + j);
			Method swm = ReflectionUtils.findMethod(zf.getClass(), "setW" + j, int.class);
			Method stm = ReflectionUtils.findMethod(zf.getClass(), "setT" + j, int.class);
			Method sltm = ReflectionUtils.findMethod(zf.getClass(), "setLt" + j, int.class);
			if (j != delta) {
				int value = (int) wm.invoke(lastZf);
				zfValueList.add(value);
				swm.invoke(zf, value + 1);
			} else {
				swm.invoke(zf, 0);
			}
			stm.invoke(yz, ((Integer) tm.invoke(lastYz)) + ((Integer) wm.invoke(yz)));
			Optional<Z> lastLimitedZfOp = getZfRepository().findById(lastId - limitedRows + 1);
			if (lastLimitedZfOp.isPresent()) {
				sltm.invoke(zf, ((Integer) ltm.invoke(lastZf)) + ((Integer) wm.invoke(zf)) - ((Integer) wm.invoke(lastLimitedZfOp.get())));
			} else {
				sltm.invoke(zf, ((Integer) ltm.invoke(lastZf)) + ((Integer) wm.invoke(zf)));
			}
		}
		Collections.sort(zfValueList);
		Collections.reverse(zfValueList);
		yz.setMaxColYz(zfValueList.get(0));
		int rColsZf = 0;
		int totalColsZf = 0;
		int index = 0;
		for (Integer value : zfValueList) {
			if (index < reverseCols) {
				rColsZf += value;
			}
			totalColsZf += value;
			index++;
		}
		zf.setRColsYz(rColsZf);
		zf.setTotalColsYz(totalColsZf);
		getZfRepository().save(zf);
	}

	protected void calSw(PosBaseEntity yz, int limitedRows) throws Exception {
		Long lastId = yz.getId() - 1;
		Optional<Y> lastYzOp = getYzRepository().findById(lastId);
		if (!lastYzOp.isPresent()) {
			return;
		}
		Y lastYz = lastYzOp.get();
		Optional<S> lastSwOp = getSwRepository().findById(lastId);
		S lastSw = lastSwOp.orElse(swClass.newInstance());
		S sw = swClass.newInstance();
		sw.setNum(yz.getNum());
		sw.setPhase(yz.getPhase());
		sw.setPos(yz.getPos());

		List<PosYzInfo> lastInfoList = new ArrayList<>();
		for (int j = 1; j <= length; j++) {
			Method m = ReflectionUtils.findMethod(yz.getClass(), "getW" + j);
			PosYzInfo info = new PosYzInfo(j, (int) m.invoke(lastYz));
			lastInfoList.add(info);
		}
		Collections.sort(lastInfoList, new Comparator<PosYzInfo>() {

			@Override
			public int compare(PosYzInfo o1, PosYzInfo o2) {
				return o1.getYz().compareTo(o2.getYz());
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
		dealInfoList(sw, lastSw, infoList, pos + 1, lastId, limitedRows);
		getSwRepository().save(sw);
	}

	protected void dealInfoList(S sw, S lastSw, List<PosYzInfo> infoList, int pos, Long lastId, int limitedRows) throws Exception {
		List<Integer> swValueList = new ArrayList<>();
		for (int j = 1; j <= infoList.size(); j++) {
			Method tm = ReflectionUtils.findMethod(sw.getClass(), "getT" + j);
			Method wm = ReflectionUtils.findMethod(sw.getClass(), "getW" + j);
			Method ltm = ReflectionUtils.findMethod(sw.getClass(), "getLt" + j);
			Method swm = ReflectionUtils.findMethod(sw.getClass(), "setW" + j, int.class);
			Method stm = ReflectionUtils.findMethod(sw.getClass(), "setT" + j, int.class);
			Method sltm = ReflectionUtils.findMethod(sw.getClass(), "setLt" + j, int.class);
			Method swpm = ReflectionUtils.findMethod(sw.getClass(), "setW" + j + "Pos", int.class);
			swpm.invoke(sw, infoList.get(j - 1).getPos());
			if (pos != j) {
				int value = (int) wm.invoke(lastSw);
				swm.invoke(sw, value + 1);
				swValueList.add(value);
			} else {
				swm.invoke(sw, 0);
			}
			stm.invoke(sw, ((Integer) tm.invoke(lastSw)) + ((Integer) wm.invoke(sw)));
			Optional<Z> lastLimitedSwOp = getZfRepository().findById(lastId - limitedRows + 1);
			if (lastLimitedSwOp.isPresent()) {
				sltm.invoke(sw, ((Integer) ltm.invoke(lastSw)) + ((Integer) wm.invoke(sw)) - ((Integer) wm.invoke(lastLimitedSwOp.get())));
			} else {
				sltm.invoke(sw, ((Integer) ltm.invoke(lastSw)) + ((Integer) wm.invoke(sw)));
			}
		}
		Collections.sort(swValueList);
		Collections.reverse(swValueList);
		sw.setMaxColYz(swValueList.get(0));
		int rColsZf = 0;
		int totalColsZf = 0;
		int index = 0;
		for (Integer value : swValueList) {
			if (index < reverseCols) {
				rColsZf += value;
			}
			totalColsZf += value;
			index++;
		}
		sw.setRColsYz(rColsZf);
		sw.setTotalColsYz(totalColsZf);
	}

}