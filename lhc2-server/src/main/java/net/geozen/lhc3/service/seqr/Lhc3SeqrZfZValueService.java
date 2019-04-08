package net.geozen.lhc3.service.seqr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqr.Lhc3SeqrYz;
import net.geozen.lhc3.domain.seqr.Lhc3SeqrZf;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrYzRepository;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrZfRepository;
import net.geozen.lhc3.nums.SeqrNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqrZfZValueService extends BaseZfZValueCalService<Lhc3SeqrYz, Lhc3SeqrZf> {
	@Autowired
	private Lhc3SeqrYzRepository yzRepository;

	@Autowired
	private Lhc3SeqrZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqrZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqrYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqrNums.LISTS.get(pos);
	}

}
