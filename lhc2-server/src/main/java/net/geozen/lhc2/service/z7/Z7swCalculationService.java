package net.geozen.lhc2.service.z7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.z7.Z7sw;
import net.geozen.lhc2.domain.z7.Z7yz;
import net.geozen.lhc2.jpa.z7.Z7swRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Z7swCalculationService extends BaseSwCalculationService<Z7yz, Z7sw> {

	@Autowired
	private Z7swRepository swRepository;

	@Autowired
	private Z7CalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Z7sw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
