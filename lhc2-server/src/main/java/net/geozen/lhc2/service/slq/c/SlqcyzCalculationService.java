package net.geozen.lhc2.service.slq.c;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.c.Slqcyz;
import net.geozen.lhc2.jpa.slq.c.SlqcyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqcyzCalculationService extends BasePosYzCalculationService<Slqcyz> {

	@Autowired
	private SlqcyzRepository yzRepository;

	@Autowired
	private SlqczfCalculationService zfService;

	@Autowired
	private SlqcswCalculationService swService;

	@Autowired
	private SlqcCalculationHandler handler;

	@Override
	protected BaseYzRepository<Slqcyz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Slqcyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Slqcyz, ?> getSwCalculationService() {
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
