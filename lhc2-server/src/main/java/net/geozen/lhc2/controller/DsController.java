package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.ds.Dssw;
import net.geozen.lhc2.domain.ds.Dsyz;
import net.geozen.lhc2.domain.ds.Dszf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.ds.DsswRepository;
import net.geozen.lhc2.jpa.ds.DsyzRepository;
import net.geozen.lhc2.jpa.ds.DszfRepository;

@RestController
@RequestMapping(value = "/ds")
public class DsController {

	@Autowired
	private DsyzRepository yzRepository;

	@Autowired
	private DszfRepository zfRepository;

	@Autowired
	private DsswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Dsyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Dszf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Dssw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
