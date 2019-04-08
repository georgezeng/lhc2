package net.geozen.lhc3.service.seqh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqh.Lhc3SeqhYz;
import net.geozen.lhc3.jpa.seqh.Lhc3SeqhYzRepository;
import net.geozen.lhc3.nums.SeqhNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqhYzZValueService extends BaseYzZValueCalService<Lhc3SeqhYz> {
	@Autowired
	private Lhc3SeqhYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqhYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqhNums.LISTS.get(pos);
	}

}
