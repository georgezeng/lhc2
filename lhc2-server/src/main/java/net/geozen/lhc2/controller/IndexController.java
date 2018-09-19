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
import net.geozen.lhc2.dto.StatTotallyInfo;
import net.geozen.lhc2.service.CalculationService;
import net.geozen.lhc2.service.CombineService;

@RestController
public class IndexController {

	@Autowired
	private CalculationService calService;

	@Autowired
	private CombineService combineService;

	private int finished = 0;

	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public void calculate() {
		finished = 0;
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
		if (count == calService.getFutures().size()) {
			finished++;
			if (finished == 1) {
				calService.combine();
			}
		}
		result.put("errors", errors);
		result.put("finished", finished == 2);
		return Result.genSuccessResult(result);
	}

	@RequestMapping(value = "/statInfo", method = RequestMethod.GET)
	public Result<List<StatTotallyInfo>> getStatInfo() {
		return Result.genSuccessResult(combineService.list());
	}
}
