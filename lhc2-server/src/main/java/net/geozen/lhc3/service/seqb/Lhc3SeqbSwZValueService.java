package net.geozen.lhc3.service.seqb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqb.Lhc3SeqbSw;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbSwRepository;
import net.geozen.lhc3.nums.SeqbNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqbSwZValueService extends BaseSwZValueCalService<Lhc3SeqbSw> {
	@Autowired
	private Lhc3SeqbSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqbSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqbNums.LISTS.get(pos);
	}

}
