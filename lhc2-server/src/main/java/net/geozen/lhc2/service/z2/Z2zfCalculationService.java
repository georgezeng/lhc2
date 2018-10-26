package net.geozen.lhc2.service.z2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.z2.Z2yz;
import net.geozen.lhc2.domain.z2.Z2zf;
import net.geozen.lhc2.jpa.z2.Z2yzRepository;
import net.geozen.lhc2.jpa.z2.Z2zfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Z2zfCalculationService extends BaseZfCalculationService<Z2yz, Z2zf> {

	@Autowired
	private Z2yzRepository yzRepository;
	
	@Autowired
	private Z2zfRepository zfRepository;

	@Autowired
	private Z2CalculationHandler handler;

	@Override
	protected BaseZfRepository<Z2zf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Z2yz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 12;
	}

}
