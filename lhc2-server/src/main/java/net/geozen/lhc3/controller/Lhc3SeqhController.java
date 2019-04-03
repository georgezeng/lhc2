package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhSw;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhYz;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhZf;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhSwRepository;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhYzRepository;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqh")
public class Lhc3SeqhController {

	@Autowired
	private Lhc3SeqhYzRepository yzRepository;

	@Autowired
	private Lhc3SeqhZfRepository zfRepository;

	@Autowired
	private Lhc3SeqhSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqhYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqhZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqhSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
