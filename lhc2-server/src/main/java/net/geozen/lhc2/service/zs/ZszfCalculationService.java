package net.geozen.lhc2.service.zs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.zs.Zsyz;
import net.geozen.lhc2.domain.zs.Zszf;
import net.geozen.lhc2.jpa.zs.ZsyzRepository;
import net.geozen.lhc2.jpa.zs.ZszfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class ZszfCalculationService extends BaseZfCalculationService<Zsyz, Zszf> {
	
	@Autowired
	private ZsyzRepository yzRepository;

	@Autowired
	private ZszfRepository zfRepository;

	@Autowired
	private ZsCalculationHandler handler;

	@Override
	protected BaseZfRepository<Zszf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Zsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 9;
	}

}
