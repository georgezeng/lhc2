package net.geozen.lhc3.service.seqk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqk.Lhc3SeqkYz;
import net.geozen.lhc3.domain.seqk.Lhc3SeqkZf;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkYzRepository;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkZfRepository;
import net.geozen.lhc3.nums.SeqkNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqkZfZValueService extends BaseZfZValueCalService<Lhc3SeqkYz, Lhc3SeqkZf> {
	@Autowired
	private Lhc3SeqkYzRepository yzRepository;

	@Autowired
	private Lhc3SeqkZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqkZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqkYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqkNums.LISTS.get(pos);
	}

}
