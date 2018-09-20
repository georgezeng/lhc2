package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.fd.Fdsw;
import net.geozen.lhc2.domain.fd.Fdyz;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.fd.FdswRepository;
import net.geozen.lhc2.jpa.fd.FdyzRepository;

@RestController
@RequestMapping(value = "/fd")
public class FdController {

	@Autowired
	private FdyzRepository yzRepository;

	@Autowired
	private FdswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Fdyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Fdsw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
