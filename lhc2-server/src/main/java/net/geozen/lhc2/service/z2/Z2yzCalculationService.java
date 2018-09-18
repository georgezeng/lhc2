package net.geozen.lhc2.service.z2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.z2.Z2yz;
import net.geozen.lhc2.jpa.z2.Z2yzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Z2yzCalculationService extends BasePosYzCalculationService<Z2yz> {

	@Autowired
	private Z2yzRepository yzRepository;

	@Autowired
	private Z2zfCalculationService zfService;

	@Autowired
	private Z2swCalculationService swService;

	@Autowired
	private Z2CalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Z2yz, Long> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Z2yz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Z2yz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
