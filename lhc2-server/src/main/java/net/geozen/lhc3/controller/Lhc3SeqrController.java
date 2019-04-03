package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqr.Lhc3SeqrSw;
import net.geozen.lhc3.domain.seqr.Lhc3SeqrYz;
import net.geozen.lhc3.domain.seqr.Lhc3SeqrZf;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrSwRepository;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrYzRepository;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqr")
public class Lhc3SeqrController {

	@Autowired
	private Lhc3SeqrYzRepository yzRepository;

	@Autowired
	private Lhc3SeqrZfRepository zfRepository;

	@Autowired
	private Lhc3SeqrSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqrYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqrZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqrSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
