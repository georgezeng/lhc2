package net.geozen.lhc2.service.dxds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.dxds.Dxds1yz;
import net.geozen.lhc2.jpa.dxds.Dxds1yzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Dxds1byzCalculationService extends BasePosYzCalculationService<Dxds1yz> {

	@Autowired
	private Dxds1yzRepository yzRepository;

	@Autowired
	private Dxds1bCalculationHandler handler;

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Dxds1yz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Dxds1yz, ?> getZfCalculationService() {
		return null;
	}

	@Override
	protected BaseSwCalculationService<Dxds1yz, ?> getSwCalculationService() {
		return null;
	}

	@Override
	public int getEndPos() {
		return 4;
	}

}
