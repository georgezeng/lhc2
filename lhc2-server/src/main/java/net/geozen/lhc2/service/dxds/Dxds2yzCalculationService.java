package net.geozen.lhc2.service.dxds;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.dxds.Dxds2yz;
import net.geozen.lhc2.jpa.dxds.Dxds2yzRepository;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Dxds2yzCalculationService extends BasePosYzCalculationService<Dxds2yz> {

	@Autowired
	private Dxds2yzRepository yzRepository;

	@Autowired
	private Dxds2zfCalculationService zfService;

	@Autowired
	private Dxds2CalculationHandler handler;

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Dxds2yz> getRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfCalculationService<Dxds2yz, ?> getZfCalculationService() {
		return zfService;
	}

	@Override
	protected BaseSwCalculationService<Dxds2yz, ?> getSwCalculationService() {
		return null;
	}

	@Override
	public int getEndPos() {
		return 4;
	}

	@Override
	protected void calSmallAndLarge(int index, Dxds2yz yz, Dxds2yz lastYz) throws Exception {
		if (index > 2) {
			List<Dxds2Info> infos = new ArrayList<>();
			infos.add(new Dxds2Info("SmallOdd", lastYz.getSmallOdd()));
			infos.add(new Dxds2Info("SmallEven", lastYz.getSmallEven()));
			infos.add(new Dxds2Info("LargeOdd", lastYz.getLargeOdd()));
			infos.add(new Dxds2Info("LargeEven", lastYz.getLargeEven()));
			Collections.sort(infos, new Comparator<Dxds2Info>() {

				@Override
				public int compare(Dxds2Info o1, Dxds2Info o2) {
					return o1.getYz().compareTo(o2.getYz());
				}

			});
			for (int i = 0; i < 2; i++) {
				Dxds2Info info = infos.get(i);
				Method m = yz.getClass().getDeclaredMethod("get" + info.getField());
				Integer value = (Integer) m.invoke(yz);
				if (value == 0) {
					yz.setRgColor("green");
					break;
				}
			}
			if (yz.getRgColor() == null) {
				yz.setRgColor("red");
			}
			if (lastYz.getRgColor() != null && lastYz.getRgColor().equals(yz.getRgColor())) {
				yz.setRg(lastYz.getRg() + 1);
			} else {
				yz.setRg(1);
			}
		}
	}

}
