package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.slq.zs.Slqzssw;
import net.geozen.lhc2.domain.slq.zs.Slqzsyz;
import net.geozen.lhc2.domain.slq.zs.Slqzszf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.slq.zs.SlqzsswRepository;
import net.geozen.lhc2.jpa.slq.zs.SlqzsyzRepository;
import net.geozen.lhc2.jpa.slq.zs.SlqzszfRepository;

@RestController
@RequestMapping(value = "/slqzs")
public class SlqzsController {

	@Autowired
	private SlqzsyzRepository yzRepository;

	@Autowired
	private SlqzszfRepository zfRepository;

	@Autowired
	private SlqzsswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Slqzsyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Slqzszf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Slqzssw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
