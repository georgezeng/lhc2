package net.geozen.lhc2.service.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.ds.Dsyz;
import net.geozen.lhc2.domain.ds.Dszf;
import net.geozen.lhc2.jpa.ds.DszfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class DszfCalculationService extends BaseZfCalculationService<Dsyz, Dszf> {

	@Autowired
	private DszfRepository zfRepository;

	@Autowired
	private DsCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Dszf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
