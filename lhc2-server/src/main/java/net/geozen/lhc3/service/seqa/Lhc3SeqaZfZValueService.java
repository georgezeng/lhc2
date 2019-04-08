package net.geozen.lhc3.service.seqa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaYz;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaZf;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaYzRepository;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaZfRepository;
import net.geozen.lhc3.nums.SeqaNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqaZfZValueService extends BaseZfZValueCalService<Lhc3SeqaYz, Lhc3SeqaZf> {
	@Autowired
	private Lhc3SeqaYzRepository yzRepository;

	@Autowired
	private Lhc3SeqaZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqaZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqaYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqaNums.LISTS.get(pos);
	}

}
