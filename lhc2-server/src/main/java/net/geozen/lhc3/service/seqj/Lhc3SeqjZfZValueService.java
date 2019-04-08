package net.geozen.lhc3.service.seqj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqj.Lhc3SeqjYz;
import net.geozen.lhc3.domain.seqj.Lhc3SeqjZf;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjYzRepository;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjZfRepository;
import net.geozen.lhc3.nums.SeqjNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqjZfZValueService extends BaseZfZValueCalService<Lhc3SeqjYz, Lhc3SeqjZf> {
	@Autowired
	private Lhc3SeqjYzRepository yzRepository;

	@Autowired
	private Lhc3SeqjZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqjZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqjYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqjNums.LISTS.get(pos);
	}

}
