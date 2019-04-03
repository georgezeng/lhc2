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
import net.geozen.lhc3.domain.seqb.Lhc3SeqbSw;
import net.geozen.lhc3.domain.seqb.Lhc3SeqbYz;
import net.geozen.lhc3.domain.seqb.Lhc3SeqbZf;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbSwRepository;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbYzRepository;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqb")
public class Lhc3SeqbController {

	@Autowired
	private Lhc3SeqbYzRepository yzRepository;

	@Autowired
	private Lhc3SeqbZfRepository zfRepository;

	@Autowired
	private Lhc3SeqbSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqbYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqbYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqbZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqbZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqbSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqbSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
