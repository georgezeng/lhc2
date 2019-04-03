package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcSw;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcYz;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcZf;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcSwRepository;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcYzRepository;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqc")
public class Lhc3SeqcController {

	@Autowired
	private Lhc3SeqcYzRepository yzRepository;

	@Autowired
	private Lhc3SeqcZfRepository zfRepository;

	@Autowired
	private Lhc3SeqcSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqcYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqcZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqcSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
