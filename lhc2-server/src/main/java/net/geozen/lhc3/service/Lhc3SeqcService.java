package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcSw;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcYz;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcZf;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcSwRepository;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcYzRepository;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcZfRepository;
import net.geozen.lhc3.nums.SeqcNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqcService extends Lhc3BaseService<Lhc3SeqcYz, Lhc3SeqcZf, Lhc3SeqcSw> {
	@Autowired
	private Lhc3SeqcYzRepository yzRepository;
	@Autowired
	private Lhc3SeqcZfRepository zfRepository;
	@Autowired
	private Lhc3SeqcSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqcNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqcYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqcZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqcSw> getSwRepository() {
		return swRepository;
	}
}
