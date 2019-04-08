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
import net.geozen.lhc3.domain.seql.Lhc3SeqlSw;
import net.geozen.lhc3.domain.seql.Lhc3SeqlYz;
import net.geozen.lhc3.domain.seql.Lhc3SeqlZf;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlSwRepository;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlYzRepository;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlZfRepository;

@RestController
@RequestMapping(value = "/lhc3/seql")
public class Lhc3SeqlController extends Lhc3BaseController<Lhc3SeqlYz, Lhc3SeqlZf, Lhc3SeqlSw> {

	@Autowired
	private Lhc3SeqlYzRepository yzRepository;

	@Autowired
	private Lhc3SeqlZfRepository zfRepository;

	@Autowired
	private Lhc3SeqlSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqlYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqlZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqlSw> getSwRepository() {
		return swRepository;
	}

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqlYz>> yzList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.yzList(queryInfo);
	}

	@RequestMapping(value = "/zf/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqlZf>> zfList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.zfList(queryInfo);
	}

	@RequestMapping(value = "/sw/list", method = RequestMethod.POST)
	@Override
	public Result<PageResult<Lhc3SeqlSw>> swList(@RequestBody QueryInfo<String> queryInfo) throws Exception {
		return super.swList(queryInfo);
	}

}
