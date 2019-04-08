package net.geozen.lhc3.service.seqn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnYz;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnZf;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnYzRepository;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnZfRepository;
import net.geozen.lhc3.nums.SeqnNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqnZfZValueService extends BaseZfZValueCalService<Lhc3SeqnYz, Lhc3SeqnZf> {
	@Autowired
	private Lhc3SeqnYzRepository yzRepository;

	@Autowired
	private Lhc3SeqnZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqnZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqnYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqnNums.LISTS.get(pos);
	}

}
