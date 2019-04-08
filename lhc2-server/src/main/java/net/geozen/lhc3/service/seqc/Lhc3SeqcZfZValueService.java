package net.geozen.lhc3.service.seqc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcYz;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcZf;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcYzRepository;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcZfRepository;
import net.geozen.lhc3.nums.SeqcNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqcZfZValueService extends BaseZfZValueCalService<Lhc3SeqcYz, Lhc3SeqcZf> {
	@Autowired
	private Lhc3SeqcYzRepository yzRepository;

	@Autowired
	private Lhc3SeqcZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqcZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqcYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqcNums.LISTS.get(pos);
	}

}
