package net.geozen.lhc2.service.hs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.hs.Hsyz;
import net.geozen.lhc2.jpa.hs.HsyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class HsyzCalculationService extends BasePosYzCalculationService<Hsyz> {

	@Autowired
	private HsyzRepository yzRepository;

	@Autowired
	private HszfCalculationService zfService;

	@Autowired
	private HsswCalculationService swService;

	@Autowired
	private HsCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Hsyz, Long> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Hsyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Hsyz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
