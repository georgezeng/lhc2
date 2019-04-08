package net.geozen.lhc3.service.seqg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgSw;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgYz;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgZf;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgSwRepository;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgYzRepository;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgZfRepository;
import net.geozen.lhc3.nums.SeqgNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqgService extends Lhc3BaseService<Lhc3SeqgYz, Lhc3SeqgZf, Lhc3SeqgSw> {
	@Autowired
	private Lhc3SeqgYzRepository yzRepository;
	@Autowired
	private Lhc3SeqgZfRepository zfRepository;
	@Autowired
	private Lhc3SeqgSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqgNums.LISTS;
	}

	@Override
	protected BaseRepository<Lhc3SeqgYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqgZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqgSw> getSwRepository() {
		return swRepository;
	}
}
