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
import net.geozen.lhc3.domain.seqq.Lhc3SeqqSw;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqYz;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqZf;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqSwRepository;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqYzRepository;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqq")
public class Lhc3SeqqController {

	@Autowired
	private Lhc3SeqqYzRepository yzRepository;

	@Autowired
	private Lhc3SeqqZfRepository zfRepository;

	@Autowired
	private Lhc3SeqqSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqqYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqqYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqqZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqqZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqqSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqqSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
