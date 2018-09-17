package net.geozen.lhc2.service.sw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.sw.Swsw;
import net.geozen.lhc2.domain.sw.Swyz;
import net.geozen.lhc2.jpa.sw.SwswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SwswCalculationService extends BaseSwCalculationService<Swyz, Swsw> {

	@Autowired
	private SwswRepository swRepository;

	@Autowired
	private SwCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Swsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
