package net.geozen.lhc3.service.seqa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaYz;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaYzRepository;
import net.geozen.lhc3.nums.SeqaNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqaYzZValueService extends BaseYzZValueCalService<Lhc3SeqaYz> {
	@Autowired
	private Lhc3SeqaYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqaYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqaNums.LISTS.get(pos);
	}

}
