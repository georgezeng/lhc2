package net.geozen.lhc3.service.seqf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfYz;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfZf;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfYzRepository;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfZfRepository;
import net.geozen.lhc3.nums.SeqfNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqfZfZValueService extends BaseZfZValueCalService<Lhc3SeqfYz, Lhc3SeqfZf> {
	@Autowired
	private Lhc3SeqfYzRepository yzRepository;

	@Autowired
	private Lhc3SeqfZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqfZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqfYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqfNums.LISTS.get(pos);
	}

}
