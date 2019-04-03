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
import net.geozen.lhc3.domain.seqe.Lhc3SeqeSw;
import net.geozen.lhc3.domain.seqe.Lhc3SeqeYz;
import net.geozen.lhc3.domain.seqe.Lhc3SeqeZf;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeSwRepository;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeYzRepository;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqe")
public class Lhc3SeqeController {

	@Autowired
	private Lhc3SeqeYzRepository yzRepository;

	@Autowired
	private Lhc3SeqeZfRepository zfRepository;

	@Autowired
	private Lhc3SeqeSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqeYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqeYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqeZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqeZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqeSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqeSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
