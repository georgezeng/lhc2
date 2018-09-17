package net.geozen.lhc2.service.sw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.Swyz;
import net.geozen.lhc2.jpa.sw.SwyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SwyzCalculationService extends BasePosYzCalculationService<Swyz> {

	@Autowired
	private SwyzRepository yzRepository;

	@Autowired
	private SwzfCalculationService zfService;

	@Autowired
	private SwswCalculationService swService;

	@Override
	protected PagingAndSortingRepository<Swyz, Long> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Swyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Swyz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return new CalculationHandler() {

			@Override
			public int getPos(int num) {
				int pos = 4;
				if (num < 10) {
					pos = 0;
				} else if (num < 20) {
					pos = 1;
				} else if (num < 30) {
					pos = 2;
				} else if (num < 40) {
					pos = 3;
				}
				return pos;
			}

			@Override
			public int getLength() {
				return 5;
			}
		};
	}

	@Override
	protected Class<Swyz> getYzClass() {
		return Swyz.class;
	}

}
