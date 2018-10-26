package net.geozen.lhc2.service.seq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.seq.Seqyz;
import net.geozen.lhc2.domain.seq.Seqzf;
import net.geozen.lhc2.jpa.seq.SeqyzRepository;
import net.geozen.lhc2.jpa.seq.SeqzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SeqzfCalculationService extends BaseZfCalculationService<Seqyz, Seqzf> {
	
	@Autowired
	private SeqyzRepository yzRepository;

	@Autowired
	private SeqzfRepository zfRepository;

	@Autowired
	private SeqCalculationHandler handler;

	@Override
	protected BaseZfRepository<Seqzf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Seqyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 12;
	}

}
