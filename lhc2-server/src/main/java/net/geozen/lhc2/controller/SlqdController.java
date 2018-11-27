package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.slq.d.Slqdsw;
import net.geozen.lhc2.domain.slq.d.Slqdyz;
import net.geozen.lhc2.domain.slq.d.Slqdzf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.slq.d.SlqdswRepository;
import net.geozen.lhc2.jpa.slq.d.SlqdyzRepository;
import net.geozen.lhc2.jpa.slq.d.SlqdzfRepository;

@RestController
@RequestMapping(value = "/slqd")
public class SlqdController {

	@Autowired
	private SlqdyzRepository yzRepository;

	@Autowired
	private SlqdzfRepository zfRepository;

	@Autowired
	private SlqdswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Slqdyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Slqdzf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Slqdsw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
