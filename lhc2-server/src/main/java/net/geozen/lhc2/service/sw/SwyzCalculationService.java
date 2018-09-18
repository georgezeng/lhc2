package net.geozen.lhc2.service.sw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.sw.Swyz;
import net.geozen.lhc2.jpa.sw.SwyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SwyzCalculationService extends BasePosYzCalculationService<Swyz> {

	@Autowired
	private SwyzRepository yzRepository;

	@Autowired
	private SwzfCalculationService zfService;

	@Autowired
	private SwswCalculationService swService;

	@Autowired
	private SwCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Swyz, Long> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Swyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Swyz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
