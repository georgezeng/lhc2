package net.geozen.lhc3.service.seqr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqr.Lhc3SeqrSw;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrSwRepository;
import net.geozen.lhc3.nums.SeqrNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqrSwZValueService extends BaseSwZValueCalService<Lhc3SeqrSw> {
	@Autowired
	private Lhc3SeqrSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqrSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqrNums.LISTS.get(pos);
	}

}
