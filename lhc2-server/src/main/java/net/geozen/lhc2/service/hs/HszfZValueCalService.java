package net.geozen.lhc2.service.hs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.hs.Hssw;
import net.geozen.lhc2.domain.hs.Hsyz;
import net.geozen.lhc2.domain.hs.Hszf;
import net.geozen.lhc2.jpa.hs.HsswRepository;
import net.geozen.lhc2.jpa.hs.HsyzRepository;
import net.geozen.lhc2.jpa.hs.HszfRepository;
import net.geozen.lhc2.nums.HsNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class HszfZValueCalService extends BaseZfZValueCalService<Hsyz, Hszf, Hssw> {
	@Autowired
	private HsyzRepository yzRepository;
	@Autowired
	private HszfRepository zfRepository;
	@Autowired
	private HsswRepository swRepository;

	@Override
	protected BaseYzRepository<Hsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Hszf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Hssw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 10;
	}

	@Override
	protected Class<?> getNumsClass() {
		return HsNums.class;
	}

}
