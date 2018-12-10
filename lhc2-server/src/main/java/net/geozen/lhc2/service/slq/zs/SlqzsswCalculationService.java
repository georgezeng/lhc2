package net.geozen.lhc2.service.slq.zs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.slq.zs.Slqzssw;
import net.geozen.lhc2.domain.slq.zs.Slqzsyz;
import net.geozen.lhc2.jpa.slq.zs.SlqzsswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqzsswCalculationService extends BaseSwCalculationService<Slqzsyz, Slqzssw> {

	@Autowired
	private SlqzsswRepository swRepository;

	@Autowired
	private SlqzsCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Slqzssw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
