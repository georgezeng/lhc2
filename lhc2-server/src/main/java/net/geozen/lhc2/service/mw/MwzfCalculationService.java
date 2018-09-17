package net.geozen.lhc2.service.mw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.mw.Mwyz;
import net.geozen.lhc2.domain.mw.Mwzf;
import net.geozen.lhc2.jpa.mw.MwzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class MwzfCalculationService extends BaseZfCalculationService<Mwyz, Mwzf> {

	@Autowired
	private MwzfRepository zfRepository;

	@Autowired
	private MwCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Mwzf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
