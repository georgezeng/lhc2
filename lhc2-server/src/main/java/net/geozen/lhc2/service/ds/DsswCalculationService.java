package net.geozen.lhc2.service.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.ds.Dssw;
import net.geozen.lhc2.domain.ds.Dsyz;
import net.geozen.lhc2.jpa.ds.DsswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class DsswCalculationService extends BaseSwCalculationService<Dsyz, Dssw> {

	@Autowired
	private DsswRepository swRepository;

	@Autowired
	private DsCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Dssw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
