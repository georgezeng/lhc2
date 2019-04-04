package net.geozen.lhc3.service;

import java.lang.reflect.Method;
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
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.service.base.PosYzInfo;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.domain.fd.Lhc3FdSw;
import net.geozen.lhc3.domain.fd.Lhc3FdYz;
import net.geozen.lhc3.jpa.fd.Lhc3FdSwRepository;
import net.geozen.lhc3.jpa.fd.Lhc3FdYzRepository;

@Service
@Slf4j
public class Lhc3FdService {
	@Autowired
	private Lhc3FdYzRepository yzRepository;
	@Autowired
	private Lhc3FdSwRepository swRepository;

	private int reverseCols = 5;

	@Async
	public Future<Exception> cal(List<Lhc3Tm> tmList, int limitedRows) {
		Exception t = null;
		try {
			for (Lhc3Tm newTm : tmList) {
				Optional<Lhc3FdYz> lastYzOp = yzRepository.findById(newTm.getId() - 1);
				Lhc3FdYz lastYz = lastYzOp.orElseGet(Lhc3FdYz::new);
				if (newTm.getPhase().equals(lastYz.getPhase())) {
					continue;
				}
				Lhc3FdYz yz = new Lhc3FdYz();
				yz.setNum(newTm.getNum());
				yz.setPhase(newTm.getPhase());
				for (int num = 1; num < 50; num++) {
					Method wm = ReflectionUtils.findMethod(yz.getClass(), "getW" + num);
					Method swm = ReflectionUtils.findMethod(yz.getClass(), "setW" + num, int.class);
					if (num == newTm.getNum()) {
						swm.invoke(yz, 0);
						yz.setPos(num);
					} else {
						Integer value = ((Integer) wm.invoke(lastYz)) + 1;
						swm.invoke(yz, value);
					}
				}
				yz = yzRepository.save(yz);
				calSw(yz, limitedRows);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<>(t);
	}

	private void calSw(Lhc3FdYz yz, int limitedRows) throws Exception {
		Long lastId = yz.getId() - 1;
		Optional<Lhc3FdYz> lastYzOp = yzRepository.findById(lastId);
		if (!lastYzOp.isPresent()) {
			return;
		}
		Lhc3FdYz lastYz = lastYzOp.get();
		if (yz.getPhase().equals(lastYz.getPhase())) {
			return;
		}
		Optional<Lhc3FdSw> lastSwOp = swRepository.findByPhase(lastYz.getPhase());
		Lhc3FdSw lastSw = lastSwOp.orElseGet(Lhc3FdSw::new);
		Lhc3FdSw sw = new Lhc3FdSw();
		sw.setNum(yz.getNum());
		sw.setPhase(yz.getPhase());
		sw.setPos(yz.getPos());

		List<PosYzInfo> lastInfoList = new ArrayList<>();
		for (int j = 1; j <= 49; j++) {
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
		dealInfoList(sw, lastSw, infoList, pos, lastId, limitedRows);
		swRepository.save(sw);
	}

	protected void dealInfoList(Lhc3FdSw sw, Lhc3FdSw lastSw, List<PosYzInfo> infoList, int pos, Long lastId, int limitedRows) throws Exception {
		List<Integer> nums = new ArrayList<>();
		List<Integer> swValueList = new ArrayList<>();
		int count = 1;
		for (int i = 0; i < infoList.size(); i++) {
			int j = i + 1;
			int num = infoList.get(i).getPos() + 1;
			nums.add(num);
			if (j < 48 && j % 4 == 0 || j == 49) {
				Method sm = ReflectionUtils.findMethod(sw.getClass(), "setW" + count++ + "Arr", String.class);
				sm.invoke(sw, StringUtils.collectionToCommaDelimitedString(nums));
				nums = new ArrayList<>();

				int index = i / 4;
				if (index == 12) {
					index = 11;
				}
				if (pos == 48) {
					pos = 47;
				}
				int wpos = index + 1;
				Method tm = ReflectionUtils.findMethod(sw.getClass(), "getT" + wpos);
				Method wm = ReflectionUtils.findMethod(sw.getClass(), "getW" + wpos);
				Method ltm = ReflectionUtils.findMethod(sw.getClass(), "getLt" + wpos);
				Method swm = ReflectionUtils.findMethod(sw.getClass(), "setW" + wpos, int.class);
				Method stm = ReflectionUtils.findMethod(sw.getClass(), "setT" + wpos, int.class);
				Method sltm = ReflectionUtils.findMethod(sw.getClass(), "setLt" + wpos, int.class);
				if ((pos / 4) != index) {
					int value = (int) wm.invoke(lastSw) + 1;
					swValueList.add(value);
					swm.invoke(sw, value);
				} else {
					swm.invoke(sw, 0);
				}
				int numsCount = (int) wm.invoke(sw) > 0 ? 1 : 0;
				stm.invoke(sw, (int) tm.invoke(lastSw) + numsCount);
				Optional<Lhc3FdSw> lastLimitedSwOp = swRepository.findById(lastId - limitedRows);
				if (lastLimitedSwOp.isPresent()) {
					int lastLimitedCount = (int) wm.invoke(lastLimitedSwOp.get()) > 0 ? 1 : 0;
					sltm.invoke(sw, (int) ltm.invoke(lastSw) + numsCount - lastLimitedCount);
				} else {
					sltm.invoke(sw, (int) ltm.invoke(lastSw) + numsCount);
				}
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
