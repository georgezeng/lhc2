package net.geozen.lhc2.service.slq.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.slq.b.Slqbsw;
import net.geozen.lhc2.domain.slq.b.Slqbyz;
import net.geozen.lhc2.jpa.slq.b.SlqbswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqbswCalculationService extends BaseSwCalculationService<Slqbyz, Slqbsw> {

	@Autowired
	private SlqbswRepository swRepository;

	@Autowired
	private SlqbCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Slqbsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
