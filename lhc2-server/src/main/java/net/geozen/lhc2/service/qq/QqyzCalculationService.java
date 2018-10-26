package net.geozen.lhc2.service.qq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.qq.Qqyz;
import net.geozen.lhc2.jpa.qq.QqyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class QqyzCalculationService extends BasePosYzCalculationService<Qqyz> {

	@Autowired
	private QqyzRepository yzRepository;

	@Autowired
	private QqzfCalculationService zfService;

	@Autowired
	private QqswCalculationService swService;

	@Autowired
	private QqCalculationHandler handler;

	@Override
	protected BaseYzRepository<Qqyz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Qqyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Qqyz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	public int getEndPos() {
		return 7;
	}

}
