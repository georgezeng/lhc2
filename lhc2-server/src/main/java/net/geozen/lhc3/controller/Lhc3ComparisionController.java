package net.geozen.lhc3.controller;

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
	public Result<PageResult<Lhc3TimesYz>> getComparisionTimes(@PathVariable("tables") String tables, @PathVariable("type") String type,
			@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3TimesYz> result = timesYzRepository.findAllByTablesAndType(tables, type, queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/colors/{tables}/{type}")
	public Result<PageResult<Lhc3ColorYz>> getComparisionColors(@PathVariable("tables") String tables, @PathVariable("type") String type,
			@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3ColorYz> result = colorYzRepository.findAllByTablesAndType(tables, type, queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/colors2/{tables}/{type}")
	public Result<PageResult<Lhc3ColorYz2>> getComparisionColors2(@PathVariable("tables") String tables, @PathVariable("type") String type,
			@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3ColorYz2> result = colorYz2Repository.findAllByTablesAndType(tables, type, queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
