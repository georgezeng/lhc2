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
import net.geozen.lhc3.domain.seqf.Lhc3SeqfSw;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfYz;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfZf;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfSwRepository;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfYzRepository;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqf")
public class Lhc3SeqfController {

	@Autowired
	private Lhc3SeqfYzRepository yzRepository;

	@Autowired
	private Lhc3SeqfZfRepository zfRepository;

	@Autowired
	private Lhc3SeqfSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqfYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqfYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqfZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqfZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqfSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqfSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
