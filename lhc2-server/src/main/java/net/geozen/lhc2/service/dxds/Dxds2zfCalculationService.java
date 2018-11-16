package net.geozen.lhc2.service.dxds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.dxds.Dxds2yz;
import net.geozen.lhc2.domain.dxds.Dxds2zf;
import net.geozen.lhc2.jpa.dxds.Dxds2yzRepository;
import net.geozen.lhc2.jpa.dxds.Dxds2zfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Dxds2zfCalculationService extends BaseZfCalculationService<Dxds2yz, Dxds2zf> {

	@Autowired
	private Dxds2yzRepository yzRepository;

	@Autowired
	private Dxds2zfRepository zfRepository;

	@Autowired
	private Dxds2CalculationHandler handler;

	@Override
	protected BaseZfRepository<Dxds2zf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Dxds2yz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 10;
	}

}
