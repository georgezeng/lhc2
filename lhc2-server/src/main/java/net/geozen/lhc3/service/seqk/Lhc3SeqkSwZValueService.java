package net.geozen.lhc3.service.seqk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqk.Lhc3SeqkSw;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkSwRepository;
import net.geozen.lhc3.nums.SeqkNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqkSwZValueService extends BaseSwZValueCalService<Lhc3SeqkSw> {
	@Autowired
	private Lhc3SeqkSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqkSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqkNums.LISTS.get(pos);
	}

}
