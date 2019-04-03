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
import net.geozen.lhc3.domain.seqh.Lhc3SeqhSw;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhYz;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhZf;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhSwRepository;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhYzRepository;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqh")
public class Lhc3SeqhController {

	@Autowired
	private Lhc3SeqhYzRepository yzRepository;

	@Autowired
	private Lhc3SeqhZfRepository zfRepository;

	@Autowired
	private Lhc3SeqhSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqhYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqhYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqhZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqhZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqhSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqhSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
