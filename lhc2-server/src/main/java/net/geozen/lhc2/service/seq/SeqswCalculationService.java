package net.geozen.lhc2.service.seq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.seq.Seqsw;
import net.geozen.lhc2.domain.seq.Seqyz;
import net.geozen.lhc2.jpa.seq.SeqswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SeqswCalculationService extends BaseSwCalculationService<Seqyz, Seqsw> {

	@Autowired
	private SeqswRepository swRepository;

	@Autowired
	private SeqCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Seqsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
