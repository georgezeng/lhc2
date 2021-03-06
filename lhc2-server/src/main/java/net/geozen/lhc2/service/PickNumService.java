package net.geozen.lhc2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.geozen.lhc2.domain.PickNum;
import net.geozen.lhc2.domain.Tm;
import net.geozen.lhc2.dto.MaxInfo;
import net.geozen.lhc2.dto.PickNumCountInfo;
import net.geozen.lhc2.dto.PickNumPayload;
import net.geozen.lhc2.jpa.PickNumRepository;
import net.geozen.lhc2.jpa.TmRepository;
import net.geozen.lhc2.nums.BsNums;
import net.geozen.lhc2.nums.DsNums;
import net.geozen.lhc2.nums.HsNums;
import net.geozen.lhc2.nums.MwNums;
import net.geozen.lhc2.nums.PdNums;
import net.geozen.lhc2.nums.SeqNums;
import net.geozen.lhc2.nums.SlqdNums;
import net.geozen.lhc2.nums.Z13Nums;
import net.geozen.lhc2.nums.Z2Nums;
import net.geozen.lhc2.nums.Z7Nums;
import net.geozen.lhc2.nums.ZsNums;
import net.geozen.lhc2.service.base.BasePosYzCalculationService;
import net.geozen.lhc2.service.base.BaseZfCalculationService;
import net.geozen.lhc2.service.bs.BsyzCalculationService;
import net.geozen.lhc2.service.bs.BszfCalculationService;
import net.geozen.lhc2.service.ds.DsyzCalculationService;
import net.geozen.lhc2.service.ds.DszfCalculationService;
import net.geozen.lhc2.service.fd.FdswCalculationService;
import net.geozen.lhc2.service.hs.HsyzCalculationService;
import net.geozen.lhc2.service.hs.HszfCalculationService;
import net.geozen.lhc2.service.mw.MwyzCalculationService;
import net.geozen.lhc2.service.mw.MwzfCalculationService;
import net.geozen.lhc2.service.pd.PdyzCalculationService;
import net.geozen.lhc2.service.pd.PdzfCalculationService;
import net.geozen.lhc2.service.seq.SeqyzCalculationService;
import net.geozen.lhc2.service.seq.SeqzfCalculationService;
import net.geozen.lhc2.service.slq.d.SlqdyzCalculationService;
import net.geozen.lhc2.service.slq.d.SlqdzfCalculationService;
import net.geozen.lhc2.service.sx.SxyzCalculationService;
import net.geozen.lhc2.service.sx.SxzfCalculationService;
import net.geozen.lhc2.service.z13.Z13yzCalculationService;
import net.geozen.lhc2.service.z13.Z13zfCalculationService;
import net.geozen.lhc2.service.z2.Z2yzCalculationService;
import net.geozen.lhc2.service.z2.Z2zfCalculationService;
import net.geozen.lhc2.service.z7.Z7yzCalculationService;
import net.geozen.lhc2.service.z7.Z7zfCalculationService;
import net.geozen.lhc2.service.zs.ZsyzCalculationService;
import net.geozen.lhc2.service.zs.ZszfCalculationService;

@Service
public class PickNumService {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private BsyzCalculationService bsyzCalculationService;

	@Autowired
	private BszfCalculationService bszfCalculationService;

	@Autowired
	private DsyzCalculationService dsyzCalculationService;

	@Autowired
	private DszfCalculationService dszfCalculationService;

	@Autowired
	private HsyzCalculationService hsyzCalculationService;

	@Autowired
	private HszfCalculationService hszfCalculationService;

	@Autowired
	private MwyzCalculationService mwyzCalculationService;

	@Autowired
	private MwzfCalculationService mwzfCalculationService;

	@Autowired
	private PdyzCalculationService pdyzCalculationService;

	@Autowired
	private PdzfCalculationService pdzfCalculationService;

	@Autowired
	private SeqyzCalculationService seqyzCalculationService;

	@Autowired
	private SeqzfCalculationService seqzfCalculationService;

	@Autowired
	private SlqdyzCalculationService slqyzCalculationService;

	@Autowired
	private SlqdzfCalculationService slqzfCalculationService;

	@Autowired
	private SxyzCalculationService sxyzCalculationService;

	@Autowired
	private SxzfCalculationService sxzfCalculationService;

