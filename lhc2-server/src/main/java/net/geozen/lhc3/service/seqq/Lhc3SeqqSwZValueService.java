package net.geozen.lhc3.service.seqq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqSw;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqSwRepository;
import net.geozen.lhc3.nums.SeqqNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqqSwZValueService extends BaseSwZValueCalService<Lhc3SeqqSw> {
	@Autowired
	private Lhc3SeqqSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqqSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqqNums.LISTS.get(pos);
	}

}
