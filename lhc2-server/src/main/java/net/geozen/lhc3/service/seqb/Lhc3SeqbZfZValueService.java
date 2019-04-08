package net.geozen.lhc3.service.seqb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqb.Lhc3SeqbYz;
import net.geozen.lhc3.domain.seqb.Lhc3SeqbZf;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbYzRepository;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbZfRepository;
import net.geozen.lhc3.nums.SeqbNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqbZfZValueService extends BaseZfZValueCalService<Lhc3SeqbYz, Lhc3SeqbZf> {
	@Autowired
	private Lhc3SeqbYzRepository yzRepository;

	@Autowired
	private Lhc3SeqbZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqbZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqbYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqbNums.LISTS.get(pos);
	}

}
