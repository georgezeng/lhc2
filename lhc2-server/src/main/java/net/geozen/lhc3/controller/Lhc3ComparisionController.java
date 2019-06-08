package net.geozen.lhc3.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.PageResult;
import net.geozen.lhc2.dto.QueryInfo;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.Lhc3ColorYz;
import net.geozen.lhc3.domain.Lhc3ColorYz2;
import net.geozen.lhc3.domain.Lhc3TimesYz;
import net.geozen.lhc3.jpa.Lhc3ColorYz2Repository;
import net.geozen.lhc3.jpa.Lhc3ColorYzRepository;
import net.geozen.lhc3.jpa.Lhc3TimesYzRepository;

@RestController
@RequestMapping(value = "/lhc3/comparision")
public class Lhc3ComparisionController {

	@Autowired
	private Lhc3TimesYzRepository timesYzRepository;

	@Autowired
	private Lhc3ColorYzRepository colorYzRepository;

	@Autowired
	private Lhc3ColorYz2Repository colorYz2Repository;

	@RequestMapping(value = "/times/{tables}/{type}")
	public Result<PageResult<Lhc3TimesYz>> getComparisionTimes(@PathVariable("tables") String tables,
			@PathVariable("type") String type, @RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3TimesYz> result = timesYzRepository.findAllByTablesAndType(tables, type,
				queryInfo.getPage().pageable());
		if (queryInfo.getPage().getNum() == 1 && result.hasContent()) {
			List<Lhc3TimesYz> list = new LinkedList<>(result.getContent());
			Lhc3TimesYz first = list.get(0);

			Lhc3TimesYz topForTotal = new Lhc3TimesYz();
			topForTotal.setPhase("红点个数/白点1个数(无限制)");
			topForTotal.setTime03Plus(first.getT03Plus());
			topForTotal.setTime12(first.getT12());
			topForTotal.setTime2Plus(first.getT2Plus());
			list.add(0, topForTotal);

			Lhc3TimesYz topForLimitedTotal = new Lhc3TimesYz();
			topForLimitedTotal.setPhase("红点个数/白点1个数(有限制)");
			topForLimitedTotal.setTime03Plus(first.getLt03Plus());
			topForLimitedTotal.setTime12(first.getLt12());
			topForLimitedTotal.setTime2Plus(first.getLt2Plus());
			list.add(0, topForLimitedTotal);
			return Result.genSuccessResult(new PageResult<>(list, result.getTotalElements()));
		}
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/colors/{tables}/{type}")
	public Result<PageResult<Lhc3ColorYz>> getComparisionColors(@PathVariable("tables") String tables,
			@PathVariable("type") String type, @RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3ColorYz> result = colorYzRepository.findAllByTablesAndType(tables, type,
				queryInfo.getPage().pageable());
		if (queryInfo.getPage().getNum() == 1 && result.hasContent()) {
			List<Lhc3ColorYz> list = new LinkedList<>(result.getContent());
			Lhc3ColorYz first = list.get(0);

			Lhc3ColorYz topForTotal = new Lhc3ColorYz();
			topForTotal.setPhase("白点1个数(无限制)");
			topForTotal.setG1(first.getTG1());
			topForTotal.setG2(first.getTG2());
			topForTotal.setG3(first.getTG3());
			topForTotal.setG4(first.getTG4());
			topForTotal.setG5(first.getTG5());
			topForTotal.setG6(first.getTG6());
			topForTotal.setG7(first.getTG7());
			topForTotal.setG8(first.getTG8());
			topForTotal.setR1(first.getTR1());
			topForTotal.setR2(first.getTR2());
			topForTotal.setR3(first.getTR3());
			topForTotal.setR4(first.getTR4());
			topForTotal.setR5(first.getTR5());
			topForTotal.setR6(first.getTR6());
			topForTotal.setR7(first.getTR7());
			topForTotal.setR8(first.getTR8());
			list.add(0, topForTotal);

			Lhc3ColorYz topForLimitedTotal = new Lhc3ColorYz();
			topForLimitedTotal.setPhase("白点1个数(有限制)");
			topForLimitedTotal.setG1(first.getLtG1());
			topForLimitedTotal.setG2(first.getLtG2());
			topForLimitedTotal.setG3(first.getLtG3());
			topForLimitedTotal.setG4(first.getLtG4());
			topForLimitedTotal.setG5(first.getLtG5());
			topForLimitedTotal.setG6(first.getLtG6());
			topForLimitedTotal.setG7(first.getLtG7());
			topForLimitedTotal.setG8(first.getLtG8());
			topForLimitedTotal.setR1(first.getLtR1());
			topForLimitedTotal.setR2(first.getLtR2());
			topForLimitedTotal.setR3(first.getLtR3());
			topForLimitedTotal.setR4(first.getLtR4());
			topForLimitedTotal.setR5(first.getLtR5());
			topForLimitedTotal.setR6(first.getLtR6());
			topForLimitedTotal.setR7(first.getLtR7());
			topForLimitedTotal.setR8(first.getLtR8());
			list.add(0, topForLimitedTotal);
			return Result.genSuccessResult(new PageResult<>(list, result.getTotalElements()));
		}
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/colors2/{tables}/{type}")
	public Result<PageResult<Lhc3ColorYz2>> getComparisionColors2(@PathVariable("tables") String tables,
			@PathVariable("type") String type, @RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3ColorYz2> result = colorYz2Repository.findAllByTablesAndType(tables, type,
				queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
