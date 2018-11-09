package net.geozen.lhc2.controller;

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

	private volatile Future<List<String>> future;

	private int status = 0;

	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public void calculate() throws Exception {
		status = 1;
		future = calService.process();
	}

	@RequestMapping(value = "/calculation/status", method = RequestMethod.GET)
	public Result<Map<String, Object>> calculationStatus() throws Exception {
		Map<String, Object> result = new HashMap<>();
		boolean finished = future != null && future.isDone();
		if (finished) {
			status = 0;
			result.put("errors", future.get());
			result.put("status", 2);
			future = null;
		} else {
			result.put("status", status);
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
