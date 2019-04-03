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
import net.geozen.lhc3.domain.fd.Lhc3FdSw;
import net.geozen.lhc3.domain.fd.Lhc3FdYz;
import net.geozen.lhc3.jpa.fd.Lhc3FdSwRepository;
import net.geozen.lhc3.jpa.fd.Lhc3FdYzRepository;

@RestController
@RequestMapping(value = "/lhc3/fd")
public class Lhc3FdController {

	@Autowired
	private Lhc3FdYzRepository yzRepository;

	@Autowired
	private Lhc3FdSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3FdYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3FdYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3FdSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3FdSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
