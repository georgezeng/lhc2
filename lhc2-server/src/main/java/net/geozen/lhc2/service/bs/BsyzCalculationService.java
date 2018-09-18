package net.geozen.lhc2.service.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.bs.Bsyz;
import net.geozen.lhc2.jpa.bs.BsyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class BsyzCalculationService extends BasePosYzCalculationService<Bsyz> {

	@Autowired
	private BsyzRepository yzRepository;

	@Autowired
	private BszfCalculationService zfService;

	@Autowired
	private BsswCalculationService swService;

	@Autowired
	private BsCalculationHandler handler;

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected PagingAndSortingRepository<Bsyz, Long> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Bsyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Bsyz, ?> getSwCalculationService() {
		return swService;
	}

}