	@Autowired
	private Z13yzCalculationService z13yzCalculationService;

	@Autowired
	private Z13zfCalculationService z13zfCalculationService;

	@Autowired
	private Z2yzCalculationService z2yzCalculationService;

	@Autowired
	private Z2zfCalculationService z2zfCalculationService;

	@Autowired
	private Z7yzCalculationService z7yzCalculationService;

	@Autowired
	private Z7zfCalculationService z7zfCalculationService;

	@Autowired
	private ZsyzCalculationService zsyzCalculationService;

	@Autowired
	private ZszfCalculationService zszfCalculationService;

	@Autowired
	private FdswCalculationService fdswCalculationService;

	@Autowired
	private TmRepository tmRepository;

	@Autowired
	private PickNumRepository pickNumRepository;

	@Async
	public Future<Exception> process(int expected, int avg, int size, int minDelta, int maxDelta) {
		Exception t = null;
		try {
			int offset = 0;
			int pageNumForCurrent = size;
			Pageable pageable = PageRequest.of(1, size, Direction.ASC, "phase");
			// Pageable pageable = PageRequest.of(0, 1, Direction.DESC, "phase");
			Page<Tm> pResult = null;
			do {
				pResult = tmRepository.findAll(pageable);
				if (pResult.hasContent()) {
//					int index = 0;
					for (Tm tm : pResult.getContent()) {
//						if (pageable.getPageNumber() == 0) {
//							index++;
//							if (index < size) {
//								continue;
//							}
//						}
						List<List<Integer>> nums = new ArrayList<List<Integer>>();
						Pageable current = PageRequest.of(pageNumForCurrent, 1);
						// Pageable current = PageRequest.of(1, size, Direction.DESC, "phase");
						Map<String, Boolean> counter = new HashMap<String, Boolean>();
						int count = 0;
						count = countNumbers(nums, tm, current, offset, size, count, expected, counter, true, avg, minDelta, maxDelta);
						if (count < expected) {
							countNumbers(nums, tm, current, offset, size, count, expected, counter, false, avg, minDelta, maxDelta);
						}
						Map<Integer, PickNumCountInfo> map = new HashMap<Integer, PickNumCountInfo>();
						for (List<Integer> numArr : nums) {
							for (Integer num : numArr) {
								PickNumCountInfo info = map.get(num);
								if (info == null) {
									info = new PickNumCountInfo();
									info.setCount(1);
									info.setNum(num);
									map.put(num, info);
								} else {
									info.setCount(info.getCount() + 1);
								}
							}
						}
						for (int i = 1; i < 50; i++) {
							if (!map.containsKey(i)) {
								PickNumCountInfo info = new PickNumCountInfo();
								info.setCount(0);
								info.setNum(i);
								map.put(i, info);
							}
						}
						PickNumPayload payload = new PickNumPayload();
						payload.setInfos(new ArrayList<>(map.values()));
						PickNum pickNum = new PickNum();
						pickNum.setTm(tm.getNum());
						pickNum.setExpected(expected);
						pickNum.setPhase(tm.getPhase());
						pickNum.setType("P1");
						pickNum.setPayload(new ObjectMapper().writeValueAsString(payload));
						pickNumRepository.save(pickNum);
						pageNumForCurrent++;
						offset++;
					}
					pageable = pageable.next();
				}
			} while (pResult.hasNext());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<Exception>(t);
	}

	private int countNumbers(List<List<Integer>> nums, Tm tm, Pageable current, int offset, int size, int count, int expected,
			Map<String, Boolean> counter, boolean compare, int avgDelta, int minDelta, int maxDelta) throws Exception {
		count = getNumbersFromSxyz(nums, tm, current, offset, size, count, expected, counter, compare, avgDelta, minDelta, maxDelta);
		count = getNumbersFromSxzf(nums, tm, current, offset, size, count, expected, counter, compare, avgDelta, minDelta, maxDelta);
		count = getNumbersFromYz(seqyzCalculationService, nums, SeqNums.class, tm, current, offset, size, count, expected, counter, "seqyz", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromZf(seqzfCalculationService, nums, SeqNums.class, tm, current, offset, size, count, expected, counter, "seqzf", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromYz(slqyzCalculationService, nums, SlqdNums.class, tm, current, offset, size, count, expected, counter, "slqyz", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromZf(slqzfCalculationService, nums, SlqdNums.class, tm, current, offset, size, count, expected, counter, "slqzf", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromFdsw(nums, tm, current, offset, size, count, expected, counter, compare, avgDelta, minDelta, maxDelta);
		count = getNumbersFromYz(pdyzCalculationService, nums, PdNums.class, tm, current, offset, size, count, expected, counter, "pdyz", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromZf(pdzfCalculationService, nums, PdNums.class, tm, current, offset, size, count, expected, counter, "pdzf", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromYz(z2yzCalculationService, nums, Z2Nums.class, tm, current, offset, size, count, expected, counter, "z2yz", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromZf(z2zfCalculationService, nums, Z2Nums.class, tm, current, offset, size, count, expected, counter, "z2zf", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromYz(z13yzCalculationService, nums, Z13Nums.class, tm, current, offset, size, count, expected, counter, "z13yz", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromZf(z13zfCalculationService, nums, Z13Nums.class, tm, current, offset, size, count, expected, counter, "z13zf", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromYz(dsyzCalculationService, nums, DsNums.class, tm, current, offset, size, count, expected, counter, "dsyz", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromZf(dszfCalculationService, nums, DsNums.class, tm, current, offset, size, count, expected, counter, "dszf", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromYz(mwyzCalculationService, nums, MwNums.class, tm, current, offset, size, count, expected, counter, "mwyz", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromZf(mwzfCalculationService, nums, MwNums.class, tm, current, offset, size, count, expected, counter, "mwzf", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromYz(hsyzCalculationService, nums, HsNums.class, tm, current, offset, size, count, expected, counter, "hsyz", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromZf(hszfCalculationService, nums, HsNums.class, tm, current, offset, size, count, expected, counter, "hszf", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromYz(bsyzCalculationService, nums, BsNums.class, tm, current, offset, size, count, expected, counter, "bsyz", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromZf(bszfCalculationService, nums, BsNums.class, tm, current, offset, size, count, expected, counter, "bszf", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromYz(zsyzCalculationService, nums, ZsNums.class, tm, current, offset, size, count, expected, counter, "zsyz", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromZf(zszfCalculationService, nums, ZsNums.class, tm, current, offset, size, count, expected, counter, "zszf", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromYz(z7yzCalculationService, nums, Z7Nums.class, tm, current, offset, size, count, expected, counter, "z7yz", compare,
				avgDelta, minDelta, maxDelta);
		count = getNumbersFromZf(z7zfCalculationService, nums, Z7Nums.class, tm, current, offset, size, count, expected, counter, "z7zf", compare,
				avgDelta, minDelta, maxDelta);
		return count;
	}

	private int getNumbersFromSxyz(List<List<Integer>> nums, Tm tm, Pageable current, int offset, int size, int count, int expected,
			Map<String, Boolean> counter, boolean compare, int avgDelta, int minDelta, int maxDelta) throws Exception {
		Boolean hasCounted = counter.get("sxyz");
		if (hasCounted == null || !hasCounted) {
			if (count < expected) {
				int avgForLast = sxyzCalculationService.getTotalAvgForLastPhases(offset, size);
				int avgForCurrent = sxyzCalculationService.getTotalAvgForLastPhases(current.getPageNumber(), current.getPageSize());
				boolean toCount = !compare;
				MaxInfo max = sxyzCalculationService.getMax(tm.getPhase());
				if (avgForCurrent - avgForLast < avgDelta) {
					int avg = avgForCurrent / 12;
					if (!compare || max.getYz() - avg >= minDelta && max.getYz() - avg <= maxDelta) {
						toCount = true;
					}
				}
				if (toCount) {
					count++;
					nums.add(sxyzCalculationService.getNumbers(max));
					counter.put("sxyz", true);
				}
			}
		}
		return count;
	}

	private int getNumbersFromSxzf(List<List<Integer>> nums, Tm tm, Pageable current, int offset, int size, int count, int expected,
			Map<String, Boolean> counter, boolean compare, int avgDelta, int minDelta, int maxDelta) throws Exception {
		Boolean hasCounted = counter.get("sxzf");
		if (hasCounted == null || !hasCounted) {
			if (count < expected) {
				int avgForLast20 = sxzfCalculationService.getTotalAvgForLastPhases(offset, size);
				int avgForCurrent = sxzfCalculationService.getTotalAvgForLastPhases(current.getPageNumber(), current.getPageSize());
				boolean toCount = !compare;
				MaxInfo max = sxzfCalculationService.getMax(tm.getPhase());
				if (avgForCurrent - avgForLast20 < avgDelta) {
					int avg = avgForCurrent / 12;
					if (!compare || max.getYz() - avg >= minDelta && max.getYz() - avg <= maxDelta) {
						toCount = true;
					}
				}
				if (toCount) {
					count++;
					nums.add(sxzfCalculationService.getNumbers(max));
					counter.put("sxzf", true);
				}
			}
		}
		return count;
	}

	private int getNumbersFromFdsw(List<List<Integer>> nums, Tm tm, Pageable current, int offset, int size, int count, int expected,
			Map<String, Boolean> counter, boolean compare, int avgDelta, int minDelta, int maxDelta) throws Exception {
		Boolean hasCounted = counter.get("fdsw");
		if (hasCounted == null || !hasCounted) {
			if (count < expected) {
				int avgForLast20 = fdswCalculationService.getTotalAvgForLastPhases(offset, size);
				int avgForCurrent = fdswCalculationService.getTotalAvgForLastPhases(current.getPageNumber(), current.getPageSize());
				boolean toCount = !compare;
				MaxInfo max = fdswCalculationService.getMax(tm.getPhase());
				if (avgForCurrent - avgForLast20 < avgDelta) {
					int avg = avgForCurrent / 12;
					if (!compare || max.getYz() - avg >= minDelta && max.getYz() - avg <= maxDelta) {
						toCount = true;
					}
				}
				if (toCount) {
					count++;
					nums.add(max.getNums());
					counter.put("fdsw", true);
				}
			}
		}
		return count;
	}

	private int getNumbersFromYz(BasePosYzCalculationService<?> yzService, List<List<Integer>> nums, Class<?> numsClass, Tm tm, Pageable current,
			int offset, int size, int count, int expected, Map<String, Boolean> counter, String key, boolean compare, int avgDelta, int minDelta,
			int maxDelta) throws Exception {
		Boolean hasCounted = counter.get(key);
		if (hasCounted == null || !hasCounted) {
			if (count < expected) {
				int avgForLast20 = yzService.getTotalAvgForLastPhases(offset, size);
				int avgForCurrent = yzService.getTotalAvgForLastPhases(current.getPageNumber(), current.getPageSize());
				boolean toCount = !compare;
				MaxInfo max = yzService.getMax(tm.getPhase());
				if (avgForCurrent - avgForLast20 < avgDelta) {
					int avg = avgForCurrent / (yzService.getEndPos() + 1);
					if (!compare || max.getYz() - avg >= minDelta && max.getYz() - avg <= maxDelta) {
						toCount = true;
					}
				}
				if (toCount) {
					count++;
					nums.add(yzService.getNumbers(numsClass, max));
					counter.put(key, true);
				}
			}
		}
		return count;
	}

	private int getNumbersFromZf(BaseZfCalculationService<?, ?> zfService, List<List<Integer>> nums, Class<?> numsClass, Tm tm, Pageable current,
			int offset, int size, int count, int expected, Map<String, Boolean> counter, String key, boolean compare, int avgDelta, int minDelta,
			int maxDelta) throws Exception {
		Boolean hasCounted = counter.get(key);
		if (hasCounted == null || !hasCounted) {
			if (count < expected) {
				int avgForLast20 = zfService.getTotalAvgForLastPhases(offset, size);
				int avgForCurrent = zfService.getTotalAvgForLastPhases(current.getPageNumber(), current.getPageSize());
				boolean toCount = !compare;
				MaxInfo max = zfService.getMax(tm.getPhase());
				if (avgForCurrent - avgForLast20 < avgDelta) {
					int avg = avgForCurrent / (zfService.getEndPos() + 1);
					if (!compare || max.getYz() - avg >= minDelta && max.getYz() - avg <= maxDelta) {
						toCount = true;
					}
				}
				if (toCount) {
					count++;
					nums.add(zfService.getNumbers(numsClass, max));
					counter.put(key, true);
				}
			}
		}
		return count;
	}
}
