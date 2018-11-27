package net.geozen.lhc2.service.slq.d;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.d.Slqdyz;
import net.geozen.lhc2.jpa.slq.d.SlqdyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqdyzCalculationService extends BasePosYzCalculationService<Slqdyz> {

	@Autowired
	private SlqdyzRepository yzRepository;

	@Autowired
	private SlqdzfCalculationService zfService;

	@Autowired
	private SlqdswCalculationService swService;

	@Autowired
	private SlqdCalculationHandler handler;

	@Override
	protected BaseYzRepository<Slqdyz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Slqdyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Slqdyz, ?> getSwCalculationService() {
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
