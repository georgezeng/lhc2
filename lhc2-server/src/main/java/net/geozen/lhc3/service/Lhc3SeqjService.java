package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqj.Lhc3SeqjSw;
import net.geozen.lhc3.domain.seqj.Lhc3SeqjYz;
import net.geozen.lhc3.domain.seqj.Lhc3SeqjZf;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjSwRepository;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjYzRepository;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjZfRepository;
import net.geozen.lhc3.nums.SeqjNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqjService extends Lhc3BaseService<Lhc3SeqjYz, Lhc3SeqjZf, Lhc3SeqjSw> {
	@Autowired
	private Lhc3SeqjYzRepository yzRepository;
	@Autowired
	private Lhc3SeqjZfRepository zfRepository;
	@Autowired
	private Lhc3SeqjSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqjNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqjYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqjZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqjSw> getSwRepository() {
		return swRepository;
	}
}
