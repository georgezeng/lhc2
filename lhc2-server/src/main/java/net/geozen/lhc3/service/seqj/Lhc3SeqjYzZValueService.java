package net.geozen.lhc3.service.seqj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqj.Lhc3SeqjYz;
import net.geozen.lhc3.jpa.seqj.Lhc3SeqjYzRepository;
import net.geozen.lhc3.nums.SeqjNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqjYzZValueService extends BaseYzZValueCalService<Lhc3SeqjYz> {
	@Autowired
	private Lhc3SeqjYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqjYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqjNums.LISTS.get(pos);
	}

}
