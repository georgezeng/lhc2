package net.geozen.lhc2.service.zs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.zs.Zssw;
import net.geozen.lhc2.domain.zs.Zsyz;
import net.geozen.lhc2.jpa.zs.ZsswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class ZsswCalculationService extends BaseSwCalculationService<Zsyz, Zssw> {

	@Autowired
	private ZsswRepository swRepository;

	@Autowired
	private ZsCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Zssw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
