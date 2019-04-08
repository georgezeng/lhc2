package net.geozen.lhc3.service.seqm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqm.Lhc3SeqmYz;
import net.geozen.lhc3.jpa.seqm.Lhc3SeqmYzRepository;
import net.geozen.lhc3.nums.SeqmNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqmYzZValueService extends BaseYzZValueCalService<Lhc3SeqmYz> {
	@Autowired
	private Lhc3SeqmYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqmYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqmNums.LISTS.get(pos);
	}

}
