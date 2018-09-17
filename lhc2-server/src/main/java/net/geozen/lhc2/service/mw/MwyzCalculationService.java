package net.geozen.lhc2.service.mw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.Mwyz;
import net.geozen.lhc2.jpa.mw.MwyzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class MwyzCalculationService extends BasePosYzCalculationService<Mwyz> {

	@Autowired
	private MwyzRepository yzRepository;

	@Autowired
	private MwzfCalculationService zfService;

	@Autowired
	private MwswCalculationService swService;

	@Override
	protected PagingAndSortingRepository<Mwyz, Long> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Mwyz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Mwyz, ?> getSwCalculationService() {
		return swService;
	}

	@Override
	protected CalculationHandler getHandler() {
		return new CalculationHandler() {

			@Override
			public int getPos(int num) {
				int pos = 0;
				switch (num) {
				case 1:
				case 11:
				case 21:
				case 31:
				case 41:
					pos = 1;
					break;
				case 2:
				case 12:
				case 22:
				case 32:
				case 42:
					pos = 2;
					break;
				case 3:
				case 13:
				case 23:
				case 33:
				case 43:
					pos = 3;
					break;
				case 4:
				case 14:
				case 24:
				case 34:
				case 44:
					pos = 4;
					break;
				case 5:
				case 15:
				case 25:
				case 35:
				case 45:
					pos = 5;
					break;
				case 6:
				case 16:
				case 26:
				case 36:
				case 46:
					pos = 6;
					break;
				case 7:
				case 17:
				case 27:
				case 37:
				case 47:
					pos = 7;
					break;
				case 8:
				case 18:
				case 28:
				case 38:
				case 48:
					pos = 8;
					break;
				case 9:
				case 19:
				case 29:
				case 39:
				case 49:
					pos = 9;
					break;
				default:
					pos = 0;
				}
				return pos;
			}

			@Override
			public int getLength() {
				return 10;
			}
		};
	}

	@Override
	protected Class<Mwyz> getYzClass() {
		return Mwyz.class;
	}

}
