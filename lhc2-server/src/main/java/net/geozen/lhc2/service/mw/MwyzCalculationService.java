package net.geozen.lhc2.service.mw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.mw.Mwyz;
import net.geozen.lhc2.jpa.mw.MwyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class MwyzCalculationService extends BasePosYzCalculationService<Mwyz> {

	@Autowired
	private MwyzRepository yzRepository;

	@Autowired
	private MwzfCalculationService zfService;

	@Autowired
	private MwswCalculationService swService;

	@Autowired
	private MwCalculationHandler handler;

	@Override
	protected BaseYzRepository<Mwyz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Mwyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Mwyz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	public int getEndPos() {
		return 10;
	}

}
