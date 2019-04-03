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
import net.geozen.lhc3.domain.seqg.Lhc3SeqgSw;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgYz;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgZf;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgSwRepository;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgYzRepository;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqg")
public class Lhc3SeqgController {

	@Autowired
	private Lhc3SeqgYzRepository yzRepository;

	@Autowired
	private Lhc3SeqgZfRepository zfRepository;

	@Autowired
	private Lhc3SeqgSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqgYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqgYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqgZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqgZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqgSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqgSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
