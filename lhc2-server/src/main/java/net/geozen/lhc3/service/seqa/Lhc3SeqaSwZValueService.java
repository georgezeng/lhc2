package net.geozen.lhc3.service.seqa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaSw;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaSwRepository;
import net.geozen.lhc3.nums.SeqaNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqaSwZValueService extends BaseSwZValueCalService<Lhc3SeqaSw> {
	@Autowired
	private Lhc3SeqaSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqaSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqaNums.LISTS.get(pos);
	}

}
