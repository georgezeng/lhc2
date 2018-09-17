package net.geozen.lhc2.service.mw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.Mwsw;
import net.geozen.lhc2.domain.Mwyz;
import net.geozen.lhc2.jpa.mw.MwswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;

@Service
public class MwswCalculationService extends BaseSwCalculationService<Mwyz, Mwsw> {

	@Autowired
	private MwswRepository swRepository;

	@Override
	protected PagingAndSortingRepository<Mwsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected Class<Mwsw> getSwClass() {
		return Mwsw.class;
	}

	@Override
	protected int getLength() {
		return 10;
	}

}
