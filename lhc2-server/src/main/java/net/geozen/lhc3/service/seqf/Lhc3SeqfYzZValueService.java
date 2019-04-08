package net.geozen.lhc3.service.seqf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqf.Lhc3SeqfYz;
import net.geozen.lhc3.jpa.seqf.Lhc3SeqfYzRepository;
import net.geozen.lhc3.nums.SeqfNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqfYzZValueService extends BaseYzZValueCalService<Lhc3SeqfYz> {
	@Autowired
	private Lhc3SeqfYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqfYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqfNums.LISTS.get(pos);
	}

}
