package net.geozen.lhc3.service.seqe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqe.Lhc3SeqeSw;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeSwRepository;
import net.geozen.lhc3.nums.SeqeNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqeSwZValueService extends BaseSwZValueCalService<Lhc3SeqeSw> {
	@Autowired
	private Lhc3SeqeSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqeSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqeNums.LISTS.get(pos);
	}

}
