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
import net.geozen.lhc3.domain.seqd.Lhc3SeqdSw;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdYz;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdZf;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdSwRepository;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdYzRepository;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqd")
public class Lhc3SeqdController extends Lhc3BaseController<Lhc3SeqdYz, Lhc3SeqdZf, Lhc3SeqdSw> {

	@Autowired
	private Lhc3SeqdYzRepository yzRepository;

	@Autowired
	private Lhc3SeqdZfRepository zfRepository;

	@Autowired
	private Lhc3SeqdSwRepository swRepository;

	@Override
	protected BaseYzRepository<Lhc3SeqdYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqdZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqdSw> getSwRepository() {
		return swRepository;
	}

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqdYz>> yzList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.yzList(queryInfo);
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqdZf>> zfList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.zfList(queryInfo);
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqdSw>> swList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.swList(queryInfo);
	}

}
