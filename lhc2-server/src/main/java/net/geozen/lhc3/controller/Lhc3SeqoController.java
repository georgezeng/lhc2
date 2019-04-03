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
import net.geozen.lhc3.domain.seqo.Lhc3SeqoSw;
import net.geozen.lhc3.domain.seqo.Lhc3SeqoYz;
import net.geozen.lhc3.domain.seqo.Lhc3SeqoZf;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoSwRepository;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoYzRepository;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqo")
public class Lhc3SeqoController {

	@Autowired
	private Lhc3SeqoYzRepository yzRepository;

	@Autowired
	private Lhc3SeqoZfRepository zfRepository;

	@Autowired
	private Lhc3SeqoSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqoYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqoYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqoZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqoZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqoSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqoSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
