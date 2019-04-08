package net.geozen.lhc3.service.seqo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqo.Lhc3SeqoSw;
import net.geozen.lhc3.domain.seqo.Lhc3SeqoYz;
import net.geozen.lhc3.domain.seqo.Lhc3SeqoZf;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoSwRepository;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoYzRepository;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoZfRepository;
import net.geozen.lhc3.nums.SeqoNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqoService extends Lhc3BaseService<Lhc3SeqoYz, Lhc3SeqoZf, Lhc3SeqoSw> {
	@Autowired
	private Lhc3SeqoYzRepository yzRepository;
	@Autowired
	private Lhc3SeqoZfRepository zfRepository;
	@Autowired
	private Lhc3SeqoSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqoNums.LISTS;
	}

	@Override
	protected BaseRepository<Lhc3SeqoYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqoZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqoSw> getSwRepository() {
		return swRepository;
	}
}
