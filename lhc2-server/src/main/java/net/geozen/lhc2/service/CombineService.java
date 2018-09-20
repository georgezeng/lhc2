package net.geozen.lhc2.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.dto.StatInfo;
import net.geozen.lhc2.dto.StatTotallyInfo;
import net.geozen.lhc2.enums.SX;
import net.geozen.lhc2.jpa.bs.BsswRepository;
import net.geozen.lhc2.jpa.fd.FdswRepository;
import net.geozen.lhc2.jpa.hs.HsswRepository;
import net.geozen.lhc2.jpa.mw.MwswRepository;
import net.geozen.lhc2.jpa.pd.PdswRepository;
import net.geozen.lhc2.jpa.qq.QqswRepository;
import net.geozen.lhc2.jpa.seq.SeqswRepository;
import net.geozen.lhc2.jpa.slq.SlqswRepository;
import net.geozen.lhc2.jpa.sw.SwswRepository;
import net.geozen.lhc2.jpa.sx.SxswRepository;
import net.geozen.lhc2.jpa.z13.Z13swRepository;
import net.geozen.lhc2.jpa.z2.Z2swRepository;
import net.geozen.lhc2.jpa.z7.Z7swRepository;
import net.geozen.lhc2.jpa.zs.ZsswRepository;
import net.geozen.lhc2.nums.BsNums;
import net.geozen.lhc2.nums.HsNums;
import net.geozen.lhc2.nums.MwNums;
import net.geozen.lhc2.nums.PdNums;
import net.geozen.lhc2.nums.QqNums;
import net.geozen.lhc2.nums.SeqNums;
import net.geozen.lhc2.nums.SlqNums;
import net.geozen.lhc2.nums.SwNums;
import net.geozen.lhc2.nums.Z13Nums;
import net.geozen.lhc2.nums.Z2Nums;
import net.geozen.lhc2.nums.Z7Nums;
import net.geozen.lhc2.nums.ZsNums;
import net.geozen.lhc2.utils.SxUtil;

@SuppressWarnings("unchecked")
@Service
@Slf4j
public class CombineService {
	@Autowired
	private SxswRepository sxRepository;
	@Autowired
	private SeqswRepository seqRepository;
	@Autowired
	private SlqswRepository slqRepository;
	@Autowired
	private QqswRepository qqRepository;
	@Autowired
	private MwswRepository mwRepository;
	@Autowired
	private HsswRepository hsRepository;
	@Autowired
	private BsswRepository bsRepository;
	@Autowired
	private FdswRepository fdRepository;
	@Autowired
	private Z2swRepository z2Repository;
	@Autowired
	private Z13swRepository z13Repository;
	@Autowired
	private PdswRepository pdRepository;
	@Autowired
	private ZsswRepository zsRepository;
	@Autowired
	private SwswRepository swRepository;
	@Autowired
	private Z7swRepository z7Repository;

	private List<StatTotallyInfo> totallyList1 = new ArrayList<>();

	private List<StatTotallyInfo> totallyList2 = new ArrayList<>();

	public List<StatTotallyInfo> list1() {
		return totallyList1;
	}

	public List<StatTotallyInfo> list2() {
		return totallyList2;
	}

