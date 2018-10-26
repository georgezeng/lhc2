package net.geozen.lhc2.service.z7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.z7.Z7yz;
import net.geozen.lhc2.domain.z7.Z7zf;
import net.geozen.lhc2.jpa.z7.Z7yzRepository;
import net.geozen.lhc2.jpa.z7.Z7zfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Z7zfCalculationService extends BaseZfCalculationService<Z7yz, Z7zf> {
	
	@Autowired
	private Z7yzRepository yzRepository;

	@Autowired
	private Z7zfRepository zfRepository;

	@Autowired
	private Z7CalculationHandler handler;

	@Override
	protected BaseZfRepository<Z7zf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Z7yz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 10;
	}

}
