package net.geozen.lhc3.service.seqi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqi.Lhc3SeqiYz;
import net.geozen.lhc3.domain.seqi.Lhc3SeqiZf;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiYzRepository;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiZfRepository;
import net.geozen.lhc3.nums.SeqiNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqiZfZValueService extends BaseZfZValueCalService<Lhc3SeqiYz, Lhc3SeqiZf> {
	@Autowired
	private Lhc3SeqiYzRepository yzRepository;

	@Autowired
	private Lhc3SeqiZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqiZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqiYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqiNums.LISTS.get(pos);
	}

}
