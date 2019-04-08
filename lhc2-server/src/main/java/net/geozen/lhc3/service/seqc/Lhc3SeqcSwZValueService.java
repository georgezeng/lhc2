package net.geozen.lhc3.service.seqc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcSw;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcSwRepository;
import net.geozen.lhc3.nums.SeqcNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqcSwZValueService extends BaseSwZValueCalService<Lhc3SeqcSw> {
	@Autowired
	private Lhc3SeqcSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqcSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqcNums.LISTS.get(pos);
	}

}
