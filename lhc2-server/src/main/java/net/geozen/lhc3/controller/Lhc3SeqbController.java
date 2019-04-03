package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqb.Lhc3SeqbSw;
import net.geozen.lhc3.domain.seqb.Lhc3SeqbYz;
import net.geozen.lhc3.domain.seqb.Lhc3SeqbZf;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbSwRepository;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbYzRepository;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqb")
public class Lhc3SeqbController {

	@Autowired
	private Lhc3SeqbYzRepository yzRepository;

	@Autowired
	private Lhc3SeqbZfRepository zfRepository;

	@Autowired
	private Lhc3SeqbSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqbYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqbZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqbSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
