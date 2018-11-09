package net.geozen.lhc2.service.sx;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.impl.CommonDAO;
import net.geozen.lhc2.domain.sx.Sxyz;
import net.geozen.lhc2.domain.sx.Sxzf;
import net.geozen.lhc2.dto.MaxInfo;
import net.geozen.lhc2.enums.SX;
import net.geozen.lhc2.jpa.sx.SxyzRepository;
import net.geozen.lhc2.jpa.sx.SxzfRepository;
import net.geozen.lhc2.utils.SxUtil;

@Service
public class SxzfCalculationService {

	@Autowired
	private SxzfRepository zfRepository;

	@Autowired
	private SxyzRepository yzRepository;

	@Autowired
	private CommonDAO commonDAO;

	public void process(List<Sxyz> yzList) throws Exception {
		int len = SX.seq().length;
		Sxzf lastZf = new Sxzf();
		List<Sxzf> list = new ArrayList<>();
		for (int i = 1; i < yzList.size(); i++) {
			Sxyz lastYz = yzList.get(i - 1);
			Sxyz yz = yzList.get(i);
			int delta = yz.getSx().getPos() - lastYz.getSx().getPos();
			if (delta < 0) {
				delta += len;
			}
			Sxzf zf = new Sxzf();
			zf.setPhase(yz.getPhase());
			zf.setNum(yz.getNum());
			zf.setSx(yz.getSx());
			for (int j = 0; j < len; j++) {
				Method setMethod = zf.getClass().getDeclaredMethod("setZf" + j, int.class);
				if (j != delta) {
					Method getMethod = zf.getClass().getDeclaredMethod("getZf" + j);
					int value = (int) getMethod.invoke(lastZf);
					setMethod.invoke(zf, value + 1);
				} else {
					setMethod.invoke(zf, 0);
				}
			}
			lastZf = zf;
			list.add(zf);
		}
		zfRepository.deleteAll();
		zfRepository.saveAll(list);
	}

	public int getTotalAvgForLastPhases(int offset, int size) throws Exception {
		List<Sxzf> list = commonDAO.findAllByOffsetAndSize(Sxzf.class, offset, size);
		int total = 0;
		for (Sxzf zf : list) {
			for (int i = 0; i < 12; i++) {
				Method m = Sxzf.class.getDeclaredMethod("getZf" + i);
				Integer value = (Integer) m.invoke(zf);
				total += value;
			}
		}
		return total / size;
	}

	public MaxInfo getMax(int phase) throws Exception {
		Sxzf zf = zfRepository.findByPhase(phase);
		if (zf == null) {
			return new MaxInfo(phase, 0, 0);
		}
		int max = 0;
		int pos = 0;
		for (int i = 0; i < 12; i++) {
			Method m = Sxzf.class.getDeclaredMethod("getZf" + i);
			Integer value = (Integer) m.invoke(zf);
			if (value > max) {
				max = value;
				pos = i;
			}
		}
		return new MaxInfo(phase, max, pos);
	}

	public List<Integer> getNumbers(MaxInfo info) throws Exception {
		int endPos = 12;
		Sxyz yz = yzRepository.findByPhase(info.getPhase());
		int pos = yz.getSx().getPos() + info.getPos();
		if (pos >= endPos) {
			pos = pos - endPos;
		}
		SX bmnSx = SxUtil.getSxByYear(new Date());
		return SxUtil.getSxNums(bmnSx, SX.posOf(pos + 1));
	}

}
