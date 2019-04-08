package net.geozen.lhc3.service.seqi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqi.Lhc3SeqiYz;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiYzRepository;
import net.geozen.lhc3.nums.SeqiNums;
import net.geozen.lhc3.service.base.BaseYzZValueCalService;

@Service
public class Lhc3SeqiYzZValueService extends BaseYzZValueCalService<Lhc3SeqiYz> {
	@Autowired
	private Lhc3SeqiYzRepository repository;

	@Override
	protected BaseRepository<Lhc3SeqiYz> getRepository() {
		return repository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqiNums.LISTS.get(pos);
	}

}
