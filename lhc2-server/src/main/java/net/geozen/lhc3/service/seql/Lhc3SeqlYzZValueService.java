package net.geozen.lhc3.service.seql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seql.Lhc3SeqlYz;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlYzRepository;
import net.geozen.lhc3.nums.SeqlNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqlYzZValueService extends BaseYzZValueCalService<Lhc3SeqlYz> {
	@Autowired
	private Lhc3SeqlYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqlYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqlNums.LISTS.get(pos);
	}

}
