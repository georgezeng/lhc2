package net.geozen.lhc2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.Getter;
import net.geozen.lhc2.service.mw.MwyzCalculationService;
import net.geozen.lhc2.service.sw.SwyzCalculationService;
import net.geozen.lhc2.service.sx.SxyzCalculationService;

@Service
@Getter
public class CalculationService {
	private final List<Future<Exception>> futures = new ArrayList<>();

	@Autowired
	private SxyzCalculationService sxService;

	@Autowired
	private SwyzCalculationService swService;

	@Autowired
	private MwyzCalculationService mwService;

	@Async
	public void process() {
		futures.clear();
		futures.add(sxService.process());
		futures.add(swService.process());
		futures.add(mwService.process());
	}

	public void addFuture(Future<Exception> future) {
		futures.add(future);
	}

}
