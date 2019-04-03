package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqSw;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqYz;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqZf;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqSwRepository;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqYzRepository;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqZfRepository;
import net.geozen.lhc3.nums.SeqqNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqqService extends Lhc3BaseService<Lhc3SeqqYz, Lhc3SeqqZf, Lhc3SeqqSw> {
	@Autowired
	private Lhc3SeqqYzRepository yzRepository;
	@Autowired
	private Lhc3SeqqZfRepository zfRepository;
	@Autowired
	private Lhc3SeqqSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqqNums.LISTS;
	}

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
}
