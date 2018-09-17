package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.sw.Swsw;
import net.geozen.lhc2.domain.sw.Swyz;
import net.geozen.lhc2.domain.sw.Swzf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.sw.SwswRepository;
import net.geozen.lhc2.jpa.sw.SwyzRepository;
import net.geozen.lhc2.jpa.sw.SwzfRepository;

@RestController
@RequestMapping(value = "/sw")
public class SwController {

	@Autowired
	private SwyzRepository yzRepository;

	@Autowired
	private SwzfRepository zfRepository;

	@Autowired
	private SwswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Swyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Swzf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Swsw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
