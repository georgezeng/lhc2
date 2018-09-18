package net.geozen.lhc2.service.z13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.z13.Z13yz;
import net.geozen.lhc2.domain.z13.Z13zf;
import net.geozen.lhc2.jpa.z13.Z13zfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Z13zfCalculationService extends BaseZfCalculationService<Z13yz, Z13zf> {

	@Autowired
	private Z13zfRepository zfRepository;

	@Autowired
	private Z13CalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Z13zf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
