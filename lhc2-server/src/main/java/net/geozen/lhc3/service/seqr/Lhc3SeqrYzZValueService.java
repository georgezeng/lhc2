package net.geozen.lhc3.service.seqr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqr.Lhc3SeqrYz;
import net.geozen.lhc3.jpa.seqr.Lhc3SeqrYzRepository;
import net.geozen.lhc3.nums.SeqrNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqrYzZValueService extends BaseYzZValueCalService<Lhc3SeqrYz> {
	@Autowired
	private Lhc3SeqrYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqrYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqrNums.LISTS.get(pos);
	}

}
