package net.geozen.lhc2.service.zs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.zs.Zsyz;
import net.geozen.lhc2.jpa.zs.ZsyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class ZsyzCalculationService extends BasePosYzCalculationService<Zsyz> {

	@Autowired
	private ZsyzRepository yzRepository;

	@Autowired
	private ZszfCalculationService zfService;

	@Autowired
	private ZsswCalculationService swService;

	@Autowired
	private ZsCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Zsyz, Long> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Zsyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Zsyz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
