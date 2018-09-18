package net.geozen.lhc2.service.pd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.pd.Pdyz;
import net.geozen.lhc2.domain.pd.Pdzf;
import net.geozen.lhc2.jpa.pd.PdzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class PdzfCalculationService extends BaseZfCalculationService<Pdyz, Pdzf> {

	@Autowired
	private PdzfRepository zfRepository;

	@Autowired
	private PdCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Pdzf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
