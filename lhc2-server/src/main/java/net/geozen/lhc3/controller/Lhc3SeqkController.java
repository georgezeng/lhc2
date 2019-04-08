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
import net.geozen.lhc3.domain.seqk.Lhc3SeqkSw;
import net.geozen.lhc3.domain.seqk.Lhc3SeqkYz;
import net.geozen.lhc3.domain.seqk.Lhc3SeqkZf;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkSwRepository;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkYzRepository;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqk")
public class Lhc3SeqkController extends Lhc3BaseController<Lhc3SeqkYz, Lhc3SeqkZf, Lhc3SeqkSw> {

	@Autowired
	private Lhc3SeqkYzRepository yzRepository;

	@Autowired
	private Lhc3SeqkZfRepository zfRepository;

	@Autowired
	private Lhc3SeqkSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqkYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqkZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqkSw> getSwRepository() {
		return swRepository;
	}

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqkYz>> yzList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.yzList(queryInfo);
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqkZf>> zfList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.zfList(queryInfo);
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqkSw>> swList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.swList(queryInfo);
	}

}
