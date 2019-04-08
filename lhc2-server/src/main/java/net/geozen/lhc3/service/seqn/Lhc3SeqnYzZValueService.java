package net.geozen.lhc3.service.seqn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqn.Lhc3SeqnYz;
import net.geozen.lhc3.jpa.seqn.Lhc3SeqnYzRepository;
import net.geozen.lhc3.nums.SeqnNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqnYzZValueService extends BaseYzZValueCalService<Lhc3SeqnYz> {
	@Autowired
	private Lhc3SeqnYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqnYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqnNums.LISTS.get(pos);
	}

}
