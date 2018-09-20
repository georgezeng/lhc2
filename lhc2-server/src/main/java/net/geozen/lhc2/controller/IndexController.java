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

	private int finishCount = 0;

	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public void calculate() {
		finishCount = 0;
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
		if (count > 0 && count == calService.getFutures().size()) {
			calService.getFutures().clear();
			finishCount++;
			if (finishCount == 1) {
				calService.combine();
			}
		}
		result.put("errors", errors);
		result.put("finished", finishCount);
		if (finishCount > 1) {
			finishCount = 0;
		}
		return Result.genSuccessResult(result);
	}

	@RequestMapping(value = "/statInfo/1", method = RequestMethod.GET)
	public Result<List<StatTotallyInfo>> getStatInfo1() {
		return Result.genSuccessResult(combineService.list1());
	}
	
	@RequestMapping(value = "/statInfo/2", method = RequestMethod.GET)
	public Result<List<StatTotallyInfo>> getStatInfo2() {
		return Result.genSuccessResult(combineService.list2());
	}
}
