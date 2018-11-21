package net.geozen.lhc2.service.dxds;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.dxds.Dxds2yz;
import net.geozen.lhc2.domain.dxds.Dxds2zf;
import net.geozen.lhc2.jpa.dxds.Dxds2yzRepository;
import net.geozen.lhc2.jpa.dxds.Dxds2zfRepository;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class Dxds2zfCalculationService extends BaseZfCalculationService<Dxds2yz, Dxds2zf> {

	@Autowired
	private Dxds2yzRepository yzRepository;

	@Autowired
	private Dxds2zfRepository zfRepository;

	@Autowired
	private Dxds2CalculationHandler handler;

	@Override
	protected BaseZfRepository<Dxds2zf> getRepository() {
		return zfRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

	@Override
	protected BaseYzRepository<Dxds2yz> getYzRepository() {
		return yzRepository;
	}

	@Override
	public int getEndPos() {
		return 10;
	}

	@Override
	protected void calSmallAndLarge(int index, Dxds2zf zf, Dxds2zf lastZf) throws Exception {
		if (index > 2) {
			List<Dxds2Info> infos = new ArrayList<>();
			infos.add(new Dxds2Info("Zf0", lastZf.getZf0()));
			infos.add(new Dxds2Info("Zf1", lastZf.getZf1()));
			infos.add(new Dxds2Info("Zf2", lastZf.getZf2()));
			infos.add(new Dxds2Info("Zf3", lastZf.getZf3()));
			Collections.sort(infos, new Comparator<Dxds2Info>() {

				@Override
				public int compare(Dxds2Info o1, Dxds2Info o2) {
					return o1.getYz().compareTo(o2.getYz());
				}

			});
			for (int i = 0; i < 2; i++) {
				Dxds2Info info = infos.get(i);
				Method m = zf.getClass().getDeclaredMethod("get" + info.getField());
				Integer value = (Integer) m.invoke(zf);
				if (value == 0) {
					zf.setRgColor("green");
					break;
				}
			}
			if (zf.getRgColor() == null) {
				zf.setRgColor("red");
			}
			if (lastZf.getRgColor() != null && lastZf.getRgColor().equals(zf.getRgColor())) {
				zf.setRg(lastZf.getRg() + 1);
			} else {
				zf.setRg(1);
			}
		}
	}
}
