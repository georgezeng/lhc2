package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqSw;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqYz;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqZf;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqSwRepository;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqYzRepository;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqq")
public class Lhc3SeqqController {

	@Autowired
	private Lhc3SeqqYzRepository yzRepository;

	@Autowired
	private Lhc3SeqqZfRepository zfRepository;

	@Autowired
	private Lhc3SeqqSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqqYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqqZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqqSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
