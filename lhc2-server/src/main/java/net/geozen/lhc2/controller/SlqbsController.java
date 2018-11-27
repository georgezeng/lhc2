package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.slq.bs.Slqbssw;
import net.geozen.lhc2.domain.slq.bs.Slqbsyz;
import net.geozen.lhc2.domain.slq.bs.Slqbszf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.slq.bs.SlqbsswRepository;
import net.geozen.lhc2.jpa.slq.bs.SlqbsyzRepository;
import net.geozen.lhc2.jpa.slq.bs.SlqbszfRepository;

@RestController
@RequestMapping(value = "/slqbs")
public class SlqbsController {

	@Autowired
	private SlqbsyzRepository yzRepository;

	@Autowired
	private SlqbszfRepository zfRepository;

	@Autowired
	private SlqbsswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Slqbsyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Slqbszf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Slqbssw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
