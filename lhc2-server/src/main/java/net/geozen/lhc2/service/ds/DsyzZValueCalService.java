package net.geozen.lhc2.service.ds;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.ds.Dssw;
import net.geozen.lhc2.domain.ds.Dsyz;
import net.geozen.lhc2.jpa.ds.DsswRepository;
import net.geozen.lhc2.jpa.ds.DsyzRepository;
import net.geozen.lhc2.nums.DsNums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class DsyzZValueCalService extends BaseYzZValueCalService<Integer, Dsyz, Dssw> {
	@Autowired
	private DsyzRepository yzRepository;
	@Autowired
	private DsswRepository swRepository;

	@Override
	protected BaseYzRepository<Dsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Dssw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@Override
	protected List<Integer> getNums(Integer max) {
		return DsNums.LISTS.get(max);
	}

	@Override
	protected int getEndPos() {
		return 10;
	}

}
