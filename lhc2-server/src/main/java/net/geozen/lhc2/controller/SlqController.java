package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.slq.Slqsw;
import net.geozen.lhc2.domain.slq.Slqyz;
import net.geozen.lhc2.domain.slq.Slqzf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.slq.SlqswRepository;
import net.geozen.lhc2.jpa.slq.SlqyzRepository;
import net.geozen.lhc2.jpa.slq.SlqzfRepository;

@RestController
@RequestMapping(value = "/slq")
public class SlqController {

	@Autowired
	private SlqyzRepository yzRepository;

	@Autowired
	private SlqzfRepository zfRepository;

	@Autowired
	private SlqswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Slqyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Slqzf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Slqsw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
