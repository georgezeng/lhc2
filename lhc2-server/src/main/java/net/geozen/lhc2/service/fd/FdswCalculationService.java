package net.geozen.lhc2.service.fd;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import net.geozen.lhc2.def.jpa.impl.CommonDAO;
import net.geozen.lhc2.domain.fd.Fdsw;
import net.geozen.lhc2.domain.fd.Fdyz;
import net.geozen.lhc2.dto.MaxInfo;
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

	@Autowired
	private CommonDAO commonDAO;

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
			int j = i + 1;
			int num = infoList.get(i).getPos() + 1;
			nums.add(num);
			if (j < 48 && j % 4 == 0 || j == 49) {
				Method setMethod = sw.getClass().getDeclaredMethod("setSw" + count++ + "Arr", String.class);
				setMethod.invoke(sw, StringUtils.collectionToCommaDelimitedString(nums));
				nums = new ArrayList<>();
			}

			int index = i / 4;
			if (index == 12) {
				index = 11;
			}
			if (j < 48 && j % 4 == 0 || j == 49) {
				Method setMethod = sw.getClass().getDeclaredMethod("setSw" + (index + 1), int.class);
				if ((pos / 4) != index) {
					Method getMethod = sw.getClass().getDeclaredMethod("getSw" + (index + 1));
					int value = (int) getMethod.invoke(lastSw);
					setMethod.invoke(sw, value + 1);
				} else {
					setMethod.invoke(sw, 0);
				}
			}
		}
	}

	public int getTotalAvgForLastPhases(int offset, int size) throws Exception {
		List<Fdsw> list = commonDAO.findAllByOffsetAndSize(Fdsw.class, offset, size);
		int total = 0;
		for (Fdsw sw : list) {
			for (int i = 1; i < 13; i++) {
				Method m = Fdsw.class.getDeclaredMethod("getSw" + i);
				Integer value = (Integer) m.invoke(sw);
				total += value;
			}
		}
		return total / size;
	}

	public MaxInfo getMax(int phase) throws Exception {
		Fdsw sw = swRepository.findByPhase(phase);
		if (sw == null) {
			return new MaxInfo(phase, 0, (String[]) null);
		}
		int max = 0;
		String arr = null;
		for (int i = 1; i < 13; i++) {
			Method m = Fdsw.class.getDeclaredMethod("getSw" + i);
			Integer value = (Integer) m.invoke(sw);
			if (value > max) {
				max = value;
				m = Fdsw.class.getDeclaredMethod("getSw" + i + "Arr");
				arr = (String) m.invoke(sw);
			}
		}
		return new MaxInfo(phase, max, arr.split(",\\s*"));
	}

}
