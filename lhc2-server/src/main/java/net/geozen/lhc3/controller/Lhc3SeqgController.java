package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.PageResult;
import net.geozen.lhc2.dto.QueryInfo;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgSw;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgYz;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgZf;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgSwRepository;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgYzRepository;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqg")
public class Lhc3SeqgController extends Lhc3BaseController<Lhc3SeqgYz, Lhc3SeqgZf, Lhc3SeqgSw> {

	@Autowired
	private Lhc3SeqgYzRepository yzRepository;

	@Autowired
	private Lhc3SeqgZfRepository zfRepository;

	@Autowired
	private Lhc3SeqgSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqgYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqgZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqgSw> getSwRepository() {
		return swRepository;
	}

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqgYz>> yzList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.yzList(queryInfo);
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqgZf>> zfList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.zfList(queryInfo);
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqgSw>> swList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.swList(queryInfo);
	}

}
