package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.z2.Z2sw;
import net.geozen.lhc2.domain.z2.Z2yz;
import net.geozen.lhc2.domain.z2.Z2zf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.z2.Z2swRepository;
import net.geozen.lhc2.jpa.z2.Z2yzRepository;
import net.geozen.lhc2.jpa.z2.Z2zfRepository;

@RestController
@RequestMapping(value = "/z2")
public class Z2Controller {

	@Autowired
	private Z2yzRepository yzRepository;

	@Autowired
	private Z2zfRepository zfRepository;

	@Autowired
	private Z2swRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Z2yz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Z2zf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Z2sw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
