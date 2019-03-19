package net.geozen.lhc2.service.z7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.z7.Z7sw;
import net.geozen.lhc2.domain.z7.Z7yz;
import net.geozen.lhc2.domain.z7.Z7zf;
import net.geozen.lhc2.jpa.z7.Z7swRepository;
import net.geozen.lhc2.jpa.z7.Z7yzRepository;
import net.geozen.lhc2.jpa.z7.Z7zfRepository;
import net.geozen.lhc2.nums.Z7Nums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class Z7zfZValueCalService extends BaseZfZValueCalService<Z7yz, Z7zf, Z7sw> {
	@Autowired
	private Z7yzRepository yzRepository;
	@Autowired
	private Z7zfRepository zfRepository;
	@Autowired
	private Z7swRepository swRepository;

	@Override
	protected BaseYzRepository<Z7yz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Z7zf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Z7sw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 10;
	}

	@Override
	protected Class<?> getNumsClass() {
		return Z7Nums.class;
	}

	@Override
	protected String[] getFields() {
		return new String[] { "zf0", "zf1", "zf2", "zf3", "zf4", "zf5", "zf6", "zf7", "zf8", "zf9", "zf10", "zf11" };
	}

}
