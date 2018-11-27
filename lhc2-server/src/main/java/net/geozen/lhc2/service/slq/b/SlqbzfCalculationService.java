package net.geozen.lhc2.service.slq.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.b.Slqbyz;
import net.geozen.lhc2.domain.slq.b.Slqbzf;
import net.geozen.lhc2.jpa.slq.b.SlqbyzRepository;
import net.geozen.lhc2.jpa.slq.b.SlqbzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqbzfCalculationService extends BaseZfCalculationService<Slqbyz, Slqbzf> {

	@Autowired
	private SlqbyzRepository yzRepository;

	@Autowired
	private SlqbzfRepository zfRepository;

	@Autowired
	private SlqbCalculationHandler handler;

	@Override
	protected BaseZfRepository<Slqbzf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Slqbyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 16;
	}

}
