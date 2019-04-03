package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqb.Lhc3SeqbSw;
import net.geozen.lhc3.domain.seqb.Lhc3SeqbYz;
import net.geozen.lhc3.domain.seqb.Lhc3SeqbZf;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbSwRepository;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbYzRepository;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbZfRepository;
import net.geozen.lhc3.nums.SeqbNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqbService extends Lhc3BaseService<Lhc3SeqbYz, Lhc3SeqbZf, Lhc3SeqbSw> {
	@Autowired
	private Lhc3SeqbYzRepository yzRepository;
	@Autowired
	private Lhc3SeqbZfRepository zfRepository;
	@Autowired
	private Lhc3SeqbSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqbNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqbYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqbZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqbSw> getSwRepository() {
		return swRepository;
	}
}
