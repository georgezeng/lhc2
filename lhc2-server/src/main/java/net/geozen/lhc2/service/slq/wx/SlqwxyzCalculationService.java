package net.geozen.lhc2.service.slq.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.wx.Slqwxyz;
import net.geozen.lhc2.jpa.slq.wx.SlqwxyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqwxyzCalculationService extends BasePosYzCalculationService<Slqwxyz> {

	@Autowired
	private SlqwxyzRepository yzRepository;

	@Autowired
	private SlqwxzfCalculationService zfService;

	@Autowired
	private SlqwxswCalculationService swService;

	@Autowired
	private SlqwxCalculationHandler handler;

	@Override
	protected BaseYzRepository<Slqwxyz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Slqwxyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Slqwxyz, ?> getSwCalculationService() {
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
