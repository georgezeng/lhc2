package net.geozen.lhc2.service.slq.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.a.Slqayz;
import net.geozen.lhc2.domain.slq.a.Slqazf;
import net.geozen.lhc2.jpa.slq.a.SlqayzRepository;
import net.geozen.lhc2.jpa.slq.a.SlqazfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqazfCalculationService extends BaseZfCalculationService<Slqayz, Slqazf> {

	@Autowired
	private SlqayzRepository yzRepository;

	@Autowired
	private SlqazfRepository zfRepository;

	@Autowired
	private SlqaCalculationHandler handler;

	@Override
	protected BaseZfRepository<Slqazf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Slqayz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 16;
	}

}
