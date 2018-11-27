package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.slq.b.Slqbsw;
import net.geozen.lhc2.domain.slq.b.Slqbyz;
import net.geozen.lhc2.domain.slq.b.Slqbzf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.slq.b.SlqbswRepository;
import net.geozen.lhc2.jpa.slq.b.SlqbyzRepository;
import net.geozen.lhc2.jpa.slq.b.SlqbzfRepository;

@RestController
@RequestMapping(value = "/slqb")
public class SlqbController {

	@Autowired
	private SlqbyzRepository yzRepository;

	@Autowired
	private SlqbzfRepository zfRepository;

	@Autowired
	private SlqbswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Slqbyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Slqbzf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Slqbsw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
