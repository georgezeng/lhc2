package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqe.Lhc3SeqeSw;
import net.geozen.lhc3.domain.seqe.Lhc3SeqeYz;
import net.geozen.lhc3.domain.seqe.Lhc3SeqeZf;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeSwRepository;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeYzRepository;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqe")
public class Lhc3SeqeController {

	@Autowired
	private Lhc3SeqeYzRepository yzRepository;

	@Autowired
	private Lhc3SeqeZfRepository zfRepository;

	@Autowired
	private Lhc3SeqeSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqeYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqeZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqeSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
