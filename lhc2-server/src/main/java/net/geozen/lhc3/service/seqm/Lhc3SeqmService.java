package net.geozen.lhc3.service.seqm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmSw;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmYz;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmZf;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmSwRepository;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmYzRepository;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmZfRepository;
import net.geozen.lhc3.nums.SeqmNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqmService extends Lhc3BaseService<Lhc3SeqmYz, Lhc3SeqmZf, Lhc3SeqmSw> {
	@Autowired
	private Lhc3SeqmYzRepository yzRepository;
	@Autowired
	private Lhc3SeqmZfRepository zfRepository;
	@Autowired
	private Lhc3SeqmSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqmNums.LISTS;
	}

	@Override
	protected BaseRepository<Lhc3SeqmYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqmZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqmSw> getSwRepository() {
		return swRepository;
	}
}
