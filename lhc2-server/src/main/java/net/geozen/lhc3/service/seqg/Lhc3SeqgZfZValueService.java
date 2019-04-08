package net.geozen.lhc3.service.seqg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgYz;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgZf;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgYzRepository;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgZfRepository;
import net.geozen.lhc3.nums.SeqgNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqgZfZValueService extends BaseZfZValueCalService<Lhc3SeqgYz, Lhc3SeqgZf> {
	@Autowired
	private Lhc3SeqgYzRepository yzRepository;

	@Autowired
	private Lhc3SeqgZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqgZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqgYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqgNums.LISTS.get(pos);
	}

}
