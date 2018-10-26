package net.geozen.lhc2.service.sw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.sw.Swyz;
import net.geozen.lhc2.domain.sw.Swzf;
import net.geozen.lhc2.jpa.sw.SwyzRepository;
import net.geozen.lhc2.jpa.sw.SwzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SwzfCalculationService extends BaseZfCalculationService<Swyz, Swzf> {
	
	@Autowired
	private SwyzRepository yzRepository;

	@Autowired
	private SwzfRepository zfRepository;

	@Autowired
	private SwCalculationHandler handler;

	@Override
	protected BaseZfRepository<Swzf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Swyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 5;
	}

}
