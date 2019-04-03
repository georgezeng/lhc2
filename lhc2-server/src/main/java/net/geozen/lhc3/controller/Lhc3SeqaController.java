package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaSw;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaYz;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaZf;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaSwRepository;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaYzRepository;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqa")
public class Lhc3SeqaController {

	@Autowired
	private Lhc3SeqaYzRepository yzRepository;

	@Autowired
	private Lhc3SeqaZfRepository zfRepository;

	@Autowired
	private Lhc3SeqaSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqaYz>> yzList() {
		return Result.genSuccessResult(yzRepository.findAll());
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqaZf>> zfList() {
		return Result.genSuccessResult(zfRepository.findAll());
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Lhc3SeqaSw>> swList() {
		return Result.genSuccessResult(swRepository.findAll());
	}
}
