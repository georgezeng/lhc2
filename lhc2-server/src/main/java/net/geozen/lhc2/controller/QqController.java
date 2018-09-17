package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.qq.Qqsw;
import net.geozen.lhc2.domain.qq.Qqyz;
import net.geozen.lhc2.domain.qq.Qqzf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.qq.QqswRepository;
import net.geozen.lhc2.jpa.qq.QqyzRepository;
import net.geozen.lhc2.jpa.qq.QqzfRepository;

@RestController
@RequestMapping(value = "/qq")
public class QqController {

	@Autowired
	private QqyzRepository yzRepository;

	@Autowired
	private QqzfRepository zfRepository;

	@Autowired
	private QqswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Qqyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Qqzf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Qqsw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
