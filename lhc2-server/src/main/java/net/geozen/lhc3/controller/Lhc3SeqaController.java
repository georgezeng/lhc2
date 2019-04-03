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
import net.geozen.lhc3.domain.seqa.Lhc3SeqaSw;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaYz;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaZf;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaSwRepository;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaYzRepository;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqa")
public class Lhc3SeqaController {

	@Autowired
	private Lhc3SeqaYzRepository yzRepository;

	@Autowired
	private Lhc3SeqaZfRepository zfRepository;

	@Autowired
	private Lhc3SeqaSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqaYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqaYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqaZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqaZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqaSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqaSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
