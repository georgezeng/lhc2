package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.PageResult;
import net.geozen.lhc2.dto.QueryInfo;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seql.Lhc3SeqlSw;
import net.geozen.lhc3.domain.seql.Lhc3SeqlYz;
import net.geozen.lhc3.domain.seql.Lhc3SeqlZf;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlSwRepository;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlYzRepository;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seql")
public class Lhc3SeqlController {

	@Autowired
	private Lhc3SeqlYzRepository yzRepository;

	@Autowired
	private Lhc3SeqlZfRepository zfRepository;

	@Autowired
	private Lhc3SeqlSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqlYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqlYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqlZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqlZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqlSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqlSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
