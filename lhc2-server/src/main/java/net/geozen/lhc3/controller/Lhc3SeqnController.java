package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnSw;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnYz;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnZf;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnSwRepository;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnYzRepository;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqn")
public class Lhc3SeqnController {

	@Autowired
	private Lhc3SeqnYzRepository yzRepository;

	@Autowired
	private Lhc3SeqnZfRepository zfRepository;

	@Autowired
	private Lhc3SeqnSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqnYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqnZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqnSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
