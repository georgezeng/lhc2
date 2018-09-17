package net.geozen.lhc2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.service.CalculationService;

@RestController
public class IndexController {

	@Autowired
	private CalculationService calService;

	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public void calculate() {
		calService.process();
	}

	@RequestMapping(value = "/calculation/status", method = RequestMethod.GET)
	public Result<Map<String, Object>> calculationStatus() throws Exception {
		int count = 0;
		Map<String, Object> result = new HashMap<>();
		List<String> errors = new ArrayList<>();
		for (Future<Exception> f : calService.getFutures()) {
			if (f.isDone()) {
				if (f.get() != null) {
					errors.add(f.get().getMessage());
				}
				count++;
			}
		}
		result.put("errors", errors);
		result.put("finished", count == calService.getFutures().size());
		return Result.genSuccessResult(result);
	}
}
