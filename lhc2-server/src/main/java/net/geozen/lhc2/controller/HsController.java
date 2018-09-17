package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.hs.Hssw;
import net.geozen.lhc2.domain.hs.Hsyz;
import net.geozen.lhc2.domain.hs.Hszf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.hs.HsswRepository;
import net.geozen.lhc2.jpa.hs.HsyzRepository;
import net.geozen.lhc2.jpa.hs.HszfRepository;

@RestController
@RequestMapping(value = "/hs")
public class HsController {

	@Autowired
	private HsyzRepository yzRepository;

	@Autowired
	private HszfRepository zfRepository;

	@Autowired
	private HsswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Hsyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Hszf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Hssw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
