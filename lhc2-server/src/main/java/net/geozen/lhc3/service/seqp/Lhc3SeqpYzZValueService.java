package net.geozen.lhc3.service.seqp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqp.Lhc3SeqpYz;
import net.geozen.lhc3.jpa.seqp.Lhc3SeqpYzRepository;
import net.geozen.lhc3.nums.SeqpNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqpYzZValueService extends BaseYzZValueCalService<Lhc3SeqpYz> {
	@Autowired
	private Lhc3SeqpYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqpYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqpNums.LISTS.get(pos);
	}

}
