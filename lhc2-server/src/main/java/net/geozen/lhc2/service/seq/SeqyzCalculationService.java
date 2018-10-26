package net.geozen.lhc2.service.seq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.seq.Seqyz;
import net.geozen.lhc2.jpa.seq.SeqyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SeqyzCalculationService extends BasePosYzCalculationService<Seqyz> {

	@Autowired
	private SeqyzRepository yzRepository;

	@Autowired
	private SeqzfCalculationService zfService;

	@Autowired
	private SeqswCalculationService swService;

	@Autowired
	private SeqCalculationHandler handler;

	@Override
	protected BaseYzRepository<Seqyz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Seqyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Seqyz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	public int getEndPos() {
		return 12;
	}

}
