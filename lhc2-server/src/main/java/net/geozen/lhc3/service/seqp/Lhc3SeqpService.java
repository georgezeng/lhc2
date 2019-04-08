package net.geozen.lhc3.service.seqp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
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
	protected BaseRepository<Lhc3SeqpYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqpZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqpSw> getSwRepository() {
		return swRepository;
	}
}
