package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqo.Lhc3SeqoSw;
import net.geozen.lhc3.domain.seqo.Lhc3SeqoYz;
import net.geozen.lhc3.domain.seqo.Lhc3SeqoZf;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoSwRepository;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoYzRepository;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqo")
public class Lhc3SeqoController {

	@Autowired
	private Lhc3SeqoYzRepository yzRepository;

	@Autowired
	private Lhc3SeqoZfRepository zfRepository;

	@Autowired
	private Lhc3SeqoSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqoYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqoZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqoSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
