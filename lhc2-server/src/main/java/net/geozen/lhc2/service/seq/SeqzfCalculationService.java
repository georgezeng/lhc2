package net.geozen.lhc2.service.seq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.seq.Seqyz;
import net.geozen.lhc2.domain.seq.Seqzf;
import net.geozen.lhc2.jpa.seq.SeqzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SeqzfCalculationService extends BaseZfCalculationService<Seqyz, Seqzf> {

	@Autowired
	private SeqzfRepository zfRepository;

	@Autowired
	private SeqCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Seqzf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
