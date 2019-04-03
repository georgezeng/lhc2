package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmSw;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmYz;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmZf;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmSwRepository;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmYzRepository;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqm")
public class Lhc3SeqmController {

	@Autowired
	private Lhc3SeqmYzRepository yzRepository;

	@Autowired
	private Lhc3SeqmZfRepository zfRepository;

	@Autowired
	private Lhc3SeqmSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqmYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqmZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqmSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
