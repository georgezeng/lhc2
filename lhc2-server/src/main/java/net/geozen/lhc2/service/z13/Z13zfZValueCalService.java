package net.geozen.lhc2.service.z13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.z13.Z13sw;
import net.geozen.lhc2.domain.z13.Z13yz;
import net.geozen.lhc2.domain.z13.Z13zf;
import net.geozen.lhc2.jpa.z13.Z13swRepository;
import net.geozen.lhc2.jpa.z13.Z13yzRepository;
import net.geozen.lhc2.jpa.z13.Z13zfRepository;
import net.geozen.lhc2.nums.Z13Nums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class Z13zfZValueCalService extends BaseZfZValueCalService<Z13yz, Z13zf, Z13sw> {
	@Autowired
	private Z13yzRepository yzRepository;
	@Autowired
	private Z13zfRepository zfRepository;
	@Autowired
	private Z13swRepository swRepository;

	@Override
	protected BaseYzRepository<Z13yz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Z13zf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Z13sw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 12;
	}

	@Override
	protected Class<?> getNumsClass() {
		return Z13Nums.class;
	}

}
