package net.geozen.lhc2.service.hs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.hs.Hsyz;
import net.geozen.lhc2.domain.hs.Hszf;
import net.geozen.lhc2.jpa.hs.HszfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class HszfCalculationService extends BaseZfCalculationService<Hsyz, Hszf> {

	@Autowired
	private HszfRepository zfRepository;

	@Autowired
	private HsCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Hszf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
