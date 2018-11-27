package net.geozen.lhc2.service.slq.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.b.Slqbyz;
import net.geozen.lhc2.jpa.slq.b.SlqbyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqbyzCalculationService extends BasePosYzCalculationService<Slqbyz> {

	@Autowired
	private SlqbyzRepository yzRepository;

	@Autowired
	private SlqbzfCalculationService zfService;

	@Autowired
	private SlqbswCalculationService swService;

	@Autowired
	private SlqbCalculationHandler handler;

	@Override
	protected BaseYzRepository<Slqbyz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Slqbyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Slqbyz, ?> getSwCalculationService() {
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
