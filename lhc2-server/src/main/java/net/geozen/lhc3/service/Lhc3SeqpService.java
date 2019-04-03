package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqp.Lhc3SeqpSw;
import net.geozen.lhc3.domain.seqp.Lhc3SeqpYz;
import net.geozen.lhc3.domain.seqp.Lhc3SeqpZf;
import net.geozen.lhc3.jpa.seqp.Lhc3SeqpSwRepository;
import net.geozen.lhc3.jpa.seqp.Lhc3SeqpYzRepository;
import net.geozen.lhc3.jpa.seqp.Lhc3SeqpZfRepository;
import net.geozen.lhc3.nums.SeqpNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqpService extends Lhc3BaseService<Lhc3SeqpYz, Lhc3SeqpZf, Lhc3SeqpSw> {
	@Autowired
	private Lhc3SeqpYzRepository yzRepository;
	@Autowired
	private Lhc3SeqpZfRepository zfRepository;
	@Autowired
	private Lhc3SeqpSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqpNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqpYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqpZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqpSw> getSwRepository() {
		return swRepository;
	}
}
