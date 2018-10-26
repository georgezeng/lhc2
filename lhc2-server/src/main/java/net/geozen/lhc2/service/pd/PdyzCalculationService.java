package net.geozen.lhc2.service.pd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.pd.Pdyz;
import net.geozen.lhc2.jpa.pd.PdyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class PdyzCalculationService extends BasePosYzCalculationService<Pdyz> {

	@Autowired
	private PdyzRepository yzRepository;

	@Autowired
	private PdzfCalculationService zfService;

	@Autowired
	private PdswCalculationService swService;

	@Autowired
	private PdCalculationHandler handler;

	@Override
	protected BaseYzRepository<Pdyz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Pdyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Pdyz, ?> getSwCalculationService() {
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
