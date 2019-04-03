package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqr.Lhc3SeqrSw;
import net.geozen.lhc3.domain.seqr.Lhc3SeqrYz;
import net.geozen.lhc3.domain.seqr.Lhc3SeqrZf;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrSwRepository;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrYzRepository;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrZfRepository;
import net.geozen.lhc3.nums.SeqrNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqrService extends Lhc3BaseService<Lhc3SeqrYz, Lhc3SeqrZf, Lhc3SeqrSw> {
	@Autowired
	private Lhc3SeqrYzRepository yzRepository;
	@Autowired
	private Lhc3SeqrZfRepository zfRepository;
	@Autowired
	private Lhc3SeqrSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqrNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqrYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqrZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqrSw> getSwRepository() {
		return swRepository;
	}
}
