package net.geozen.lhc2.service.slq.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.bs.Slqbsyz;
import net.geozen.lhc2.jpa.slq.bs.SlqbsyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqbsyzCalculationService extends BasePosYzCalculationService<Slqbsyz> {

	@Autowired
	private SlqbsyzRepository yzRepository;

	@Autowired
	private SlqbszfCalculationService zfService;

	@Autowired
	private SlqbsswCalculationService swService;

	@Autowired
	private SlqbsCalculationHandler handler;

	@Override
	protected BaseYzRepository<Slqbsyz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Slqbsyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Slqbsyz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	public int getEndPos() {
		return 16;
	}

}
