package net.geozen.lhc2.service.qq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.qq.Qqyz;
import net.geozen.lhc2.domain.qq.Qqzf;
import net.geozen.lhc2.jpa.qq.QqyzRepository;
import net.geozen.lhc2.jpa.qq.QqzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class QqzfCalculationService extends BaseZfCalculationService<Qqyz, Qqzf> {

	@Autowired
	private QqyzRepository yzRepository;

	@Autowired
	private QqzfRepository zfRepository;

	@Autowired
	private QqCalculationHandler handler;

	@Override
	protected BaseZfRepository<Qqzf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Qqyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 7;
	}

}
