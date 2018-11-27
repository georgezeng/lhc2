package net.geozen.lhc2.service.slq.d;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.slq.d.Slqdsw;
import net.geozen.lhc2.domain.slq.d.Slqdyz;
import net.geozen.lhc2.jpa.slq.d.SlqdswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqdswCalculationService extends BaseSwCalculationService<Slqdyz, Slqdsw> {

	@Autowired
	private SlqdswRepository swRepository;

	@Autowired
	private SlqdCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Slqdsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
