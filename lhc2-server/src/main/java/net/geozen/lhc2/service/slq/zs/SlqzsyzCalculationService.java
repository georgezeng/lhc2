package net.geozen.lhc2.service.slq.zs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.zs.Slqzsyz;
import net.geozen.lhc2.jpa.slq.zs.SlqzsyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqzsyzCalculationService extends BasePosYzCalculationService<Slqzsyz> {

	@Autowired
	private SlqzsyzRepository yzRepository;

	@Autowired
	private SlqzszfCalculationService zfService;

	@Autowired
	private SlqzsswCalculationService swService;

	@Autowired
	private SlqzsCalculationHandler handler;

	@Override
	protected BaseYzRepository<Slqzsyz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Slqzsyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Slqzsyz, ?> getSwCalculationService() {
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
