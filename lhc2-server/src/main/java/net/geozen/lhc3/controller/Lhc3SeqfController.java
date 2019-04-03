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
import net.geozen.lhc3.domain.seqf.Lhc3SeqfSw;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfYz;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfZf;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfSwRepository;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfYzRepository;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqf")
public class Lhc3SeqfController extends Lhc3BaseController<Lhc3SeqfYz, Lhc3SeqfZf, Lhc3SeqfSw> {

	@Autowired
	private Lhc3SeqfYzRepository yzRepository;

	@Autowired
	private Lhc3SeqfZfRepository zfRepository;

	@Autowired
	private Lhc3SeqfSwRepository swRepository;

	@Override
	protected BaseYzRepository<Lhc3SeqfYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqfZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqfSw> getSwRepository() {
		return swRepository;
	}

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqfYz>> yzList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.yzList(queryInfo);
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqfZf>> zfList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.zfList(queryInfo);
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqfSw>> swList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.swList(queryInfo);
	}

}
