package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfSw;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfYz;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfZf;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfSwRepository;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfYzRepository;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfZfRepository;
import net.geozen.lhc3.nums.SeqfNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqfService extends Lhc3BaseService<Lhc3SeqfYz, Lhc3SeqfZf, Lhc3SeqfSw> {
	@Autowired
	private Lhc3SeqfYzRepository yzRepository;
	@Autowired
	private Lhc3SeqfZfRepository zfRepository;
	@Autowired
	private Lhc3SeqfSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqfNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqfYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqfZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqfSw> getSwRepository() {
		return swRepository;
	}
}
