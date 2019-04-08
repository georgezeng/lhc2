package net.geozen.lhc3.service.seqq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqq.Lhc3SeqqYz;
import net.geozen.lhc3.jpa.seqq.Lhc3SeqqYzRepository;
import net.geozen.lhc3.nums.SeqqNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqqYzZValueService extends BaseYzZValueCalService<Lhc3SeqqYz> {
	@Autowired
	private Lhc3SeqqYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqqYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqqNums.LISTS.get(pos);
	}

}
