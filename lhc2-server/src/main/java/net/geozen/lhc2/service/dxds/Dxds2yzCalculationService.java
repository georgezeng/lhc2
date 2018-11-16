package net.geozen.lhc2.service.dxds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.dxds.Dxds2yz;
import net.geozen.lhc2.jpa.dxds.Dxds2yzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Dxds2yzCalculationService extends BasePosYzCalculationService<Dxds2yz> {

	@Autowired
	private Dxds2yzRepository yzRepository;

	@Autowired
	private Dxds2zfCalculationService zfService;

	@Autowired
	private Dxds2CalculationHandler handler;

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Dxds2yz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Dxds2yz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Dxds2yz, ?> getSwCalculationService() {
		return null;
	}

	@Override
	public int getEndPos() {
		return 4;
	}

}
