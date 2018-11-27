package net.geozen.lhc2.service.slq.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.slq.bs.Slqbssw;
import net.geozen.lhc2.domain.slq.bs.Slqbsyz;
import net.geozen.lhc2.jpa.slq.bs.SlqbsswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqbsswCalculationService extends BaseSwCalculationService<Slqbsyz, Slqbssw> {

	@Autowired
	private SlqbsswRepository swRepository;

	@Autowired
	private SlqbsCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Slqbssw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
