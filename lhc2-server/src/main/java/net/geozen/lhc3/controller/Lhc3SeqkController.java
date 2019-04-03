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
import net.geozen.lhc3.domain.seqk.Lhc3SeqkSw;
import net.geozen.lhc3.domain.seqk.Lhc3SeqkYz;
import net.geozen.lhc3.domain.seqk.Lhc3SeqkZf;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkSwRepository;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkYzRepository;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqk")
public class Lhc3SeqkController {

	@Autowired
	private Lhc3SeqkYzRepository yzRepository;

	@Autowired
	private Lhc3SeqkZfRepository zfRepository;

	@Autowired
	private Lhc3SeqkSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqkYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqkYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqkZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqkZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqkSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqkSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
