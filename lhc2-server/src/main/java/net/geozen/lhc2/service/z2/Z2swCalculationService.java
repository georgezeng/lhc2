package net.geozen.lhc2.service.z2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.z2.Z2sw;
import net.geozen.lhc2.domain.z2.Z2yz;
import net.geozen.lhc2.jpa.z2.Z2swRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Z2swCalculationService extends BaseSwCalculationService<Z2yz, Z2sw> {

	@Autowired
	private Z2swRepository swRepository;

	@Autowired
	private Z2CalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Z2sw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
