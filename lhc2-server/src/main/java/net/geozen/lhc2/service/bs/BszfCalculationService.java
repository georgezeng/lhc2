package net.geozen.lhc2.service.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.bs.Bsyz;
import net.geozen.lhc2.domain.bs.Bszf;
import net.geozen.lhc2.jpa.bs.BsyzRepository;
import net.geozen.lhc2.jpa.bs.BszfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class BszfCalculationService extends BaseZfCalculationService<Bsyz, Bszf> {

	@Autowired
	private BszfRepository zfRepository;

	@Autowired
	private BsyzRepository yzRepository;

	@Autowired
	private BsCalculationHandler handler;

	@Override
	protected BaseZfRepository<Bszf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Bsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 9;
	}

}
