package net.geozen.lhc2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.sx.Sxsw;
import net.geozen.lhc2.domain.sx.Sxyz;
import net.geozen.lhc2.domain.sx.Sxzf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.enums.SX;
import net.geozen.lhc2.jpa.sx.SxswRepository;
import net.geozen.lhc2.jpa.sx.SxyzRepository;
import net.geozen.lhc2.jpa.sx.SxzfRepository;

@RestController
@RequestMapping(value = "/sx")
public class SxController {

	@Autowired
	private SxyzRepository yzRepository;

	@Autowired
	private SxzfRepository zfRepository;

	@Autowired
	private SxswRepository swRepository;

	@RequestMapping(value = "/seq", method = RequestMethod.GET)
	public Result<List<SX>> seq() {
		return Result.genSuccessResult(Arrays.asList(SX.seq()));
	}

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Sxyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Sxzf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Sxsw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
