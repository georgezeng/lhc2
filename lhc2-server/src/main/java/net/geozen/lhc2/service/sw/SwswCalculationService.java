package net.geozen.lhc2.service.sw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.Swsw;
import net.geozen.lhc2.domain.Swyz;
import net.geozen.lhc2.jpa.sw.SwswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;

@Service
public class SwswCalculationService extends BaseSwCalculationService<Swyz, Swsw> {

	@Autowired
	private SwswRepository swRepository;

	@Override
	protected PagingAndSortingRepository<Swsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected Class<Swsw> getSwClass() {
		return Swsw.class;
	}

	@Override
	protected int getLength() {
		return 5;
	}

}
