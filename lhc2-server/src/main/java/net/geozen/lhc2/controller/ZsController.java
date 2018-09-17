package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.zs.Zssw;
import net.geozen.lhc2.domain.zs.Zsyz;
import net.geozen.lhc2.domain.zs.Zszf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.zs.ZsswRepository;
import net.geozen.lhc2.jpa.zs.ZsyzRepository;
import net.geozen.lhc2.jpa.zs.ZszfRepository;

@RestController
@RequestMapping(value = "/zs")
public class ZsController {

	@Autowired
	private ZsyzRepository yzRepository;

	@Autowired
	private ZszfRepository zfRepository;

	@Autowired
	private ZsswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Zsyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Zszf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Zssw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
