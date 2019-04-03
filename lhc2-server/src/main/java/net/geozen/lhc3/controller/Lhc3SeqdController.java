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
import net.geozen.lhc3.domain.seqd.Lhc3SeqdSw;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdYz;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdZf;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdSwRepository;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdYzRepository;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqd")
public class Lhc3SeqdController {

	@Autowired
	private Lhc3SeqdYzRepository yzRepository;

	@Autowired
	private Lhc3SeqdZfRepository zfRepository;

	@Autowired
	private Lhc3SeqdSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqdYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqdYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqdZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqdZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqdSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqdSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
