package net.geozen.lhc2.service.slq.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.slq.a.Slqasw;
import net.geozen.lhc2.domain.slq.a.Slqayz;
import net.geozen.lhc2.jpa.slq.a.SlqaswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqaswCalculationService extends BaseSwCalculationService<Slqayz, Slqasw> {

	@Autowired
	private SlqaswRepository swRepository;

	@Autowired
	private SlqaCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Slqasw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
