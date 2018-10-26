package net.geozen.lhc2.service.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.ds.Dsyz;
import net.geozen.lhc2.domain.ds.Dszf;
import net.geozen.lhc2.jpa.ds.DsyzRepository;
import net.geozen.lhc2.jpa.ds.DszfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class DszfCalculationService extends BaseZfCalculationService<Dsyz, Dszf> {

	@Autowired
	private DsyzRepository yzRepository;

	@Autowired
	private DszfRepository zfRepository;

	@Autowired
	private DsCalculationHandler handler;

	@Override
	protected BaseZfRepository<Dszf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Dsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 10;
	}

}
