package net.geozen.lhc2.service.fd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.fd.Fdyz;
import net.geozen.lhc2.jpa.fd.FdyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class FdyzCalculationService extends BasePosYzCalculationService<Fdyz> {

	@Autowired
	private FdyzRepository yzRepository;

	@Autowired
	private FdswCalculationService swService;

	@Autowired
	private FdCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Fdyz, Long> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Fdyz, ?> getZfCalculationService() {
		return null;
	}

	@Override
	protected BaseSwCalculationService<Fdyz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
