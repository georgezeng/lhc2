package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seql.Lhc3SeqlSw;
import net.geozen.lhc3.domain.seql.Lhc3SeqlYz;
import net.geozen.lhc3.domain.seql.Lhc3SeqlZf;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlSwRepository;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlYzRepository;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seql")
public class Lhc3SeqlController {

	@Autowired
	private Lhc3SeqlYzRepository yzRepository;

	@Autowired
	private Lhc3SeqlZfRepository zfRepository;

	@Autowired
	private Lhc3SeqlSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqlYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqlZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqlSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
