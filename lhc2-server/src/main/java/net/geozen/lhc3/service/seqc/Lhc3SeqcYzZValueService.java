package net.geozen.lhc3.service.seqc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqc.Lhc3SeqcYz;
import net.geozen.lhc3.jpa.seqc.Lhc3SeqcYzRepository;
import net.geozen.lhc3.nums.SeqcNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqcYzZValueService extends BaseYzZValueCalService<Lhc3SeqcYz> {
	@Autowired
	private Lhc3SeqcYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqcYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqcNums.LISTS.get(pos);
	}

}
