package net.geozen.lhc3.service.seqb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqb.Lhc3SeqbYz;
import net.geozen.lhc3.jpa.seqb.Lhc3SeqbYzRepository;
import net.geozen.lhc3.nums.SeqbNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqbYzZValueService extends BaseYzZValueCalService<Lhc3SeqbYz> {
	@Autowired
	private Lhc3SeqbYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqbYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqbNums.LISTS.get(pos);
	}

}
