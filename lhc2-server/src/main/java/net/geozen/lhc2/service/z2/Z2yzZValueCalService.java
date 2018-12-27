package net.geozen.lhc2.service.z2;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.z2.Z2sw;
import net.geozen.lhc2.domain.z2.Z2yz;
import net.geozen.lhc2.jpa.z2.Z2swRepository;
import net.geozen.lhc2.jpa.z2.Z2yzRepository;
import net.geozen.lhc2.nums.Z2Nums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class Z2yzZValueCalService extends BaseYzZValueCalService<Integer, Z2yz, Z2sw> {
	@Autowired
	private Z2yzRepository yzRepository;
	@Autowired
	private Z2swRepository swRepository;

	@Override
	protected BaseYzRepository<Z2yz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Z2sw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
	}

	@Override
	protected List<Integer> getNums(Integer max) {
		return Z2Nums.LISTS.get(max);
	}

	@Override
	protected int getEndPos() {
		return 12;
	}

}
