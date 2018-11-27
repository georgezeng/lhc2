package net.geozen.lhc2.service.slq.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.a.Slqayz;
import net.geozen.lhc2.jpa.slq.a.SlqayzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqayzCalculationService extends BasePosYzCalculationService<Slqayz> {

	@Autowired
	private SlqayzRepository yzRepository;

	@Autowired
	private SlqazfCalculationService zfService;

	@Autowired
	private SlqaswCalculationService swService;

	@Autowired
	private SlqaCalculationHandler handler;

	@Override
	protected BaseYzRepository<Slqayz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Slqayz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Slqayz, ?> getSwCalculationService() {
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
