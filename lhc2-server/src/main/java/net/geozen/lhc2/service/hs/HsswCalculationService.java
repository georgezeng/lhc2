package net.geozen.lhc2.service.hs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.hs.Hssw;
import net.geozen.lhc2.domain.hs.Hsyz;
import net.geozen.lhc2.jpa.hs.HsswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class HsswCalculationService extends BaseSwCalculationService<Hsyz, Hssw> {

	@Autowired
	private HsswRepository swRepository;

	@Autowired
	private HsCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Hssw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
