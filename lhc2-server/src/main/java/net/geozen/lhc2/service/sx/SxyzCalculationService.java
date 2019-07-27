package net.geozen.lhc2.service.sx;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.geozen.lhc2.def.jpa.impl.CommonDAO;
import net.geozen.lhc2.domain.Tm;
import net.geozen.lhc2.domain.sx.Sxyz;
import net.geozen.lhc2.dto.MaxInfo;
import net.geozen.lhc2.enums.SX;
import net.geozen.lhc2.jpa.TmRepository;
import net.geozen.lhc2.jpa.sx.SxyzRepository;
import net.geozen.lhc2.nums.SxNums;
import net.geozen.lhc2.utils.SystemConstants;

@Service
public class SxyzCalculationService {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private TmRepository tmRepository;

	@Autowired
	private SxyzRepository yzRepository;

	@Autowired
	private SxzfCalculationService zfService;

	@Autowired
	private SxswCalculationService swService;

	@Autowired
	private CommonDAO commonDAO;

	@Transactional
	@Async
	public Future<Exception> process() {
		Exception t = null;
		try {
			Pageable pageable = PageRequest.of(0, SystemConstants.CALCULATION_SIZE, Direction.DESC, "phase");
			List<Tm> datas = tmRepository.findAll(pageable).getContent();
			Sxyz lastYz = new Sxyz();
			List<Sxyz> yzList = new ArrayList<>();
			for (int i = datas.size() - 1; i > -1; i--) {
				Tm data = datas.get(i);
				Sxyz yz = new Sxyz();
				yz.setPhase(data.getPhase());
				yz.setNum(data.getNum());
				yz.setSx(data.getSx());
				for (SX sx : SX.seq()) {
					Method setMethod = yz.getClass().getDeclaredMethod("set" + sx.getColumn(), int.class);
					if (sx.equals(data.getSx())) {
						setMethod.invoke(yz, 0);
					} else {
						Method getMethod = yz.getClass().getDeclaredMethod("get" + sx.getColumn());
						int value = (int) getMethod.invoke(lastYz);
						setMethod.invoke(yz, value + 1);
					}
				}
				lastYz = yz;
				yzList.add(yz);
			}
			yzRepository.deleteAll();
			yzRepository.saveAll(yzList);
			zfService.process(yzList);
			swService.process(yzList);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<>(t);
	}

	public int getTotalAvgForLastPhases(int offset, int size) throws Exception {
		List<Sxyz> list = commonDAO.findAllByOffsetAndSize(Sxyz.class, offset, size);
		int total = 0;
		for (Sxyz yz : list) {
			for (SX sx : SX.seq()) {
				Method m = Sxyz.class.getDeclaredMethod("get" + sx.getColumn());
				Integer value = (Integer) m.invoke(yz);
				total += value;
			}
		}
		return total / size;
	}

	public MaxInfo getMax(int phase) throws Exception {
		Sxyz yz = yzRepository.findByPhase(phase);
		int max = 0;
		SX currentSX = null;
		for (SX sx : SX.seq()) {
			Method m = Sxyz.class.getDeclaredMethod("get" + sx.getColumn());
			Integer value = (Integer) m.invoke(yz);
			if (value > max) {
				max = value;
				currentSX = sx;
			}
		}
		return new MaxInfo(phase, max, currentSX);
	}

	public List<Integer> getNumbers(MaxInfo info) throws Exception {
//		SX bmnSx = SxUtil.getSxByYear(new Date());
//		return SxUtil.getSxNums(bmnSx, info.getSx());
		return SxNums.LISTS.get(info.getSx().getNumsPos());
	}

}
