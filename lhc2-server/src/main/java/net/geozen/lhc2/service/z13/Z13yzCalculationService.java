package net.geozen.lhc2.service.z13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.z13.Z13yz;
import net.geozen.lhc2.jpa.z13.Z13yzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Z13yzCalculationService extends BasePosYzCalculationService<Z13yz> {

	@Autowired
	private Z13yzRepository yzRepository;

	@Autowired
	private Z13zfCalculationService zfService;

	@Autowired
	private Z13swCalculationService swService;

	@Autowired
	private Z13CalculationHandler handler;

	@Override
	protected BaseYzRepository<Z13yz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Z13yz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Z13yz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	public int getEndPos() {
		return 12;
	}

}
