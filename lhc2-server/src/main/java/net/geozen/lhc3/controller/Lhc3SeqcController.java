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
import net.geozen.lhc3.domain.seqc.Lhc3SeqcSw;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcYz;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcZf;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcSwRepository;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcYzRepository;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqc")
public class Lhc3SeqcController {

	@Autowired
	private Lhc3SeqcYzRepository yzRepository;

	@Autowired
	private Lhc3SeqcZfRepository zfRepository;

	@Autowired
	private Lhc3SeqcSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqcYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqcYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqcZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqcZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqcSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqcSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
