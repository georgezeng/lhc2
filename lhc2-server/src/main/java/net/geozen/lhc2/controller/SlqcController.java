package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.slq.c.Slqcsw;
import net.geozen.lhc2.domain.slq.c.Slqcyz;
import net.geozen.lhc2.domain.slq.c.Slqczf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.slq.c.SlqcswRepository;
import net.geozen.lhc2.jpa.slq.c.SlqcyzRepository;
import net.geozen.lhc2.jpa.slq.c.SlqczfRepository;

@RestController
@RequestMapping(value = "/slqc")
public class SlqcController {

	@Autowired
	private SlqcyzRepository yzRepository;

	@Autowired
	private SlqczfRepository zfRepository;

	@Autowired
	private SlqcswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Slqcyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Slqczf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Slqcsw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
