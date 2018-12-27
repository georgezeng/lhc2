package net.geozen.lhc2.service.z2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.z2.Z2sw;
import net.geozen.lhc2.domain.z2.Z2yz;
import net.geozen.lhc2.domain.z2.Z2zf;
import net.geozen.lhc2.jpa.z2.Z2swRepository;
import net.geozen.lhc2.jpa.z2.Z2yzRepository;
import net.geozen.lhc2.jpa.z2.Z2zfRepository;
import net.geozen.lhc2.nums.Z2Nums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class Z2zfZValueCalService extends BaseZfZValueCalService<Z2yz, Z2zf, Z2sw> {
	@Autowired
	private Z2yzRepository yzRepository;
	@Autowired
	private Z2zfRepository zfRepository;
	@Autowired
	private Z2swRepository swRepository;

	@Override
	protected BaseYzRepository<Z2yz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Z2zf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Z2sw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 12;
	}

	@Override
	protected Class<?> getNumsClass() {
		return Z2Nums.class;
	}

}
