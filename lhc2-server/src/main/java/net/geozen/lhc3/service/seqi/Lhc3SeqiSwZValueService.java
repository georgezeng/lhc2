package net.geozen.lhc3.service.seqi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.seqi.Lhc3SeqiSw;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiSwRepository;
import net.geozen.lhc3.nums.SeqiNums;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3SeqiSwZValueService extends BaseSwZValueCalService<Lhc3SeqiSw> {
	@Autowired
	private Lhc3SeqiSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3SeqiSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqiNums.LISTS.get(pos);
	}

}
