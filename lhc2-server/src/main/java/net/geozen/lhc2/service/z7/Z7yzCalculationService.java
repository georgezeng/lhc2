package net.geozen.lhc2.service.z7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.z7.Z7yz;
import net.geozen.lhc2.jpa.z7.Z7yzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Z7yzCalculationService extends BasePosYzCalculationService<Z7yz> {

	@Autowired
	private Z7yzRepository yzRepository;

	@Autowired
	private Z7zfCalculationService zfService;

	@Autowired
	private Z7swCalculationService swService;

	@Autowired
	private Z7CalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Z7yz, Long> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Z7yz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Z7yz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
