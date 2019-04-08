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
import net.geozen.lhc3.domain.seqi.Lhc3SeqiSw;
import net.geozen.lhc3.domain.seqi.Lhc3SeqiYz;
import net.geozen.lhc3.domain.seqi.Lhc3SeqiZf;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiSwRepository;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiYzRepository;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seqi")
public class Lhc3SeqiController extends Lhc3BaseController<Lhc3SeqiYz, Lhc3SeqiZf, Lhc3SeqiSw> {

	@Autowired
	private Lhc3SeqiYzRepository yzRepository;

	@Autowired
	private Lhc3SeqiZfRepository zfRepository;

	@Autowired
	private Lhc3SeqiSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqiYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqiZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqiSw> getSwRepository() {
		return swRepository;
	}

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqiYz>> yzList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.yzList(queryInfo);
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqiZf>> zfList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.zfList(queryInfo);
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqiSw>> swList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.swList(queryInfo);
	}

}
