package net.geozen.lhc3.service.seqh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhYz;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhZf;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhYzRepository;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhZfRepository;
import net.geozen.lhc3.nums.SeqhNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqhZfZValueService extends BaseZfZValueCalService<Lhc3SeqhYz, Lhc3SeqhZf> {
	@Autowired
	private Lhc3SeqhYzRepository yzRepository;

	@Autowired
	private Lhc3SeqhZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqhZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqhYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqhNums.LISTS.get(pos);
	}

}
