package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.bs.Bssw;
import net.geozen.lhc2.domain.bs.Bsyz;
import net.geozen.lhc2.domain.bs.Bszf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.bs.BsswRepository;
import net.geozen.lhc2.jpa.bs.BsyzRepository;
import net.geozen.lhc2.jpa.bs.BszfRepository;

@RestController
@RequestMapping(value = "/bs")
public class BsController {

	@Autowired
	private BsyzRepository yzRepository;

	@Autowired
	private BszfRepository zfRepository;

	@Autowired
	private BsswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Bsyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Bszf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Bssw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
