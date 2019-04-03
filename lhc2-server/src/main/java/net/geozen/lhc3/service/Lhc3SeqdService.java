package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdSw;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdYz;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdZf;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdSwRepository;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdYzRepository;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdZfRepository;
import net.geozen.lhc3.nums.SeqdNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqdService extends Lhc3BaseService<Lhc3SeqdYz, Lhc3SeqdZf, Lhc3SeqdSw> {
	@Autowired
	private Lhc3SeqdYzRepository yzRepository;
	@Autowired
	private Lhc3SeqdZfRepository zfRepository;
	@Autowired
	private Lhc3SeqdSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqdNums.LISTS;
	}

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
}
