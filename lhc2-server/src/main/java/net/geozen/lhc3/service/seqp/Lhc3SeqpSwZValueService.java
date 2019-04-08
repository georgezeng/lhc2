package net.geozen.lhc3.service.seqp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqp.Lhc3SeqpSw;
import net.geozen.lhc3.jpa.seqp.Lhc3SeqpSwRepository;
import net.geozen.lhc3.nums.SeqpNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqpSwZValueService extends BaseSwZValueCalService<Lhc3SeqpSw> {
	@Autowired
	private Lhc3SeqpSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqpSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqpNums.LISTS.get(pos);
	}

}
