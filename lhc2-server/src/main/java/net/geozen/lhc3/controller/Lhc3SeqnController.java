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
import net.geozen.lhc3.domain.seqn.Lhc3SeqnSw;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnYz;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnZf;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnSwRepository;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnYzRepository;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqn")
public class Lhc3SeqnController extends Lhc3BaseController<Lhc3SeqnYz, Lhc3SeqnZf, Lhc3SeqnSw> {

	@Autowired
	private Lhc3SeqnYzRepository yzRepository;

	@Autowired
	private Lhc3SeqnZfRepository zfRepository;

	@Autowired
	private Lhc3SeqnSwRepository swRepository;

	@Override
	protected BaseYzRepository<Lhc3SeqnYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqnZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqnSw> getSwRepository() {
		return swRepository;
	}

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqnYz>> yzList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.yzList(queryInfo);
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqnZf>> zfList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.zfList(queryInfo);
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqnSw>> swList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.swList(queryInfo);
	}

}
