package net.geozen.lhc2.service.sx;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.domain.Sxsw;
import net.geozen.lhc2.domain.Sxyz;
import net.geozen.lhc2.enums.SX;
import net.geozen.lhc2.jpa.sx.SxswRepository;
import net.geozen.lhc2.service.base.SxYzInfo;

@Service
@Slf4j
public class SxswCalculationService {

	@Autowired
	private SxswRepository swRepository;

	@Transactional
	@Async
	public Future<Exception> process(List<Sxyz> yzList) {
		Exception t = null;
		try {
			Sxsw lastSw = new Sxsw();
			List<Sxsw> list = new ArrayList<>();
			for (int i = 1; i < yzList.size(); i++) {
				Sxyz lastYz = yzList.get(i - 1);
				Sxyz yz = yzList.get(i);
				List<SxYzInfo> lastInfoList = new ArrayList<>();
				for (SX sx : SX.seq()) {
					Method getMethod = yz.getClass().getDeclaredMethod("get" + sx.getColumn());
					SxYzInfo info = new SxYzInfo(sx, (int) getMethod.invoke(lastYz));
					lastInfoList.add(info);
				}
				Collections.sort(lastInfoList, new Comparator<SxYzInfo>() {

					@Override
					public int compare(SxYzInfo o1, SxYzInfo o2) {
						return Integer.valueOf(o1.getYz()).compareTo(Integer.valueOf(o2.getYz()));
					}

				});
				SX redPointSx = yz.getSx();
				int pos = 0;
				List<SxYzInfo> infoList = new LinkedList<>();
				boolean found = false;
				for (SxYzInfo info : lastInfoList) {
					if (info.getSx().equals(redPointSx)) {
						found = true;
					} else {
						infoList.add(info);
					}
					if (!found) {
						pos++;
					}
				}
				infoList.add(0, lastInfoList.get(pos));
				Sxsw sw = new Sxsw();
				sw.setPhase(yz.getPhase());
				sw.setNum(yz.getNum());
				sw.setSx(yz.getSx());
				for (int j = 0; j < infoList.size(); j++) {
					Method setSxMethod = sw.getClass().getDeclaredMethod("setSw" + (j + 1) + "sx", SX.class);
					setSxMethod.invoke(sw, infoList.get(j).getSx());
					Method setYzMethod = sw.getClass().getDeclaredMethod("setSw" + (j + 1), int.class);
					if (pos != j) {
						Method getMethod = sw.getClass().getDeclaredMethod("getSw" + (j + 1));
						int value = (int) getMethod.invoke(lastSw);
						setYzMethod.invoke(sw, value + 1);
					} else {
						setYzMethod.invoke(sw, 0);
					}
				}
				lastSw = sw;
				list.add(sw);
			}
			swRepository.deleteAll();
			swRepository.saveAll(list);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<>(t);
	}

}