	@Async
	public Future<Exception> process() {
		Exception t = null;
		try {
			Set<Integer> A = getA();
			Set<Integer> B = getB();
			Set<Integer> C = getC();
			Set<Integer> D = getD();
			Set<Integer> E = getE();
			Set<Integer> F = getF();
			Set<Integer> G = getG();
			Set<Integer> H = getH();
			count(A, B, C, D, E, F, G, H, true, totallyList1);
			count(A, B, C, D, E, F, G, H, false, totallyList2);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<Exception>(t);
	}

	private void count(StatTotallyInfo totallYInfo, List<StatInfo> list) {
		for (StatInfo info : list) {
			if (info.getCount() == totallYInfo.getCount()) {
				totallYInfo.add(info.getNum());
			}
		}
	}

	private void count(Set<Integer> A, Set<Integer> B, Set<Integer> C, Set<Integer> D, Set<Integer> E, Set<Integer> F, Set<Integer> G, Set<Integer> H,
			boolean revert, List<StatTotallyInfo> totallyList) {
		Map<Integer, StatInfo> infos = new HashMap<Integer, StatInfo>();
		count(infos, combine(revert, A, B, C, D));
		count(infos, combine(revert, E, B, C, D));
		count(infos, combine(revert, A, F, C, D));
		count(infos, combine(revert, A, B, G, D));
		count(infos, combine(revert, A, B, C, H));
		count(infos, combine(revert, E, F, G, H));
		count(infos, combine(revert, A, F, G, H));
		count(infos, combine(revert, E, B, G, H));
		count(infos, combine(revert, E, F, C, H));
		count(infos, combine(revert, E, F, G, D));
		List<StatInfo> list = new ArrayList<>(infos.values());
		Collections.sort(list, new Comparator<StatInfo>() {

			@Override
			public int compare(StatInfo o1, StatInfo o2) {
				if (o1.getCount() != o2.getCount()) {
					return Integer.valueOf(o1.getCount()).compareTo(Integer.valueOf(o2.getCount()));
				} else {
					return Integer.valueOf(o1.getNum()).compareTo(Integer.valueOf(o2.getNum()));
				}
			}

		});
		totallyList.clear();
		if (revert) {
			for (int i = 1; i < 11; i++) {
				switch (i) {
				case 1:
				case 2:
				case 3:
				case 5:
				case 10: {
					StatTotallyInfo totallYInfo = new StatTotallyInfo();
					totallYInfo.setCount(i);
					count(totallYInfo, list);
					totallyList.add(totallYInfo);
				}
				}
			}
		} else {
			for (int i = 0; i < 11; i++) {
				switch (i) {
				case 0: {
					List<StatInfo> all = new ArrayList<>();
					for (int j = 1; j < 50; j++) {
						boolean zeroCount = true;
						for (StatInfo info : list) {
							if (info.getNum() == j) {
								zeroCount = false;
								break;
							}
						}
						if (zeroCount) {
							all.add(new StatInfo(j, 0));
						}
					}
					StatTotallyInfo totallYInfo = new StatTotallyInfo();
					totallYInfo.setCount(i);
					count(totallYInfo, all);
					totallyList.add(totallYInfo);
				}
					break;
				case 5:
				case 7:
				case 8:
				case 9:
				case 10: {
					StatTotallyInfo totallYInfo = new StatTotallyInfo();
					totallYInfo.setCount(i);
					count(totallYInfo, list);
					totallyList.add(totallYInfo);
				}
					break;
				}
			}
		}
	}

	private Set<Integer> combine(boolean revert, Set<Integer>... sets) {
		Set<Integer> combine = new HashSet<Integer>();
		for (Set<Integer> set : sets) {
			combine.addAll(set);
		}
		if (revert) {
			Set<Integer> temp = new HashSet<>();
			for (int i = 1; i < 50; i++) {
				if (!combine.contains(i)) {
					temp.add(i);
				}
			}
			return temp;
		}
		return combine;
	}

	private void count(Map<Integer, StatInfo> infos, Set<Integer> set) {
		for (Integer num : set) {
			StatInfo info = infos.get(num);
			if (info == null) {
				info = new StatInfo(num, 1);
				infos.put(num, info);
			} else {
				info.setCount(info.getCount() + 1);
			}
		}
	}

	private Set<Integer> getA() {
		Set<Integer> set = new HashSet<>();
		SX bmnSx = SxUtil.getSxByYear(new Date());
		List<Integer> list = SxUtil.getSxNums(bmnSx, sxRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2sx());
		set.addAll(list);
		list = SeqNums.LISTS.get(seqRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Pos());
		set.addAll(list);
		list = SlqNums.LISTS.get(slqRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Pos());
		set.addAll(list);
		list = QqNums.LISTS.get(qqRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Pos());
		set.addAll(list);
		return set;
	}

	private Set<Integer> getE() {
		Set<Integer> set = new HashSet<>();
		SX bmnSx = SxUtil.getSxByYear(new Date());
		List<Integer> list = SxUtil.getSxNums(bmnSx, sxRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3sx());
		set.addAll(list);
		list = SeqNums.LISTS.get(seqRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Pos());
		set.addAll(list);
		list = SlqNums.LISTS.get(slqRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Pos());
		set.addAll(list);
		list = QqNums.LISTS.get(qqRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Pos());
		set.addAll(list);
		return set;
	}

	private Set<Integer> getB() {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = MwNums.LISTS.get(mwRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Pos());
		set.addAll(list);
		list = HsNums.LISTS.get(hsRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Pos());
		set.addAll(list);
		list = BsNums.LISTS.get(bsRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Pos());
		set.addAll(list);
		String[] arr = StringUtils
				.commaDelimitedListToStringArray(fdRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Arr());
		List<Integer> nums = new ArrayList<>();
		for (String num : arr) {
			nums.add(Integer.valueOf(num));
		}
		set.addAll(nums);
		return set;
	}

	private Set<Integer> getF() {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = MwNums.LISTS.get(mwRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Pos());
		set.addAll(list);
		list = HsNums.LISTS.get(hsRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Pos());
		set.addAll(list);
		list = BsNums.LISTS.get(bsRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Pos());
		set.addAll(list);
		String[] arr = StringUtils
				.commaDelimitedListToStringArray(fdRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Arr());
		List<Integer> nums = new ArrayList<>();
		for (String num : arr) {
			nums.add(Integer.valueOf(num));
		}
		set.addAll(nums);
		return set;
	}

	private Set<Integer> getC() {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = Z2Nums.LISTS.get(z2Repository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Pos());
		set.addAll(list);
		list = Z13Nums.LISTS.get(z13Repository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Pos());
		set.addAll(list);
		list = PdNums.LISTS.get(pdRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Pos());
		set.addAll(list);
		list = ZsNums.LISTS.get(zsRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Pos());
		set.addAll(list);
		return set;
	}

	private Set<Integer> getG() {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = Z2Nums.LISTS.get(z2Repository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Pos());
		set.addAll(list);
		list = Z13Nums.LISTS.get(z13Repository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Pos());
		set.addAll(list);
		list = PdNums.LISTS.get(pdRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Pos());
		set.addAll(list);
		list = ZsNums.LISTS.get(zsRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Pos());
		set.addAll(list);
		return set;
	}

	private Set<Integer> getD() {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = SwNums.LISTS.get(swRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Pos());
		set.addAll(list);
		list = Z7Nums.LISTS.get(z7Repository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw2Pos());
		set.addAll(list);
		return set;
	}

	private Set<Integer> getH() {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = SwNums.LISTS.get(swRepository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Pos());
		set.addAll(list);
		list = Z7Nums.LISTS.get(z7Repository.findAll(Sort.by(Direction.DESC, "phase")).iterator().next().getSw3Pos());
		set.addAll(list);
		return set;
	}

}
