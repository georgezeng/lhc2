package net.geozen.lhc3.service.seqq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqYz;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqZf;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqYzRepository;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqZfRepository;
import net.geozen.lhc3.nums.SeqqNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqqZfZValueService extends BaseZfZValueCalService<Lhc3SeqqYz, Lhc3SeqqZf> {
	@Autowired
	private Lhc3SeqqYzRepository yzRepository;

	@Autowired
	private Lhc3SeqqZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqqZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqqYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqqNums.LISTS.get(pos);
	}

}
