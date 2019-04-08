package net.geozen.lhc3.service.seql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seql.Lhc3SeqlYz;
import net.geozen.lhc3.domain.seql.Lhc3SeqlZf;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlYzRepository;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlZfRepository;
import net.geozen.lhc3.nums.SeqlNums;
import net.geozen.lhc3.service.base.BaseZfZValueCalService;

@Service
public class Lhc3SeqlZfZValueService extends BaseZfZValueCalService<Lhc3SeqlYz, Lhc3SeqlZf> {
	@Autowired
	private Lhc3SeqlYzRepository yzRepository;

	@Autowired
	private Lhc3SeqlZfRepository zfRepository;

	@Override
	protected BaseRepository<Lhc3SeqlZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseRepository<Lhc3SeqlYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqlNums.LISTS.get(pos);
	}

}
