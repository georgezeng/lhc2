package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.z7.Z7sw;
import net.geozen.lhc2.domain.z7.Z7yz;
import net.geozen.lhc2.domain.z7.Z7zf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.z7.Z7swRepository;
import net.geozen.lhc2.jpa.z7.Z7yzRepository;
import net.geozen.lhc2.jpa.z7.Z7zfRepository;

@RestController
@RequestMapping(value = "/z7")
public class Z7Controller {

	@Autowired
	private Z7yzRepository yzRepository;

	@Autowired
	private Z7zfRepository zfRepository;

	@Autowired
	private Z7swRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Z7yz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Z7zf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Z7sw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
