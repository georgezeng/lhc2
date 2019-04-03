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
import net.geozen.lhc3.domain.seqn.Lhc3SeqnSw;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnYz;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnZf;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnSwRepository;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnYzRepository;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqn")
public class Lhc3SeqnController {

	@Autowired
	private Lhc3SeqnYzRepository yzRepository;

	@Autowired
	private Lhc3SeqnZfRepository zfRepository;

	@Autowired
	private Lhc3SeqnSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqnYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqnYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqnZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqnZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqnSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqnSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
