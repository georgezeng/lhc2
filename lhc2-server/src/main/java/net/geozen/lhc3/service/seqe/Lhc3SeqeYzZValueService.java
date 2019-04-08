package net.geozen.lhc3.service.seqe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqe.Lhc3SeqeYz;
import net.geozen.lhc3.jpa.seqe.Lhc3SeqeYzRepository;
import net.geozen.lhc3.nums.SeqeNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqeYzZValueService extends BaseYzZValueCalService<Lhc3SeqeYz> {
	@Autowired
	private Lhc3SeqeYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqeYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqeNums.LISTS.get(pos);
	}

}
