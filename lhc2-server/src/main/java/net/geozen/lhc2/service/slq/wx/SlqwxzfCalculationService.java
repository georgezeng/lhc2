package net.geozen.lhc2.service.slq.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.wx.Slqwxyz;
import net.geozen.lhc2.domain.slq.wx.Slqwxzf;
import net.geozen.lhc2.jpa.slq.wx.SlqwxyzRepository;
import net.geozen.lhc2.jpa.slq.wx.SlqwxzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqwxzfCalculationService extends BaseZfCalculationService<Slqwxyz, Slqwxzf> {

	@Autowired
	private SlqwxyzRepository yzRepository;

	@Autowired
	private SlqwxzfRepository zfRepository;

	@Autowired
	private SlqwxCalculationHandler handler;

	@Override
	protected BaseZfRepository<Slqwxzf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Slqwxyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 16;
	}

}
