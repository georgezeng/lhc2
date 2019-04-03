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
import net.geozen.lhc3.domain.seqp.Lhc3SeqpSw;
import net.geozen.lhc3.domain.seqp.Lhc3SeqpYz;
import net.geozen.lhc3.domain.seqp.Lhc3SeqpZf;
import net.geozen.lhc3.jpa.seqp.Lhc3SeqpSwRepository;
import net.geozen.lhc3.jpa.seqp.Lhc3SeqpYzRepository;
import net.geozen.lhc3.jpa.seqp.Lhc3SeqpZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqp")
public class Lhc3SeqpController {

	@Autowired
	private Lhc3SeqpYzRepository yzRepository;

	@Autowired
	private Lhc3SeqpZfRepository zfRepository;

	@Autowired
	private Lhc3SeqpSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqpYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqpYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqpZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqpZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqpSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqpSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
