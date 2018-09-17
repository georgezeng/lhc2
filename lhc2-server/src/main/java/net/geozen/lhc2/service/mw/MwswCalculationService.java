package net.geozen.lhc2.service.mw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.mw.Mwsw;
import net.geozen.lhc2.domain.mw.Mwyz;
import net.geozen.lhc2.jpa.mw.MwswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class MwswCalculationService extends BaseSwCalculationService<Mwyz, Mwsw> {

	@Autowired
	private MwswRepository swRepository;
	
	@Autowired
	private MwCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Mwsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
