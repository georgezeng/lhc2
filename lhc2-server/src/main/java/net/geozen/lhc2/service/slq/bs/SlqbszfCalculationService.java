package net.geozen.lhc2.service.slq.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.bs.Slqbsyz;
import net.geozen.lhc2.domain.slq.bs.Slqbszf;
import net.geozen.lhc2.jpa.slq.bs.SlqbsyzRepository;
import net.geozen.lhc2.jpa.slq.bs.SlqbszfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqbszfCalculationService extends BaseZfCalculationService<Slqbsyz, Slqbszf> {

	@Autowired
	private SlqbsyzRepository yzRepository;

	@Autowired
	private SlqbszfRepository zfRepository;

	@Autowired
	private SlqbsCalculationHandler handler;

	@Override
	protected BaseZfRepository<Slqbszf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Slqbsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 16;
	}

}
