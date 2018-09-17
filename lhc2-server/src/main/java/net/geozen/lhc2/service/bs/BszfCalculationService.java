package net.geozen.lhc2.service.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.bs.Bsyz;
import net.geozen.lhc2.domain.bs.Bszf;
import net.geozen.lhc2.jpa.bs.BszfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class BszfCalculationService extends BaseZfCalculationService<Bsyz, Bszf> {

	@Autowired
	private BszfRepository zfRepository;

	@Autowired
	private BsCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Bszf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
