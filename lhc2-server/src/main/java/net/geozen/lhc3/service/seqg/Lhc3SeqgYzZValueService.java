package net.geozen.lhc3.service.seqg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqg.Lhc3SeqgYz;
import net.geozen.lhc3.jpa.seqg.Lhc3SeqgYzRepository;
import net.geozen.lhc3.nums.SeqgNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqgYzZValueService extends BaseYzZValueCalService<Lhc3SeqgYz> {
	@Autowired
	private Lhc3SeqgYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqgYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqgNums.LISTS.get(pos);
	}

}
