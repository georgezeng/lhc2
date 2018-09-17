package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.mw.Mwsw;
import net.geozen.lhc2.domain.mw.Mwyz;
import net.geozen.lhc2.domain.mw.Mwzf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.mw.MwswRepository;
import net.geozen.lhc2.jpa.mw.MwyzRepository;
import net.geozen.lhc2.jpa.mw.MwzfRepository;

@RestController
@RequestMapping(value = "/mw")
public class MwController {

	@Autowired
	private MwyzRepository yzRepository;

	@Autowired
	private MwzfRepository zfRepository;

	@Autowired
	private MwswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Mwyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Mwzf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Mwsw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
