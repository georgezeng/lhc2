package net.geozen.lhc2.service.mw;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.mw.Mwsw;
import net.geozen.lhc2.domain.mw.Mwyz;
import net.geozen.lhc2.jpa.mw.MwswRepository;
import net.geozen.lhc2.jpa.mw.MwyzRepository;
import net.geozen.lhc2.nums.MwNums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class MwyzZValueCalService extends BaseYzZValueCalService<Integer, Mwyz, Mwsw> {
	@Autowired
	private MwyzRepository yzRepository;
	@Autowired
	private MwswRepository swRepository;

	@Override
	protected BaseYzRepository<Mwyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Mwsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@Override
	protected List<Integer> getNums(Integer max) {
		return MwNums.LISTS.get(max);
	}

	@Override
	protected int getEndPos() {
		return 10;
	}

}
