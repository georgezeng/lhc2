package net.geozen.lhc2.service.zs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.zs.Zsyz;
import net.geozen.lhc2.domain.zs.Zszf;
import net.geozen.lhc2.jpa.zs.ZszfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class ZszfCalculationService extends BaseZfCalculationService<Zsyz, Zszf> {

	@Autowired
	private ZszfRepository zfRepository;

	@Autowired
	private ZsCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Zszf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
