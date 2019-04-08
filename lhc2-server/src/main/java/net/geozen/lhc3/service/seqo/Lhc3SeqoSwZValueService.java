package net.geozen.lhc3.service.seqo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqo.Lhc3SeqoSw;
import net.geozen.lhc3.jpa.seqo.Lhc3SeqoSwRepository;
import net.geozen.lhc3.nums.SeqoNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqoSwZValueService extends BaseSwZValueCalService<Lhc3SeqoSw> {
	@Autowired
	private Lhc3SeqoSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqoSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqoNums.LISTS.get(pos);
	}

}
