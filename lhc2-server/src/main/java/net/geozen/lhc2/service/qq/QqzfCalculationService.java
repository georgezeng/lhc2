package net.geozen.lhc2.service.qq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.qq.Qqyz;
import net.geozen.lhc2.domain.qq.Qqzf;
import net.geozen.lhc2.jpa.qq.QqzfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class QqzfCalculationService extends BaseZfCalculationService<Qqyz, Qqzf> {

	@Autowired
	private QqzfRepository zfRepository;

	@Autowired
	private QqCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Qqzf, Long> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
