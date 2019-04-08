package net.geozen.lhc3.service.seqn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnSw;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnSwRepository;
import net.geozen.lhc3.nums.SeqnNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqnSwZValueService extends BaseSwZValueCalService<Lhc3SeqnSw> {
	@Autowired
	private Lhc3SeqnSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqnSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqnNums.LISTS.get(pos);
	}

}
