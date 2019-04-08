package net.geozen.lhc3.service.seqh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhSw;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhSwRepository;
import net.geozen.lhc3.nums.SeqhNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqhSwZValueService extends BaseSwZValueCalService<Lhc3SeqhSw> {
	@Autowired
	private Lhc3SeqhSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqhSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqhNums.LISTS.get(pos);
	}

}
