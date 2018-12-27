package net.geozen.lhc2.service.hs;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.hs.Hssw;
import net.geozen.lhc2.domain.hs.Hsyz;
import net.geozen.lhc2.jpa.hs.HsswRepository;
import net.geozen.lhc2.jpa.hs.HsyzRepository;
import net.geozen.lhc2.nums.HsNums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class HsyzZValueCalService extends BaseYzZValueCalService<Integer, Hsyz, Hssw> {
	@Autowired
	private HsyzRepository yzRepository;
	@Autowired
	private HsswRepository swRepository;

	@Override
	protected BaseYzRepository<Hsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Hssw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@Override
	protected List<Integer> getNums(Integer max) {
		return HsNums.LISTS.get(max);
	}

	@Override
	protected int getEndPos() {
		return 10;
	}

}
