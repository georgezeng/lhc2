package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqk.Lhc3SeqkSw;
import net.geozen.lhc3.domain.seqk.Lhc3SeqkYz;
import net.geozen.lhc3.domain.seqk.Lhc3SeqkZf;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkSwRepository;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkYzRepository;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkZfRepository;
import net.geozen.lhc3.nums.SeqkNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqkService extends Lhc3BaseService<Lhc3SeqkYz, Lhc3SeqkZf, Lhc3SeqkSw> {
	@Autowired
	private Lhc3SeqkYzRepository yzRepository;
	@Autowired
	private Lhc3SeqkZfRepository zfRepository;
	@Autowired
	private Lhc3SeqkSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqkNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqkYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqkZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqkSw> getSwRepository() {
		return swRepository;
	}
}
