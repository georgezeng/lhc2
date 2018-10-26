package net.geozen.lhc2.service.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.ds.Dsyz;
import net.geozen.lhc2.jpa.ds.DsyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class DsyzCalculationService extends BasePosYzCalculationService<Dsyz> {

	@Autowired
	private DsyzRepository yzRepository;

	@Autowired
	private DszfCalculationService zfService;

	@Autowired
	private DsswCalculationService swService;

	@Autowired
	private DsCalculationHandler handler;

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Dsyz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Dsyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Dsyz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	public int getEndPos() {
		return 10;
	}

}
