package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.slq.a.Slqasw;
import net.geozen.lhc2.domain.slq.a.Slqayz;
import net.geozen.lhc2.domain.slq.a.Slqazf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.slq.a.SlqaswRepository;
import net.geozen.lhc2.jpa.slq.a.SlqayzRepository;
import net.geozen.lhc2.jpa.slq.a.SlqazfRepository;

@RestController
@RequestMapping(value = "/slqa")
public class SlqaController {

	@Autowired
	private SlqayzRepository yzRepository;

	@Autowired
	private SlqazfRepository zfRepository;

	@Autowired
	private SlqaswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Slqayz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Slqazf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Slqasw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
