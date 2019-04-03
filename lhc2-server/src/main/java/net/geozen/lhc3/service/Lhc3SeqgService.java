package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgSw;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgYz;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgZf;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgSwRepository;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgYzRepository;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgZfRepository;
import net.geozen.lhc3.nums.SeqgNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqgService extends Lhc3BaseService<Lhc3SeqgYz, Lhc3SeqgZf, Lhc3SeqgSw> {
	@Autowired
	private Lhc3SeqgYzRepository yzRepository;
	@Autowired
	private Lhc3SeqgZfRepository zfRepository;
	@Autowired
	private Lhc3SeqgSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqgNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqgYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqgZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqgSw> getSwRepository() {
		return swRepository;
	}
}
