package net.geozen.lhc3.service.seqe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
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
	protected BaseRepository<Lhc3SeqeYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqeZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqeSw> getSwRepository() {
		return swRepository;
	}
}
