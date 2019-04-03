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
import net.geozen.lhc3.domain.seqq.Lhc3SeqqSw;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqYz;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqZf;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqSwRepository;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqYzRepository;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqq")
public class Lhc3SeqqController extends Lhc3BaseController<Lhc3SeqqYz, Lhc3SeqqZf, Lhc3SeqqSw> {

	@Autowired
	private Lhc3SeqqYzRepository yzRepository;

	@Autowired
	private Lhc3SeqqZfRepository zfRepository;

	@Autowired
	private Lhc3SeqqSwRepository swRepository;

	@Override
	protected BaseYzRepository<Lhc3SeqqYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqqZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqqSw> getSwRepository() {
		return swRepository;
	}

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqqYz>> yzList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.yzList(queryInfo);
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqqZf>> zfList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.zfList(queryInfo);
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqqSw>> swList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.swList(queryInfo);
	}

}
