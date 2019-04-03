package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdSw;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdYz;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdZf;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdSwRepository;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdYzRepository;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqd")
public class Lhc3SeqdController {

	@Autowired
	private Lhc3SeqdYzRepository yzRepository;

	@Autowired
	private Lhc3SeqdZfRepository zfRepository;

	@Autowired
	private Lhc3SeqdSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqdYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqdZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqdSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
