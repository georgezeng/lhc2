package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmSw;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmYz;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmZf;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmSwRepository;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmYzRepository;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmZfRepository;
import net.geozen.lhc3.nums.SeqmNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqmService extends Lhc3BaseService<Lhc3SeqmYz, Lhc3SeqmZf, Lhc3SeqmSw> {
	@Autowired
	private Lhc3SeqmYzRepository yzRepository;
	@Autowired
	private Lhc3SeqmZfRepository zfRepository;
	@Autowired
	private Lhc3SeqmSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqmNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqmYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqmZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqmSw> getSwRepository() {
		return swRepository;
	}
}
