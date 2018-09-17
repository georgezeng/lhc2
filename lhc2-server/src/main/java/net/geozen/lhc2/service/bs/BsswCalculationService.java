package net.geozen.lhc2.service.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.bs.Bssw;
import net.geozen.lhc2.domain.bs.Bsyz;
import net.geozen.lhc2.jpa.bs.BsswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class BsswCalculationService extends BaseSwCalculationService<Bsyz, Bssw> {

	@Autowired
	private BsswRepository swRepository;

	@Autowired
	private BsCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Bssw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
