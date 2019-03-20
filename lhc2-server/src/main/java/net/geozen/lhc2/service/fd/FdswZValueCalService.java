package net.geozen.lhc2.service.fd;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.domain.Tm;
import net.geozen.lhc2.domain.fd.Fdsw;
import net.geozen.lhc2.dto.ZInfo;
import net.geozen.lhc2.jpa.fd.FdswRepository;

@Service
@Slf4j
public class FdswZValueCalService {
	@Autowired
	private FdswRepository swRepository;

	@Async
	public Future<ZInfo> process(Tm tm, int order) {
		ZInfo info = null;
		try {
//			int len = 20;
//			int count = 0;
//			BigDecimal avg = BigDecimal.ZERO;
//			while (count < len) {
//				Fdsw yz = swRepository.findByPhase(tm.getPhase() - count);
//				if (yz == null) {
//					break;
//				}
//				for (int i = 1; i <= 12; i++) {
//					Method m = ReflectionUtils.findMethod(yz.getClass(), "getSw" + i);
//					Integer value = (Integer) m.invoke(yz);
//					BigDecimal decimal = new BigDecimal(value);
//					avg = avg.add(decimal);
//				}
//				count++;
//			}
//			if (count == len - 1) {
//				avg = avg.divide(new BigDecimal(count), 2, RoundingMode.HALF_UP);
				Fdsw yz = swRepository.findByPhase(tm.getPhase());
//				BigDecimal b = BigDecimal.ZERO; // b for max
				BigDecimal c = BigDecimal.ZERO; // d for total
//				String maxArr = null;
				for (int i = 1; i <= 12; i++) {
					Method m = ReflectionUtils.findMethod(yz.getClass(), "getSw" + i);
					Integer value = (Integer) m.invoke(yz);
					BigDecimal decimal = new BigDecimal(value);
//					if (b.compareTo(decimal) < 0) {
//						b = decimal;
//						Method m2 = ReflectionUtils.findMethod(yz.getClass(), "getSw" + i + "Arr");
//						maxArr = (String) m2.invoke(yz);
//					}
					c = c.add(decimal);
				}

				BigDecimal d = c.divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP); // d for avg
//				BigDecimal x = d.divide(b, 2, RoundingMode.HALF_UP);
				Fdsw sw = swRepository.findByPhase(tm.getPhase());
				BigDecimal f = BigDecimal.ZERO; // f for d1+d2+d3+d4+d5
				for (int i = 7; i < 12; i++) {
					Method m = ReflectionUtils.findMethod(sw.getClass(), "getSw" + i);
					Integer value = (Integer) m.invoke(sw);
					BigDecimal decimal = new BigDecimal(value);
					f = f.add(decimal);
				}
//				BigDecimal y = f.divide(c, 2, RoundingMode.HALF_UP);
//				BigDecimal z = avg.divide(x.add(y), 2, RoundingMode.HALF_UP);
				BigDecimal z = f.divide(d, 2, RoundingMode.HALF_UP);

				
				List<Fdsw> list = swRepository.findAllByPhaseLessThanEqual(tm.getPhase());
				Map<String, Integer> redCount = new HashMap<>();
				String[] fields = new String[] {"sw1","sw2","sw3","sw4","sw5","sw6","sw7","sw8","sw9","sw10","sw11","sw12"};
				for (Fdsw data : list) {
					for (String field : fields) {
						Integer counted = redCount.get(field);
						if (counted == null) {
							counted = 0;
						}
						String name = "get" + StringUtils.capitalize(field);
						Method m = ReflectionUtils.findMethod(data.getClass(), name);
						Assert.notNull(m, "cannot find method " + name + " in " + data.getClass());
						Integer value = (Integer) m.invoke(data);
						if (value != null && value == 0) {
							counted++;
						}
						redCount.put(field, counted);
					}
				}
				Map.Entry<String, Integer> lessEntry = null;
				int lessPos = 0;
				int index = 0;
				for (Map.Entry<String, Integer> entry : redCount.entrySet()) {
					if (lessEntry == null) {
						lessEntry = entry;
					} else {
						lessEntry = entry.getValue() < lessEntry.getValue() ? entry : lessEntry;
						lessPos = index;
					}
					index++;
				}
				Method m = ReflectionUtils.findMethod(Fdsw.class, "getSw" + lessPos + "Arr");
				String arr = (String) m.invoke(yz);
				List<Integer> nums = new ArrayList<>();
				for(String num : arr.split(",\\s*")) {
					nums.add(Integer.valueOf(num));
				}
				
				info = new ZInfo();
				info.setOrder(order);
				info.setZ(z);
//				List<Integer> nums = new ArrayList<>();
//				for (String num : maxArr.split(",\\s*")) {
//					nums.add(Integer.valueOf(num));
//				}
				info.setNums(nums);
//			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return new AsyncResult<ZInfo>(info);
	}

}
