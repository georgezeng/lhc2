package net.geozen.lhc2.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.domain.Sxyz;
import net.geozen.lhc2.domain.Sxzf;
import net.geozen.lhc2.enums.SX;
import net.geozen.lhc2.jpa.SxzfRepository;

@Service
@Slf4j
public class SXZFCalculationService {

	@Autowired
	private SxzfRepository sxzfRepository;

	@Transactional
	@Async
	public Future<Exception> process(List<Sxyz> yzList) {
		Exception t = null;
		try {
			int len = SX.seq().length;
			Sxzf lastZf = new Sxzf();
			List<Sxzf> list = new ArrayList<>();
			for (int i = 1; i < yzList.size(); i++) {
				Sxyz lastYz = yzList.get(i - 1);
				Sxyz yz = yzList.get(i);
				int delta = yz.getSx().getPos() - lastYz.getSx().getPos();
				if (delta < 0) {
					delta += len;
				}
				Sxzf zf = new Sxzf();
				zf.setPhase(yz.getPhase());
				zf.setNum(yz.getNum());
				zf.setSx(yz.getSx());
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
			sxzfRepository.deleteAll();
			sxzfRepository.saveAll(list);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<>(t);
	}

}
