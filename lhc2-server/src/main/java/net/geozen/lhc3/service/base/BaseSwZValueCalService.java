package net.geozen.lhc3.service.base;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.dto.ZInfo;
import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.domain.base.PosBaseEntity;
import net.geozen.lhc3.domain.fd.Lhc3FdSw;

@Service
@Slf4j
public abstract class BaseSwZValueCalService<S extends PosBaseEntity> {

	protected abstract BaseRepository<S> getSwRepository();

	private int length = 12;

	@Async
	public Future<ZInfo> process(Lhc3Tm tm, int order) {
		ZInfo info = null;
		try {
			Optional<S> swOp = getSwRepository().findByPhase(tm.getPhase());
			if (swOp.isPresent()) {
				S sw = swOp.get();
				BigDecimal zForP1 = new BigDecimal(sw.getTotalColsYz());
				BigDecimal z = new BigDecimal(sw.getRColsYz()).divide(new BigDecimal(sw.getMaxColYz()), 2, RoundingMode.HALF_UP);
				info = new ZInfo();
				info.setOrder(order);
				info.setZForP1(zForP1);
				info.setZ(z);

				int pos = 1;
				int max = 0;
				for (int i = 1; i <= length; i++) {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getLt" + i);
					int value = (int) m.invoke(sw);
					if (value > max) {
						max = value;
						pos = i;
					}
				}
				List<Integer> list = null;
				if (!Lhc3FdSw.class.isAssignableFrom(sw.getClass())) {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getW" + pos + "Pos");
					list = getNums((int) m.invoke(sw) - 1);
				} else {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getW" + pos + "Arr");
					String[] nums = ((String) m.invoke(sw)).split(",\\s*");
					list = new ArrayList<>();
					for (String num : nums) {
						list.add(Integer.valueOf(num));
					}
				}
				info.setNums(list);

				pos = 1;
				max = 0;
				for (int i = 1; i <= length; i++) {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getW" + i);
					int value = (int) m.invoke(sw);
					if (value > max) {
						max = value;
						pos = i;
					}
				}
				list = null;
				if (!Lhc3FdSw.class.isAssignableFrom(sw.getClass())) {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getW" + pos + "Pos");
					list = getNums((int) m.invoke(sw) - 1);
				} else {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getW" + pos + "Arr");
					String[] nums = ((String) m.invoke(sw)).split(",\\s*");
					list = new ArrayList<>();
					for (String num : nums) {
						list.add(Integer.valueOf(num));
					}
				}
				info.setNumsForD1(list);

				List<TempInfo> tmpList = new ArrayList<>();
				for (int i = 1; i <= length; i++) {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getW" + i);
					int value = (int) m.invoke(sw);
					TempInfo tmpInfo = new TempInfo();
					tmpInfo.setValue(value);
					tmpInfo.setPos(i);
					tmpList.add(tmpInfo);
				}
				tmpList.sort(new Comparator<TempInfo>() {

					@Override
					public int compare(TempInfo o1, TempInfo o2) {
						return o1.getValue().compareTo(o2.getValue());
					}
				});
				pos = tmpList.get(1).getPos();
				list = null;
				if (!Lhc3FdSw.class.isAssignableFrom(sw.getClass())) {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getW" + pos + "Pos");
					list = getNums((int) m.invoke(sw) - 1);
				} else {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getW" + pos + "Arr");
					String[] nums = ((String) m.invoke(sw)).split(",\\s*");
					list = new ArrayList<>();
					for (String num : nums) {
						list.add(Integer.valueOf(num));
					}
				}
				info.setNumsForS2(list);
				
				Collections.reverse(tmpList);
				pos = tmpList.get(1).getPos();
				list = null;
				if (!Lhc3FdSw.class.isAssignableFrom(sw.getClass())) {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getW" + pos + "Pos");
					list = getNums((int) m.invoke(sw) - 1);
				} else {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getW" + pos + "Arr");
					String[] nums = ((String) m.invoke(sw)).split(",\\s*");
					list = new ArrayList<>();
					for (String num : nums) {
						list.add(Integer.valueOf(num));
					}
				}
				info.setNumsForD2(list);
				
				pos = tmpList.get(2).getPos();
				list = null;
				if (!Lhc3FdSw.class.isAssignableFrom(sw.getClass())) {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getW" + pos + "Pos");
					list = getNums((int) m.invoke(sw) - 1);
				} else {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getW" + pos + "Arr");
					String[] nums = ((String) m.invoke(sw)).split(",\\s*");
					list = new ArrayList<>();
					for (String num : nums) {
						list.add(Integer.valueOf(num));
					}
				}
				info.setNumsForD3(list);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return new AsyncResult<ZInfo>(info);
	}

	protected abstract List<Integer> getNums(int pos);

}
