package net.geozen.lhc2.service.pd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.pd.Pdsw;
import net.geozen.lhc2.domain.pd.Pdyz;
import net.geozen.lhc2.jpa.pd.PdswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class PdswCalculationService extends BaseSwCalculationService<Pdyz, Pdsw> {

	@Autowired
	private PdswRepository swRepository;

	@Autowired
	private PdCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Pdsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
