package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqj.Lhc3SeqjSw;
import net.geozen.lhc3.domain.seqj.Lhc3SeqjYz;
import net.geozen.lhc3.domain.seqj.Lhc3SeqjZf;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjSwRepository;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjYzRepository;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqj")
public class Lhc3SeqjController {

	@Autowired
	private Lhc3SeqjYzRepository yzRepository;

	@Autowired
	private Lhc3SeqjZfRepository zfRepository;

	@Autowired
	private Lhc3SeqjSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqjYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqjZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqjSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
