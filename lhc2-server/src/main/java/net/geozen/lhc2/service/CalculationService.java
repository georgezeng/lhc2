package net.geozen.lhc2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
@Getter
public class CalculationService {
	private final List<Future<Exception>> futures = new ArrayList<>();

	@Autowired
	private SXYZCalculationService sxyzService;

	@Async
	public void process() {
		futures.clear();
		futures.add(sxyzService.process());
	}

	public void addFuture(Future<Exception> future) {
		futures.add(future);
	}

}
