package net.geozen.lhc2.service.pd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.pd.Pdyz;
import net.geozen.lhc2.domain.pd.Pdzf;
import net.geozen.lhc2.jpa.pd.PdyzRepository;
import net.geozen.lhc2.jpa.pd.PdzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class PdzfCalculationService extends BaseZfCalculationService<Pdyz, Pdzf> {
	
	@Autowired
	private PdyzRepository yzRepository;

	@Autowired
	private PdzfRepository zfRepository;

	@Autowired
	private PdCalculationHandler handler;

	@Override
	protected BaseZfRepository<Pdzf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Pdyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 12;
	}

}
