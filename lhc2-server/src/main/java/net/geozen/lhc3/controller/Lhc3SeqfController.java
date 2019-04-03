package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfSw;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfYz;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfZf;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfSwRepository;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfYzRepository;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqf")
public class Lhc3SeqfController {

	@Autowired
	private Lhc3SeqfYzRepository yzRepository;

	@Autowired
	private Lhc3SeqfZfRepository zfRepository;

	@Autowired
	private Lhc3SeqfSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqfYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqfZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqfSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
