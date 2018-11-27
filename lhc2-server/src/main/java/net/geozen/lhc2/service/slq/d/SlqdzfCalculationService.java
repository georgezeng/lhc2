package net.geozen.lhc2.service.slq.d;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.d.Slqdyz;
import net.geozen.lhc2.domain.slq.d.Slqdzf;
import net.geozen.lhc2.jpa.slq.d.SlqdyzRepository;
import net.geozen.lhc2.jpa.slq.d.SlqdzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqdzfCalculationService extends BaseZfCalculationService<Slqdyz, Slqdzf> {

	@Autowired
	private SlqdyzRepository yzRepository;

	@Autowired
	private SlqdzfRepository zfRepository;

	@Autowired
	private SlqdCalculationHandler handler;

	@Override
	protected BaseZfRepository<Slqdzf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Slqdyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 16;
	}

}
