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
import net.geozen.lhc3.domain.seqj.Lhc3SeqjSw;
import net.geozen.lhc3.domain.seqj.Lhc3SeqjYz;
import net.geozen.lhc3.domain.seqj.Lhc3SeqjZf;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjSwRepository;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjYzRepository;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqj")
public class Lhc3SeqjController {

	@Autowired
	private Lhc3SeqjYzRepository yzRepository;

	@Autowired
	private Lhc3SeqjZfRepository zfRepository;

	@Autowired
	private Lhc3SeqjSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqjYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqjYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqjZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqjZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqjSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqjSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
