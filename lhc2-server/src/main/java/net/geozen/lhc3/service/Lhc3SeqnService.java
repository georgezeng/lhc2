package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnSw;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnYz;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnZf;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnSwRepository;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnYzRepository;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnZfRepository;
import net.geozen.lhc3.nums.SeqnNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqnService extends Lhc3BaseService<Lhc3SeqnYz, Lhc3SeqnZf, Lhc3SeqnSw> {
	@Autowired
	private Lhc3SeqnYzRepository yzRepository;
	@Autowired
	private Lhc3SeqnZfRepository zfRepository;
	@Autowired
	private Lhc3SeqnSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqnNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqnYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqnZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqnSw> getSwRepository() {
		return swRepository;
	}
}
