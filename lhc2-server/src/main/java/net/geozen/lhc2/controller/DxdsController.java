package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.dxds.Dxds1yz;
import net.geozen.lhc2.domain.dxds.Dxds2yz;
import net.geozen.lhc2.domain.dxds.Dxds2zf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.dxds.Dxds1yzRepository;
import net.geozen.lhc2.jpa.dxds.Dxds2yzRepository;
import net.geozen.lhc2.jpa.dxds.Dxds2zfRepository;

@RestController
@RequestMapping(value = "/dxds")
public class DxdsController {

	@Autowired
	private Dxds1yzRepository yz1Repository;

	@Autowired
	private Dxds2yzRepository yz2Repository;

	@Autowired
	private Dxds2zfRepository zf2Repository;

	@RequestMapping(value = "/yz1/list", method = RequestMethod.GET)
	public Result<Iterable<Dxds1yz>> yz1List() {
		return Result.genSuccessResult(yz1Repository.findAll());
	}

	@RequestMapping(value = "/yz2/list", method = RequestMethod.GET)
	public Result<Iterable<Dxds2yz>> yz2List() {
		return Result.genSuccessResult(yz2Repository.findAll());
	}

	@RequestMapping(value = "/zf2/list", method = RequestMethod.GET)
	public Result<Iterable<Dxds2zf>> zfList() {
		return Result.genSuccessResult(zf2Repository.findAll());
	}

}
