package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.fd.Lhc3FdSw;
import net.geozen.lhc3.domain.fd.Lhc3FdYz;
import net.geozen.lhc3.jpa.fd.Lhc3FdSwRepository;
import net.geozen.lhc3.jpa.fd.Lhc3FdYzRepository;

@RestController
@RequestMapping(value = "/lhc3/fd")
public class Lhc3FdController {

	@Autowired
	private Lhc3FdYzRepository yzRepository;

	@Autowired
	private Lhc3FdSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3FdYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3FdSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
