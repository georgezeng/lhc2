package net.geozen.lhc3.service.seqj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqj.Lhc3SeqjSw;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjSwRepository;
import net.geozen.lhc3.nums.SeqjNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqjSwZValueService extends BaseSwZValueCalService<Lhc3SeqjSw> {
	@Autowired
	private Lhc3SeqjSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqjSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqjNums.LISTS.get(pos);
	}

}
