package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.pd.Pdsw;
import net.geozen.lhc2.domain.pd.Pdyz;
import net.geozen.lhc2.domain.pd.Pdzf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.pd.PdswRepository;
import net.geozen.lhc2.jpa.pd.PdyzRepository;
import net.geozen.lhc2.jpa.pd.PdzfRepository;

@RestController
@RequestMapping(value = "/pd")
public class PdController {

	@Autowired
	private PdyzRepository yzRepository;

	@Autowired
	private PdzfRepository zfRepository;

	@Autowired
	private PdswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Pdyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Pdzf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Pdsw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
