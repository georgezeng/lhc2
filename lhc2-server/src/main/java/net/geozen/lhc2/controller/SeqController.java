package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.seq.Seqsw;
import net.geozen.lhc2.domain.seq.Seqyz;
import net.geozen.lhc2.domain.seq.Seqzf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.seq.SeqswRepository;
import net.geozen.lhc2.jpa.seq.SeqyzRepository;
import net.geozen.lhc2.jpa.seq.SeqzfRepository;

@RestController
@RequestMapping(value = "/seq")
public class SeqController {

	@Autowired
	private SeqyzRepository yzRepository;

	@Autowired
	private SeqzfRepository zfRepository;

	@Autowired
	private SeqswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Seqyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Seqzf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Seqsw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
