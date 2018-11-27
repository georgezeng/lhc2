package net.geozen.lhc2.service.slq.c;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.c.Slqcyz;
import net.geozen.lhc2.domain.slq.c.Slqczf;
import net.geozen.lhc2.jpa.slq.c.SlqcyzRepository;
import net.geozen.lhc2.jpa.slq.c.SlqczfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqczfCalculationService extends BaseZfCalculationService<Slqcyz, Slqczf> {

	@Autowired
	private SlqcyzRepository yzRepository;

	@Autowired
	private SlqczfRepository zfRepository;

	@Autowired
	private SlqcCalculationHandler handler;

	@Override
	protected BaseZfRepository<Slqczf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Slqcyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 16;
	}

}
