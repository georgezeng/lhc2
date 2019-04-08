package net.geozen.lhc3.service.seqe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqe.Lhc3SeqeYz;
import net.geozen.lhc3.domain.seqe.Lhc3SeqeZf;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeYzRepository;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeZfRepository;
import net.geozen.lhc3.nums.SeqeNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqeZfZValueService extends BaseZfZValueCalService<Lhc3SeqeYz, Lhc3SeqeZf> {
	@Autowired
	private Lhc3SeqeYzRepository yzRepository;

	@Autowired
	private Lhc3SeqeZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqeZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqeYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqeNums.LISTS.get(pos);
	}

}
