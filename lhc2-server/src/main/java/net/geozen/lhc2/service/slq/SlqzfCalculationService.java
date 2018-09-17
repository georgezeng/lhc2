package net.geozen.lhc2.service.slq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.slq.Slqyz;
import net.geozen.lhc2.domain.slq.Slqzf;
import net.geozen.lhc2.jpa.slq.SlqzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqzfCalculationService extends BaseZfCalculationService<Slqyz, Slqzf> {

	@Autowired
	private SlqzfRepository zfRepository;

	@Autowired
	private SlqCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Slqzf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
