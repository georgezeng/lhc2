package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.PageResult;
import net.geozen.lhc2.dto.QueryInfo;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcSw;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcYz;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcZf;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcSwRepository;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcYzRepository;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqc")
public class Lhc3SeqcController extends Lhc3BaseController<Lhc3SeqcYz, Lhc3SeqcZf, Lhc3SeqcSw> {

	@Autowired
	private Lhc3SeqcYzRepository yzRepository;

	@Autowired
	private Lhc3SeqcZfRepository zfRepository;

	@Autowired
	private Lhc3SeqcSwRepository swRepository;

	@Override
	protected BaseYzRepository<Lhc3SeqcYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqcZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqcSw> getSwRepository() {
		return swRepository;
	}

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqcYz>> yzList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.yzList(queryInfo);
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqcZf>> zfList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.zfList(queryInfo);
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqcSw>> swList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.swList(queryInfo);
	}

}
