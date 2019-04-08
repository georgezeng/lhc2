package net.geozen.lhc3.service.seqg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgSw;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgSwRepository;
import net.geozen.lhc3.nums.SeqgNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqgSwZValueService extends BaseSwZValueCalService<Lhc3SeqgSw> {
	@Autowired
	private Lhc3SeqgSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqgSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqgNums.LISTS.get(pos);
	}

}
