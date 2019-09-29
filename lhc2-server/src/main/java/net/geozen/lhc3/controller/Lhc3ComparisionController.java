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
			topForTotal.setPhase("红白个数(无限)");
			topForTotal.setTime0(first.getT0());
			topForTotal.setTime1(first.getT1());
			topForTotal.setTime2(first.getT2());
			topForTotal.setTime3Plus(first.getT3Plus());
			list.add(0, topForTotal);

			Lhc3TimesYz topForLimitedTotal = new Lhc3TimesYz();
			topForLimitedTotal.setTime0(first.getLt0());
			topForLimitedTotal.setTime1(first.getLt1());
			topForLimitedTotal.setTime2(first.getLt2());
			topForLimitedTotal.setTime3Plus(first.getLt3Plus());
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
			topForTotal.setPhase("白点1个数(无限)");
			topForTotal.setG1(first.gettG1());
			topForTotal.setG2(first.gettG2());
			topForTotal.setG3(first.gettG3());
			topForTotal.setG4(first.gettG4());
			topForTotal.setG5(first.gettG5());
			topForTotal.setG6(first.gettG6());
			topForTotal.setG7(first.gettG7());
			topForTotal.setG8(first.gettG8());
			topForTotal.setR1(first.gettR1());
			topForTotal.setR2(first.gettR2());
			topForTotal.setR3(first.gettR3());
			topForTotal.setR4(first.gettR4());
			topForTotal.setR5(first.gettR5());
			topForTotal.setR6(first.gettR6());
			topForTotal.setR7(first.gettR7());
			topForTotal.setR8(first.gettR8());
			topForTotal.setG1Color("gray");
			topForTotal.setG2Color("gray");
			topForTotal.setG3Color("gray");
			topForTotal.setG4Color("gray");
			topForTotal.setG5Color("gray");
			topForTotal.setG6Color("gray");
			topForTotal.setG7Color("gray");
			topForTotal.setG8Color("gray");
			topForTotal.setR1Color("gray");
			topForTotal.setR2Color("gray");
			topForTotal.setR3Color("gray");
			topForTotal.setR4Color("gray");
			topForTotal.setR5Color("gray");
			topForTotal.setR6Color("gray");
			topForTotal.setR7Color("gray");
			topForTotal.setR8Color("gray");
			list.add(0, topForTotal);

			Lhc3ColorYz topForLimitedTotal = new Lhc3ColorYz();
			topForLimitedTotal.setPhase("白点1个数(有限)");
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
			topForLimitedTotal.setG1Color("gray");
			topForLimitedTotal.setG2Color("gray");
			topForLimitedTotal.setG3Color("gray");
			topForLimitedTotal.setG4Color("gray");
			topForLimitedTotal.setG5Color("gray");
			topForLimitedTotal.setG6Color("gray");
			topForLimitedTotal.setG7Color("gray");
			topForLimitedTotal.setG8Color("gray");
			topForLimitedTotal.setR1Color("gray");
			topForLimitedTotal.setR2Color("gray");
			topForLimitedTotal.setR3Color("gray");
			topForLimitedTotal.setR4Color("gray");
			topForLimitedTotal.setR5Color("gray");
			topForLimitedTotal.setR6Color("gray");
			topForLimitedTotal.setR7Color("gray");
			topForLimitedTotal.setR8Color("gray");
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
		if (queryInfo.getPage().getNum() == 1 && result.hasContent()) {
			List<Lhc3ColorYz2> list = new LinkedList<>(result.getContent());
			Lhc3ColorYz2 first = list.get(0);
			
			Lhc3ColorYz2 topForTotal = new Lhc3ColorYz2();
			topForTotal.setPhase("无限");
			topForTotal.setWrCost(first.getWrCostt());
			topForTotal.setYzrCost(first.getYzrCostt());
			topForTotal.setYzgCost(first.getYzgCostt());
			topForTotal.setWrIncome(first.getWrIncomet());
			topForTotal.setYzrIncome(first.getYzrIncomet());
			topForTotal.setYzgIncome(first.getYzgIncomet());
			list.add(0, topForTotal);
			
			Lhc3ColorYz2 topForLimitedTotal = new Lhc3ColorYz2();
			topForLimitedTotal.setPhase("有限");
			topForLimitedTotal.setWrCost(first.getWrCostlt());
			topForLimitedTotal.setYzrCost(first.getYzrCostlt());
			topForLimitedTotal.setYzgCost(first.getYzgCostlt());
			topForLimitedTotal.setWrIncome(first.getWrIncomelt());
			topForLimitedTotal.setYzrIncome(first.getYzrIncomelt());
			topForLimitedTotal.setYzgIncome(first.getYzgIncomelt());
			list.add(0, topForLimitedTotal);
			return Result.genSuccessResult(new PageResult<>(list, result.getTotalElements()));
		}
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
