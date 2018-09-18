package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.z13.Z13sw;
import net.geozen.lhc2.domain.z13.Z13yz;
import net.geozen.lhc2.domain.z13.Z13zf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.z13.Z13swRepository;
import net.geozen.lhc2.jpa.z13.Z13yzRepository;
import net.geozen.lhc2.jpa.z13.Z13zfRepository;

@RestController
@RequestMapping(value = "/z13")
public class Z13Controller {

	@Autowired
	private Z13yzRepository yzRepository;

	@Autowired
	private Z13zfRepository zfRepository;

	@Autowired
	private Z13swRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Z13yz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Z13zf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Z13sw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
