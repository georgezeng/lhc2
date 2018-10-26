package net.geozen.lhc2.service.slq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.Slqyz;
import net.geozen.lhc2.domain.slq.Slqzf;
import net.geozen.lhc2.jpa.slq.SlqyzRepository;
import net.geozen.lhc2.jpa.slq.SlqzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqzfCalculationService extends BaseZfCalculationService<Slqyz, Slqzf> {

	@Autowired
	private SlqyzRepository yzRepository;

	@Autowired
	private SlqzfRepository zfRepository;

	@Autowired
	private SlqCalculationHandler handler;

	@Override
	protected BaseZfRepository<Slqzf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Slqyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 16;
	}

}
