package net.geozen.lhc3.service.seqd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdYz;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdZf;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdYzRepository;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdZfRepository;
import net.geozen.lhc3.nums.SeqdNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqdZfZValueService extends BaseZfZValueCalService<Lhc3SeqdYz, Lhc3SeqdZf> {
	@Autowired
	private Lhc3SeqdYzRepository yzRepository;

	@Autowired
	private Lhc3SeqdZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqdZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqdYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqdNums.LISTS.get(pos);
	}

}
