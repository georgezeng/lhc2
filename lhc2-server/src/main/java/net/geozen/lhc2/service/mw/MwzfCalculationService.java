package net.geozen.lhc2.service.mw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.Mwyz;
import net.geozen.lhc2.domain.Mwzf;
import net.geozen.lhc2.jpa.mw.MwzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;

@Service
public class MwzfCalculationService extends BaseZfCalculationService<Mwyz, Mwzf> {

	@Autowired
	private MwzfRepository zfRepository;

	@Override
	protected PagingAndSortingRepository<Mwzf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected Class<Mwzf> getZfClass() {
		return Mwzf.class;
	}

	@Override
	protected int getLength() {
		return 10;
	}

}
