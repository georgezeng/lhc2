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
import net.geozen.lhc3.domain.seqi.Lhc3SeqiSw;
import net.geozen.lhc3.domain.seqi.Lhc3SeqiYz;
import net.geozen.lhc3.domain.seqi.Lhc3SeqiZf;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiSwRepository;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiYzRepository;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqi")
public class Lhc3SeqiController {

	@Autowired
	private Lhc3SeqiYzRepository yzRepository;

	@Autowired
	private Lhc3SeqiZfRepository zfRepository;

	@Autowired
	private Lhc3SeqiSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqiYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqiYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqiZf>> zfList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqiZf> result = zfRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3SeqiSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3SeqiSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}
}
