package net.geozen.lhc3.service.seqd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqd.Lhc3SeqdYz;
import net.geozen.lhc3.jpa.seqd.Lhc3SeqdYzRepository;
import net.geozen.lhc3.nums.SeqdNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqdYzZValueService extends BaseYzZValueCalService<Lhc3SeqdYz> {
	@Autowired
	private Lhc3SeqdYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqdYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqdNums.LISTS.get(pos);
	}

}
