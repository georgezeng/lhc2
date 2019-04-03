package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqiYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqiZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqiSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
