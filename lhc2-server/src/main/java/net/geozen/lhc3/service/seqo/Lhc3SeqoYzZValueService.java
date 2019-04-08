package net.geozen.lhc3.service.seqo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqo.Lhc3SeqoYz;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoYzRepository;
import net.geozen.lhc3.nums.SeqoNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqoYzZValueService extends BaseYzZValueCalService<Lhc3SeqoYz> {
	@Autowired
	private Lhc3SeqoYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqoYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqoNums.LISTS.get(pos);
	}

}
