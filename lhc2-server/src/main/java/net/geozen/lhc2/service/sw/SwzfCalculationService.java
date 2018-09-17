package net.geozen.lhc2.service.sw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.Swyz;
import net.geozen.lhc2.domain.Swzf;
import net.geozen.lhc2.jpa.sw.SwzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;

@Service
public class SwzfCalculationService extends BaseZfCalculationService<Swyz, Swzf> {

	@Autowired
	private SwzfRepository zfRepository;

	@Override
	protected PagingAndSortingRepository<Swzf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected Class<Swzf> getZfClass() {
		return Swzf.class;
	}

	@Override
	protected int getLength() {
		return 5;
	}

}
