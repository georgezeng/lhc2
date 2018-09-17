package net.geozen.lhc2.service.sx;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.domain.Tm;
import net.geozen.lhc2.domain.sx.Sxyz;
import net.geozen.lhc2.enums.SX;
import net.geozen.lhc2.jpa.TmRepository;
import net.geozen.lhc2.jpa.sx.SxyzRepository;
import net.geozen.lhc2.service.CalculationService;
import net.geozen.lhc2.utils.SystemConstants;

@Service
@Slf4j
public class SxyzCalculationService {

	@Autowired
	private TmRepository tmRepository;

	@Autowired
	private SxyzRepository yzRepository;

	@Autowired
	private SxzfCalculationService zfService;

	@Autowired
	private SxswCalculationService swService;

	@Autowired
	private CalculationService calService;

	@Transactional
	@Async
	public Future<Exception> process() {
		Exception t = null;
		try {
			Pageable pageable = PageRequest.of(0, SystemConstants.CALCULATION_SIZE, Direction.DESC, "phase");
			List<Tm> datas = tmRepository.findAll(pageable).getContent();
			Sxyz lastYz = new Sxyz();
			List<Sxyz> yzList = new ArrayList<>();
			for (int i = datas.size() - 1; i > -1; i--) {
				Tm data = datas.get(i);
				Sxyz yz = new Sxyz();
				yz.setPhase(data.getPhase());
				yz.setNum(data.getNum());
				yz.setSx(data.getSx());
				for (SX sx : SX.seq()) {
					Method setMethod = yz.getClass().getDeclaredMethod("set" + sx.getColumn(), int.class);
					if (sx.equals(data.getSx())) {
						setMethod.invoke(yz, 0);
					} else {
						Method getMethod = yz.getClass().getDeclaredMethod("get" + sx.getColumn());
						int value = (int) getMethod.invoke(lastYz);
						setMethod.invoke(yz, value + 1);
					}
				}
				lastYz = yz;
				yzList.add(yz);
			}
			yzRepository.deleteAll();
			yzRepository.saveAll(yzList);
			calService.addFuture(zfService.process(yzList));
			calService.addFuture(swService.process(yzList));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<>(t);
	}

}
