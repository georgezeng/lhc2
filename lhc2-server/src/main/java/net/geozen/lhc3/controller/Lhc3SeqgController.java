package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgSw;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgYz;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgZf;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgSwRepository;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgYzRepository;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqg")
public class Lhc3SeqgController {

	@Autowired
	private Lhc3SeqgYzRepository yzRepository;

	@Autowired
	private Lhc3SeqgZfRepository zfRepository;

	@Autowired
	private Lhc3SeqgSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqgYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqgZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqgSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
