package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.slq.wx.Slqwxsw;
import net.geozen.lhc2.domain.slq.wx.Slqwxyz;
import net.geozen.lhc2.domain.slq.wx.Slqwxzf;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.slq.wx.SlqwxswRepository;
import net.geozen.lhc2.jpa.slq.wx.SlqwxyzRepository;
import net.geozen.lhc2.jpa.slq.wx.SlqwxzfRepository;

@RestController
@RequestMapping(value = "/slqwx")
public class SlqwxController {

	@Autowired
	private SlqwxyzRepository yzRepository;

	@Autowired
	private SlqwxzfRepository zfRepository;

	@Autowired
	private SlqwxswRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Slqwxyz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Slqwxzf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Slqwxsw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
