package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqe.Lhc3SeqeSw;
import net.geozen.lhc3.domain.seqe.Lhc3SeqeYz;
import net.geozen.lhc3.domain.seqe.Lhc3SeqeZf;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeSwRepository;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeYzRepository;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeZfRepository;
import net.geozen.lhc3.nums.SeqeNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqeService extends Lhc3BaseService<Lhc3SeqeYz, Lhc3SeqeZf, Lhc3SeqeSw> {
	@Autowired
	private Lhc3SeqeYzRepository yzRepository;
	@Autowired
	private Lhc3SeqeZfRepository zfRepository;
	@Autowired
	private Lhc3SeqeSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqeNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqeYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqeZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqeSw> getSwRepository() {
		return swRepository;
	}
}
