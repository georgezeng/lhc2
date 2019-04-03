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
import net.geozen.lhc3.domain.seqh.Lhc3SeqhSw;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhYz;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhZf;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhSwRepository;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhYzRepository;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqh")
public class Lhc3SeqhController extends Lhc3BaseController<Lhc3SeqhYz, Lhc3SeqhZf, Lhc3SeqhSw> {

	@Autowired
	private Lhc3SeqhYzRepository yzRepository;

	@Autowired
	private Lhc3SeqhZfRepository zfRepository;

	@Autowired
	private Lhc3SeqhSwRepository swRepository;

	@Override
	protected BaseYzRepository<Lhc3SeqhYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqhZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqhSw> getSwRepository() {
		return swRepository;
	}

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqhYz>> yzList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.yzList(queryInfo);
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqhZf>> zfList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.zfList(queryInfo);
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqhSw>> swList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.swList(queryInfo);
	}

}
