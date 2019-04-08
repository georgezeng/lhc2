package net.geozen.lhc3.service.seqo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqo.Lhc3SeqoYz;
import net.geozen.lhc3.domain.seqo.Lhc3SeqoZf;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoYzRepository;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoZfRepository;
import net.geozen.lhc3.nums.SeqoNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqoZfZValueService extends BaseZfZValueCalService<Lhc3SeqoYz, Lhc3SeqoZf> {
	@Autowired
	private Lhc3SeqoYzRepository yzRepository;

	@Autowired
	private Lhc3SeqoZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqoZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqoYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqoNums.LISTS.get(pos);
	}

}
