package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqp.Lhc3SeqpSw;
import net.geozen.lhc3.domain.seqp.Lhc3SeqpYz;
import net.geozen.lhc3.domain.seqp.Lhc3SeqpZf;
import net.geozen.lhc3.jpa.seqp.Lhc3SeqpSwRepository;
import net.geozen.lhc3.jpa.seqp.Lhc3SeqpYzRepository;
import net.geozen.lhc3.jpa.seqp.Lhc3SeqpZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqp")
public class Lhc3SeqpController {

	@Autowired
	private Lhc3SeqpYzRepository yzRepository;

	@Autowired
	private Lhc3SeqpZfRepository zfRepository;

	@Autowired
	private Lhc3SeqpSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqpYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqpZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqpSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
