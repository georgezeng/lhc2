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
import net.geozen.lhc3.domain.seqa.Lhc3SeqaSw;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaYz;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaZf;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaSwRepository;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaYzRepository;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqa")
public class Lhc3SeqaController extends Lhc3BaseController<Lhc3SeqaYz, Lhc3SeqaZf, Lhc3SeqaSw> {

	@Autowired
	private Lhc3SeqaYzRepository yzRepository;

	@Autowired
	private Lhc3SeqaZfRepository zfRepository;

	@Autowired
	private Lhc3SeqaSwRepository swRepository;

	@Override
	protected BaseYzRepository<Lhc3SeqaYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqaZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqaSw> getSwRepository() {
		return swRepository;
	}

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqaYz>> yzList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.yzList(queryInfo);
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqaZf>> zfList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.zfList(queryInfo);
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqaSw>> swList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.swList(queryInfo);
	}

}
