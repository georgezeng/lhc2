package net.geozen.lhc3.service.seqh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhSw;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhYz;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhZf;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhSwRepository;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhYzRepository;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhZfRepository;
import net.geozen.lhc3.nums.SeqhNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqhService extends Lhc3BaseService<Lhc3SeqhYz, Lhc3SeqhZf, Lhc3SeqhSw> {
	@Autowired
	private Lhc3SeqhYzRepository yzRepository;
	@Autowired
	private Lhc3SeqhZfRepository zfRepository;
	@Autowired
	private Lhc3SeqhSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqhNums.LISTS;
	}

	@Override
	protected BaseRepository<Lhc3SeqhYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqhZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqhSw> getSwRepository() {
		return swRepository;
	}
}
