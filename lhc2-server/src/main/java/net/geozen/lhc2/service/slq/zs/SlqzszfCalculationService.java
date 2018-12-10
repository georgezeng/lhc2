package net.geozen.lhc2.service.slq.zs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.zs.Slqzsyz;
import net.geozen.lhc2.domain.slq.zs.Slqzszf;
import net.geozen.lhc2.jpa.slq.zs.SlqzsyzRepository;
import net.geozen.lhc2.jpa.slq.zs.SlqzszfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqzszfCalculationService extends BaseZfCalculationService<Slqzsyz, Slqzszf> {

	@Autowired
	private SlqzsyzRepository yzRepository;

	@Autowired
	private SlqzszfRepository zfRepository;

	@Autowired
	private SlqzsCalculationHandler handler;

	@Override
	protected BaseZfRepository<Slqzszf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Slqzsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 16;
	}

}
