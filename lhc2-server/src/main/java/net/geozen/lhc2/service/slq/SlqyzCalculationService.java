package net.geozen.lhc2.service.slq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.Slqyz;
import net.geozen.lhc2.jpa.slq.SlqyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqyzCalculationService extends BasePosYzCalculationService<Slqyz> {

	@Autowired
	private SlqyzRepository yzRepository;

	@Autowired
	private SlqzfCalculationService zfService;

	@Autowired
	private SlqswCalculationService swService;

	@Autowired
	private SlqCalculationHandler handler;

	@Override
	protected BaseYzRepository<Slqyz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Slqyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Slqyz, ?> getSwCalculationService() {
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
