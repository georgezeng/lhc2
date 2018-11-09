package net.geozen.lhc2.controller;

import java.util.ArrayList;
import java.util.List;

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

	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public Result<List<String>> calculate() throws Exception {
		List<String> errors = new ArrayList<>();
		calService.process(errors);
		calService.summary(errors);
		return Result.genSuccessResult(errors);
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
