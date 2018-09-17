package net.geozen.lhc2.service.slq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.slq.Slqsw;
import net.geozen.lhc2.domain.slq.Slqyz;
import net.geozen.lhc2.jpa.slq.SlqswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqswCalculationService extends BaseSwCalculationService<Slqyz, Slqsw> {

	@Autowired
	private SlqswRepository swRepository;

	@Autowired
	private SlqCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Slqsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
