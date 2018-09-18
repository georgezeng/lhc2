package net.geozen.lhc2.service.z13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.z13.Z13sw;
import net.geozen.lhc2.domain.z13.Z13yz;
import net.geozen.lhc2.jpa.z13.Z13swRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Z13swCalculationService extends BaseSwCalculationService<Z13yz, Z13sw> {

	@Autowired
	private Z13swRepository swRepository;

	@Autowired
	private Z13CalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Z13sw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
