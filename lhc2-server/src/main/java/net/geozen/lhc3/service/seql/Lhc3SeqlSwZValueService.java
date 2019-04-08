package net.geozen.lhc3.service.seql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seql.Lhc3SeqlSw;
import net.geozen.lhc3.jpa.seql.Lhc3SeqlSwRepository;
import net.geozen.lhc3.nums.SeqlNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqlSwZValueService extends BaseSwZValueCalService<Lhc3SeqlSw> {
	@Autowired
	private Lhc3SeqlSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqlSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqlNums.LISTS.get(pos);
	}

}
