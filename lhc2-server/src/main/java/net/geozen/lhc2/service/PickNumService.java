package net.geozen.lhc2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
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
import net.geozen.lhc2.nums.SlqNums;
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
import net.geozen.lhc2.service.slq.SlqyzCalculationService;
import net.geozen.lhc2.service.slq.SlqzfCalculationService;
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
@Slf4j
public class PickNumService {
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
	private SlqyzCalculationService slqyzCalculationService;

	@Autowired
	private SlqzfCalculationService slqzfCalculationService;

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

	@Transactional
	@Async
	public Future<Exception> process() {
		Exception t = null;
		try {
			pickNumRepository.deleteAll();
			process(14);
			process(10);
			process(7);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<>(t);
	}

	private void process(int expected) throws Exception {
		int size = 20;
		int offsetForLast20 = 0;
		// int pageNumForCurrent = 20;
		// Pageable pageable = PageRequest.of(1, size, Direction.ASC, "phase");
		Pageable pageable = PageRequest.of(0, 1, Direction.DESC, "phase");
		Page<Tm> pResult = null;
		// do {
		pResult = tmRepository.findAll(pageable);
		if (pResult.hasContent()) {
			for (Tm tm : pResult.getContent()) {
				List<List<Integer>> nums = new ArrayList<List<Integer>>();
				// Pageable current = PageRequest.of(pageNumForCurrent, 1);
				Pageable current = PageRequest.of(1, 20, Direction.DESC, "phase");
				int count = 0;
				boolean reached = countNumbers(nums, tm, current, offsetForLast20, size, count, expected, true);
				if (!reached) {
					reached = countNumbers(nums, tm, current, offsetForLast20, size, count, expected, false);
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
				pickNum.setExpected(expected);
				pickNum.setPhase(tm.getPhase());
				pickNum.setPayload(new ObjectMapper().writeValueAsString(payload));
				pickNumRepository.save(pickNum);
				// pageNumForCurrent++;
				// offsetForLast20++;
			}
			// pageable = pageable.next();
		}
		// } while (pResult.hasNext());
	}

	private boolean countNumbers(List<List<Integer>> nums, Tm tm, Pageable current, int offset, int size, int count, int expected, boolean compare)
			throws Exception {
		count = getNumbersFromSxyz(nums, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromSxzf(nums, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(seqyzCalculationService, nums, SeqNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(seqzfCalculationService, nums, SeqNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(slqyzCalculationService, nums, SlqNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(slqzfCalculationService, nums, SlqNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromFdsw(nums, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(pdyzCalculationService, nums, PdNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(pdzfCalculationService, nums, PdNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(z2yzCalculationService, nums, Z2Nums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(z2zfCalculationService, nums, Z2Nums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(z13yzCalculationService, nums, Z13Nums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(z13zfCalculationService, nums, Z13Nums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(dsyzCalculationService, nums, DsNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(dszfCalculationService, nums, DsNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(mwyzCalculationService, nums, MwNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(mwzfCalculationService, nums, MwNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(hsyzCalculationService, nums, HsNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(hszfCalculationService, nums, HsNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(bsyzCalculationService, nums, BsNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(bszfCalculationService, nums, BsNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(zsyzCalculationService, nums, ZsNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(zszfCalculationService, nums, ZsNums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(z7yzCalculationService, nums, Z7Nums.class, tm, current, offset, size, count, expected, compare);
		count = getNumbersFromYz(z7zfCalculationService, nums, Z7Nums.class, tm, current, offset, size, count, expected, compare);
		return count >= expected;
	}

	private int getNumbersFromSxyz(List<List<Integer>> nums, Tm tm, Pageable current, int offset, int size, int count, int expected, boolean compare)
			throws Exception {
		if (count < expected) {
			int delta = 15;
			int avgForLast20 = sxyzCalculationService.getTotalAvgForLastPhases(offset, size);
			int avgForCurrent = sxyzCalculationService.getTotalAvgForLastPhases(current.getPageNumber(), current.getPageSize());
			boolean toCount = !compare;
			if (avgForCurrent < avgForLast20) {
				int avg = avgForCurrent / 12;
				MaxInfo max = sxyzCalculationService.getMax(tm.getPhase());
				if (!compare || avg - max.getYz() < delta) {
					nums.add(sxyzCalculationService.getNumbers(max));
					toCount = true;
				}
			}
			if (toCount) {
				count++;
			}
		}
		return count;
	}

	private int getNumbersFromSxzf(List<List<Integer>> nums, Tm tm, Pageable current, int offset, int size, int count, int expected, boolean compare)
			throws Exception {
		if (count < expected) {
			int delta = 15;
			int avgForLast20 = sxzfCalculationService.getTotalAvgForLastPhases(offset, size);
			int avgForCurrent = sxzfCalculationService.getTotalAvgForLastPhases(current.getPageNumber(), current.getPageSize());
			boolean toCount = !compare;
			if (avgForCurrent < avgForLast20) {
				int avg = avgForCurrent / 12;
				MaxInfo max = sxzfCalculationService.getMax(tm.getPhase());
				if (avg - max.getYz() < delta) {
					nums.add(sxzfCalculationService.getNumbers(max));
					toCount = true;
				}
			}
			if (toCount) {
				count++;
			}
		}
		return count;
	}

	private int getNumbersFromFdsw(List<List<Integer>> nums, Tm tm, Pageable current, int offset, int size, int count, int expected, boolean compare)
			throws Exception {
		if (count < expected) {
			int delta = 15;
			int avgForLast20 = fdswCalculationService.getTotalAvgForLastPhases(offset, size);
			int avgForCurrent = fdswCalculationService.getTotalAvgForLastPhases(current.getPageNumber(), current.getPageSize());
			boolean toCount = !compare;
			if (avgForCurrent < avgForLast20) {
				int avg = avgForCurrent / 12;
				MaxInfo max = fdswCalculationService.getMax(tm.getPhase());
				if (avg - max.getYz() < delta) {
					nums.add(max.getNums());
					toCount = true;
				}
			}
			if (toCount) {
				count++;
			}
		}
		return count;
	}

	private int getNumbersFromYz(BasePosYzCalculationService<?> yzService, List<List<Integer>> nums, Class<?> numsClass, Tm tm, Pageable current,
			int offset, int size, int count, int expected, boolean compare) throws Exception {
		if (count < expected) {
			int delta = 15;
			int avgForLast20 = yzService.getTotalAvgForLastPhases(offset, size);
			int avgForCurrent = yzService.getTotalAvgForLastPhases(current.getPageNumber(), current.getPageSize());
			boolean toCount = !compare;
			if (avgForCurrent < avgForLast20) {
				int avg = avgForCurrent / (yzService.getEndPos() + 1);
				MaxInfo max = yzService.getMax(tm.getPhase());
				if (avg - max.getYz() < delta) {
					nums.add(yzService.getNumbers(numsClass, max));
					toCount = true;
				}
			}
			if (toCount) {
				count++;
			}
		}
		return count;
	}

	private int getNumbersFromYz(BaseZfCalculationService<?, ?> zfService, List<List<Integer>> nums, Class<?> numsClass, Tm tm, Pageable current,
			int offset, int size, int count, int expected, boolean compare) throws Exception {
		if (count < expected) {
			int delta = 15;
			int avgForLast20 = zfService.getTotalAvgForLastPhases(offset, size);
			int avgForCurrent = zfService.getTotalAvgForLastPhases(current.getPageNumber(), current.getPageSize());
			boolean toCount = !compare;
			if (avgForCurrent < avgForLast20) {
				int avg = avgForCurrent / (zfService.getEndPos() + 1);
				MaxInfo max = zfService.getMax(tm.getPhase());
				if (avg - max.getYz() < delta) {
					nums.add(zfService.getNumbers(numsClass, max));
					toCount = true;
				}
			}
			if (toCount) {
				count++;
			}
		}
		return count;
	}
}
