package net.geozen.lhc3.service.seqf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfSw;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfSwRepository;
import net.geozen.lhc3.nums.SeqfNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqfSwZValueService extends BaseSwZValueCalService<Lhc3SeqfSw> {
	@Autowired
	private Lhc3SeqfSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqfSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqfNums.LISTS.get(pos);
	}

}
