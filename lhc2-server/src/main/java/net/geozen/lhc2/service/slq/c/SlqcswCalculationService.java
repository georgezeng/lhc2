package net.geozen.lhc2.service.slq.c;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.slq.c.Slqcsw;
import net.geozen.lhc2.domain.slq.c.Slqcyz;
import net.geozen.lhc2.jpa.slq.c.SlqcswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqcswCalculationService extends BaseSwCalculationService<Slqcyz, Slqcsw> {

	@Autowired
	private SlqcswRepository swRepository;

	@Autowired
	private SlqcCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Slqcsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
