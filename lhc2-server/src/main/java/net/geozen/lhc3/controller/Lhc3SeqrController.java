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
import net.geozen.lhc3.domain.seqr.Lhc3SeqrSw;
import net.geozen.lhc3.domain.seqr.Lhc3SeqrYz;
import net.geozen.lhc3.domain.seqr.Lhc3SeqrZf;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrSwRepository;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrYzRepository;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqr")
public class Lhc3SeqrController {

	@Autowired
	private Lhc3SeqrYzRepository yzRepository;

	@Autowired
	private Lhc3SeqrZfRepository zfRepository;

	@Autowired
	private Lhc3SeqrSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqrYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqrYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqrZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqrZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqrSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqrSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
