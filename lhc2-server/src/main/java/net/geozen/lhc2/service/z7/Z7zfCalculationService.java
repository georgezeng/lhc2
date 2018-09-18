package net.geozen.lhc2.service.z7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.z7.Z7yz;
import net.geozen.lhc2.domain.z7.Z7zf;
import net.geozen.lhc2.jpa.z7.Z7zfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Z7zfCalculationService extends BaseZfCalculationService<Z7yz, Z7zf> {

	@Autowired
	private Z7zfRepository zfRepository;

	@Autowired
	private Z7CalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Z7zf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
