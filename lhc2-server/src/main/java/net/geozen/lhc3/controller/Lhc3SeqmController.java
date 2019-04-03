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
import net.geozen.lhc3.domain.seqm.Lhc3SeqmSw;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmYz;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmZf;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmSwRepository;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmYzRepository;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqm")
public class Lhc3SeqmController {

	@Autowired
	private Lhc3SeqmYzRepository yzRepository;

	@Autowired
	private Lhc3SeqmZfRepository zfRepository;

	@Autowired
	private Lhc3SeqmSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqmYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqmYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqmZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqmZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqmSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqmSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
