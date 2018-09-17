package net.geozen.lhc2.service.qq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.qq.Qqsw;
import net.geozen.lhc2.domain.qq.Qqyz;
import net.geozen.lhc2.jpa.qq.QqswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class QqswCalculationService extends BaseSwCalculationService<Qqyz, Qqsw> {

	@Autowired
	private QqswRepository swRepository;

	@Autowired
	private QqCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Qqsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
