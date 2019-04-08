package net.geozen.lhc3.service.seqd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdSw;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdSwRepository;
import net.geozen.lhc3.nums.SeqdNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqdSwZValueService extends BaseSwZValueCalService<Lhc3SeqdSw> {
	@Autowired
	private Lhc3SeqdSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqdSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqdNums.LISTS.get(pos);
	}

}
