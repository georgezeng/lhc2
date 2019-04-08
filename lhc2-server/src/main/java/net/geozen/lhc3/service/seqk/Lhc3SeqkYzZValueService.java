package net.geozen.lhc3.service.seqk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqk.Lhc3SeqkYz;
import net.geozen.lhc3.jpa.seqk.Lhc3SeqkYzRepository;
import net.geozen.lhc3.nums.SeqkNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqkYzZValueService extends BaseYzZValueCalService<Lhc3SeqkYz> {
	@Autowired
	private Lhc3SeqkYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqkYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqkNums.LISTS.get(pos);
	}

}
