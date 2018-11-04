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

	private boolean summaryInit;

	private int status = 0;

	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public Result<List<String>> calculate() throws Exception {
//		summaryInit = false;
//		status = 1;
		List<String> errors = new ArrayList<>();
		calService.process(errors);
		calService.summary(errors);
		return Result.genSuccessResult(errors);
	}

//	@RequestMapping(value = "/calculation/status", method = RequestMethod.GET)
//	public Result<Map<String, Object>> calculationStatus() throws Exception {
//		int count = 0;
//		int currentStatus = status;
//		Map<String, Object> result = new HashMap<>();
//		List<String> errors = new ArrayList<>();
//		for (Future<Exception> f : calService.getFutures1()) {
//			if (f.isDone()) {
//				if (f.get() != null) {
//					status = 2;
//					errors.add(f.get().getMessage());
//					break;
//				}
//				count++;
//			}
//		}
//		if (status == 1 && count > 0 && count == calService.getFutures1().size()) {
//			calService.getFutures1().clear();
//			if (!summaryInit) {
//				summaryInit = true;
//				calService.summary();
//			}
//			count = 0;
//			errors = new ArrayList<>();
//			for (Future<Exception> f : calService.getFutures2()) {
//				if (f.isDone()) {
//					if (f.get() != null) {
//						status = 2;
//						errors.add(f.get().getMessage());
//						break;
//					}
//					count++;
//				}
//			}
//			if (status == 1) {
//				if (count > 0 && count == calService.getFutures2().size()) {
//					status = 2;
//				}
//			}
//			if (status == 2) {
//				calService.getFutures2().clear();
//			}
//		}
//		currentStatus = status;
//		if (status == 2) {
//			status = 0;
//		}
//		result.put("errors", errors);
//		result.put("status", currentStatus);
//		return Result.genSuccessResult(result);
//	}

	@RequestMapping(value = "/statInfo/1", method = RequestMethod.GET)
	public Result<List<StatTotallyInfo>> getStatInfo1() {
		return Result.genSuccessResult(combineService.list1());
	}

	@RequestMapping(value = "/statInfo/2", method = RequestMethod.GET)
	public Result<List<StatTotallyInfo>> getStatInfo2() {
		return Result.genSuccessResult(combineService.list2());
	}
}
