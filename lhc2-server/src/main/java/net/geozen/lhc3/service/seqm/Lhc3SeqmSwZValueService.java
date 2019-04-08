package net.geozen.lhc3.service.seqm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmSw;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmSwRepository;
import net.geozen.lhc3.nums.SeqmNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqmSwZValueService extends BaseSwZValueCalService<Lhc3SeqmSw> {
	@Autowired
	private Lhc3SeqmSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqmSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqmNums.LISTS.get(pos);
	}

}
