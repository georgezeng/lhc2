package net.geozen.lhc2.service.mw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.mw.Mwyz;
import net.geozen.lhc2.domain.mw.Mwzf;
import net.geozen.lhc2.jpa.mw.MwyzRepository;
import net.geozen.lhc2.jpa.mw.MwzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class MwzfCalculationService extends BaseZfCalculationService<Mwyz, Mwzf> {
	
	@Autowired
	private MwyzRepository yzRepository;

	@Autowired
	private MwzfRepository zfRepository;

	@Autowired
	private MwCalculationHandler handler;

	@Override
	protected BaseZfRepository<Mwzf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Mwyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 10;
	}

}
