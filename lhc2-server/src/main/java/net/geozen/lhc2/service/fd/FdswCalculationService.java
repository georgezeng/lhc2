package net.geozen.lhc2.service.fd;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import net.geozen.lhc2.domain.fd.Fdsw;
import net.geozen.lhc2.domain.fd.Fdyz;
import net.geozen.lhc2.jpa.fd.FdswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;
import net.geozen.lhc2.service.base.PosYzInfo;

@Service
public class FdswCalculationService extends BaseSwCalculationService<Fdyz, Fdsw> {

	@Autowired
	private FdswRepository swRepository;

	@Autowired
	private FdCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Fdsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected void dealInfoList(Fdsw sw, Fdsw lastSw, List<PosYzInfo> infoList, int pos) throws Exception {
		List<Integer> nums = new ArrayList<>();
		int count = 1;
		for (int i = 0; i < infoList.size(); i++) {
			int num = infoList.get(i).getPos() + 1;
			if (i > 0 && i % 4 == 0) {
				Method setMethod = sw.getClass().getDeclaredMethod("setSw" + count++ + "Arr", String.class);
				setMethod.invoke(sw, StringUtils.collectionToCommaDelimitedString(nums));
				if (i < 48) {
					nums = new ArrayList<>();
				}
			}
			nums.add(num);

			int index = i / 4;
			if (i > 0 && i % 4 == 0) {
				Method setMethod = sw.getClass().getDeclaredMethod("setSw" + index, int.class);
				if (pos / 4 != index) {
					Method getMethod = sw.getClass().getDeclaredMethod("getSw" + index);
					int value = (int) getMethod.invoke(lastSw);
					setMethod.invoke(sw, value + 1);
				} else {
					setMethod.invoke(sw, 0);
				}
			}
		}
	}
}
