package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seql.Lhc3SeqlSw;
import net.geozen.lhc3.domain.seql.Lhc3SeqlYz;
import net.geozen.lhc3.domain.seql.Lhc3SeqlZf;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlSwRepository;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlYzRepository;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlZfRepository;
import net.geozen.lhc3.nums.SeqlNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqlService extends Lhc3BaseService<Lhc3SeqlYz, Lhc3SeqlZf, Lhc3SeqlSw> {
	@Autowired
	private Lhc3SeqlYzRepository yzRepository;
	@Autowired
	private Lhc3SeqlZfRepository zfRepository;
	@Autowired
	private Lhc3SeqlSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqlNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqlYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqlZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqlSw> getSwRepository() {
		return swRepository;
	}
}
