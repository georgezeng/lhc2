package net.geozen.lhc2.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;

import net.geozen.lhc2.domain.AnalyzeYz;
import net.geozen.lhc2.domain.PickNum;
import net.geozen.lhc2.domain.Tm;
import net.geozen.lhc2.dto.PickNumCountInfo;
import net.geozen.lhc2.dto.PickNumPayload;
import net.geozen.lhc2.dto.ZInfo;
import net.geozen.lhc2.jpa.AnalyzeYzRepository;
import net.geozen.lhc2.jpa.PickNumRepository;
import net.geozen.lhc2.jpa.TmRepository;
import net.geozen.lhc2.service.ds.DsyzZValueCalService;
import net.geozen.lhc2.service.ds.DszfZValueCalService;
import net.geozen.lhc2.service.fd.FdswZValueCalService;
import net.geozen.lhc2.service.hs.HsyzZValueCalService;
import net.geozen.lhc2.service.hs.HszfZValueCalService;
import net.geozen.lhc2.service.mw.MwyzZValueCalService;
import net.geozen.lhc2.service.mw.MwzfZValueCalService;
import net.geozen.lhc2.service.pd.PdyzZValueCalService;
import net.geozen.lhc2.service.pd.PdzfZValueCalService;
import net.geozen.lhc2.service.seq.SeqyzZValueCalService;
import net.geozen.lhc2.service.seq.SeqzfZValueCalService;
import net.geozen.lhc2.service.slq.a.SlqayzZValueCalService;
import net.geozen.lhc2.service.slq.a.SlqazfZValueCalService;
import net.geozen.lhc2.service.slq.b.SlqbyzZValueCalService;
import net.geozen.lhc2.service.slq.b.SlqbzfZValueCalService;
import net.geozen.lhc2.service.slq.bs.SlqbsyzZValueCalService;
import net.geozen.lhc2.service.slq.bs.SlqbszfZValueCalService;
import net.geozen.lhc2.service.slq.c.SlqcyzZValueCalService;
import net.geozen.lhc2.service.slq.c.SlqczfZValueCalService;
import net.geozen.lhc2.service.slq.d.SlqdyzZValueCalService;
import net.geozen.lhc2.service.slq.d.SlqdzfZValueCalService;
import net.geozen.lhc2.service.slq.wx.SlqwxyzZValueCalService;
import net.geozen.lhc2.service.slq.wx.SlqwxzfZValueCalService;
import net.geozen.lhc2.service.slq.zs.SlqzsyzZValueCalService;
import net.geozen.lhc2.service.slq.zs.SlqzszfZValueCalService;
import net.geozen.lhc2.service.sx.SxyzZValueCalService;
import net.geozen.lhc2.service.sx.SxzfZValueCalService;
import net.geozen.lhc2.service.z13.Z13yzZValueCalService;
import net.geozen.lhc2.service.z13.Z13zfZValueCalService;
import net.geozen.lhc2.service.z2.Z2yzZValueCalService;
import net.geozen.lhc2.service.z2.Z2zfZValueCalService;
import net.geozen.lhc2.service.z7.Z7yzZValueCalService;
import net.geozen.lhc2.service.z7.Z7zfZValueCalService;
import net.geozen.lhc2.utils.CommonUtil;

@Service
public class ZValueCalService {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private TmRepository tmRepository;
	@Autowired
	private SxyzZValueCalService sxyzZValueCalService;
	@Autowired
	private SxzfZValueCalService sxzfZValueCalService;
	@Autowired
	private SlqayzZValueCalService slqayzZValueCalService;
	@Autowired
	private SlqazfZValueCalService slqazfZValueCalService;
	@Autowired
	private SlqbyzZValueCalService slqbyzZValueCalService;
	@Autowired
	private SlqbzfZValueCalService slqbzfZValueCalService;
	@Autowired
	private SlqcyzZValueCalService slqcyzZValueCalService;
	@Autowired
	private SlqczfZValueCalService slqczfZValueCalService;
	@Autowired
	private SlqdyzZValueCalService slqdyzZValueCalService;
	@Autowired
	private SlqdzfZValueCalService slqdzfZValueCalService;
	@Autowired
	private SlqbsyzZValueCalService slqbsyzZValueCalService;
	@Autowired
	private SlqbszfZValueCalService slqbszfZValueCalService;
	@Autowired
	private SlqzsyzZValueCalService slqzsyzZValueCalService;
	@Autowired
	private SlqzszfZValueCalService slqzszfZValueCalService;
	@Autowired
	private SlqwxyzZValueCalService slqwxyzZValueCalService;
	@Autowired
	private SlqwxzfZValueCalService slqwxzfZValueCalService;
	@Autowired
	private SeqyzZValueCalService seqyzZValueCalService;
	@Autowired
	private SeqzfZValueCalService seqzfZValueCalService;
	@Autowired
	private PdyzZValueCalService pdyzZValueCalService;
	@Autowired
	private PdzfZValueCalService pdzfZValueCalService;
	@Autowired
	private Z2yzZValueCalService z2yzZValueCalService;
	@Autowired
	private Z2zfZValueCalService z2zfZValueCalService;
	@Autowired
	private Z13yzZValueCalService z13yzZValueCalService;
	@Autowired
	private Z13zfZValueCalService z13zfZValueCalService;
	@Autowired
	private MwyzZValueCalService mwyzZValueCalService;
	@Autowired
	private MwzfZValueCalService mwzfZValueCalService;
	@Autowired
	private HsyzZValueCalService hsyzZValueCalService;
	@Autowired
	private HszfZValueCalService hszfZValueCalService;
	@Autowired
	private DsyzZValueCalService dsyzZValueCalService;
	@Autowired
	private DszfZValueCalService dszfZValueCalService;
	@Autowired
	private Z7yzZValueCalService z7yzZValueCalService;
	@Autowired
	private Z7zfZValueCalService z7zfZValueCalService;
	@Autowired
	private FdswZValueCalService fdswZValueCalService;
	@Autowired
	private PickNumRepository pickNumRepository;
	@Autowired
	private AnalyzeYzRepository analyzeYzRepository;

	private ObjectMapper map = new ObjectMapper();

	public void process() {
		try {
			Pageable pageable = PageRequest.of(0, 1000, Direction.ASC, "phase");
			Page<Tm> pResult = null;
			int index = 0;
			AnalyzeYz lastAYzP1 = null;
			AnalyzeYz lastAYzP2 = null;
			AnalyzeYz lastAYzP3 = null;
			do {
				pResult = tmRepository.findAll(pageable);
				if (pResult.hasContent()) {
					for (Tm tm : pResult.getContent()) {
						if (index == 0) {
							index++;
							continue;
						}
						List<Future<ZInfo>> futures = new ArrayList<>();

						futures.add(slqayzZValueCalService.process(tm, 1));
						futures.add(slqbyzZValueCalService.process(tm, 2));
						futures.add(slqcyzZValueCalService.process(tm, 3));
						futures.add(slqdyzZValueCalService.process(tm, 4));
						futures.add(slqbsyzZValueCalService.process(tm, 5));
						futures.add(slqzsyzZValueCalService.process(tm, 6));
						futures.add(slqwxyzZValueCalService.process(tm, 7));
						futures.add(sxyzZValueCalService.process(tm, 8));
						futures.add(seqyzZValueCalService.process(tm, 9));
						futures.add(fdswZValueCalService.process(tm, 10));
						futures.add(pdyzZValueCalService.process(tm, 11));
						futures.add(z2yzZValueCalService.process(tm, 12));
						futures.add(z13yzZValueCalService.process(tm, 13));
						futures.add(mwyzZValueCalService.process(tm, 14));
						futures.add(hsyzZValueCalService.process(tm, 15));
						futures.add(dsyzZValueCalService.process(tm, 16));
						futures.add(z7yzZValueCalService.process(tm, 17));
						futures.add(slqazfZValueCalService.process(tm, 18));
						futures.add(slqbzfZValueCalService.process(tm, 19));
						futures.add(slqczfZValueCalService.process(tm, 20));
						futures.add(slqdzfZValueCalService.process(tm, 21));
						futures.add(slqbszfZValueCalService.process(tm, 22));
						futures.add(slqzszfZValueCalService.process(tm, 23));
						futures.add(slqwxzfZValueCalService.process(tm, 24));
						futures.add(sxzfZValueCalService.process(tm, 25));
						futures.add(seqzfZValueCalService.process(tm, 26));
						futures.add(pdzfZValueCalService.process(tm, 27));
						futures.add(z2zfZValueCalService.process(tm, 28));
						futures.add(z13zfZValueCalService.process(tm, 29));
						futures.add(mwzfZValueCalService.process(tm, 30));
						futures.add(hszfZValueCalService.process(tm, 31));
						futures.add(dszfZValueCalService.process(tm, 32));
						futures.add(z7zfZValueCalService.process(tm, 33));

						List<ZInfo> infos = CommonUtil.waitForResult(futures);
						Collections.sort(infos, new Comparator<ZInfo>() {

							@Override
							public int compare(ZInfo o1, ZInfo o2) {
								if (o1 == null) {
									if (o2 != null) {
										return 1;
									} else {
										return 0;
									}
								} else if (o2 == null) {
									return -1;
								}
								int compare = o1.getZ().compareTo(o2.getZ());
								if (compare == 0) {
									if (o1.getOrder() < o2.getOrder()) {
										return -1;
									} else {
										return 1;
									}
								}
								return compare;
							}
						});
//						System.out.print(tm.getPhase() + ": ");
//						for(ZInfo info : infos) {
//							
//							System.out.print("{" + info.getOrder() + "}, ");
//						}
//						System.out.println();

						// P1
						pickNum(tm, infos.subList(0, 4), 1, "P1");
						pickNum(tm, infos.subList(4, 8), 2, "P1");
						pickNum(tm, infos.subList(8, 12), 3, "P1");
						lastAYzP1 = pickNum(tm, infos.subList(0, 12), 12, "P1", lastAYzP1);

						// P2
//						pickNumForP2(tm, infos.subList(0, 1), 1);
//						pickNumForP2(tm, infos.subList(0, 4), 4);
						pickNum(tm, infos.subList(11, 15), 1, "P2");
						pickNum(tm, infos.subList(15, 19), 2, "P2");
						pickNum(tm, infos.subList(19, 23), 3, "P2");
//						pickNumForP2(tm, infos.subList(12, 16), 4);
						lastAYzP2 = pickNum(tm, infos.subList(11, 23), 12, "P2", lastAYzP2);

						// pickNumForP2(tm, infos.subList(0, 2), 2);
						// pickNumForP2(tm, infos.subList(0, 4), 4);
						// pickNumForP2(tm, infos.subList(0, 8), 8);
						// pickNumForP2(tm, infos.subList(0, 10), 10);
						// pickNumForP2(tm, infos.subList(0, 12), 12);
						// pickNumForP2(tm, infos.subList(0, 16), 16);
						// pickNumForP2(tm, infos.subList(0, 20), 20);
						// pickNumForP2(tm, infos.subList(0, 24), 24);
						// pickNumForP2(tm, infos.subList(0, 33), 33);

						// P3
						// pickNumForP3(tm, infos.subList(31, 33), 2);
						// pickNumForP3(tm, infos.subList(30, 33), 3);
						// pickNumForP3(tm, infos.subList(29, 33), 4);
						// pickNumForP3(tm, infos.subList(25, 33), 8);
						// pickNumForP3(tm, infos.subList(17, 33), 16);
						// pickNumForP3(tm, infos.subList(13, 16), 3);
						// pickNumForP3(tm, infos.subList(12, 16), 4);
						// pickNumForP3(tm, infos.subList(8, 16), 8);

//						pickNumForP3(tm, infos.subList(21, 25), 4);
						pickNum(tm, infos.subList(21, 25), 1, "P3");
						pickNum(tm, infos.subList(25, 29), 2, "P3");
						pickNum(tm, infos.subList(29, 33), 3, "P3");
						lastAYzP3 = pickNum(tm, infos.subList(21, 33), 12, "P3", lastAYzP3);

						// String str = "phase: " + tm.getPhase() + ", infos:[";
						// for(ZInfo info : infos) {
						// str += info.toString() +",";
						// }str+="]";
						// System.out.println(str);

						index++;
					}
					pageable = pageable.next();
				}
			} while (pResult.hasNext());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private void pickNumForP2(Tm tm, List<ZInfo> subInfos, int expected) throws Exception {
		PickNumPayload payload = new PickNumPayload();
		List<PickNumCountInfo> countInfos = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			PickNumCountInfo countInfo = new PickNumCountInfo();
			countInfo.setNum(i);
			for (ZInfo info : subInfos) {
				if (info != null && info.getNums() != null && info.getNums().contains(i)) {
					countInfo.setCount(countInfo.getCount() + 1);
				}
			}
			countInfos.add(countInfo);
		}
		payload.setInfos(countInfos);
//		payload.setPhase(tm.getPhase() + "");

		PickNum pickNum = new PickNum();
		pickNum.setExpected(expected);
		pickNum.setPayload(map.writeValueAsString(payload));
		pickNum.setPhase(tm.getPhase());
		pickNum.setTm(tm.getNum());
		pickNum.setType("P2");
		pickNumRepository.save(pickNum);
	}

	private void pickNum(Tm tm, List<ZInfo> subInfos, int expected, String type) throws Exception {
		PickNumPayload payload = new PickNumPayload();
		List<PickNumCountInfo> countInfos = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			PickNumCountInfo countInfo = new PickNumCountInfo();
			countInfo.setNum(i);
			for (ZInfo info : subInfos) {
				if (info != null && info.getNums() != null && info.getNums().contains(i)) {
					countInfo.setCount(countInfo.getCount() + 1);
				}
			}
			countInfos.add(countInfo);
		}
//		payload.setPhase(tm.getPhase() + "");
		payload.setInfos(countInfos);

		PickNum pickNum = new PickNum();
		pickNum.setExpected(expected);
		pickNum.setPayload(map.writeValueAsString(payload));
		pickNum.setPhase(tm.getPhase());
		pickNum.setTm(tm.getNum());
		pickNum.setType(type);
		pickNumRepository.save(pickNum);
	}

	private AnalyzeYz pickNum(Tm tm, List<ZInfo> subInfos, int expected, String type, AnalyzeYz lastAYz) throws Exception {
		AnalyzeYz last6 = analyzeYzRepository.findByExpectedAndTypeAndPhase(expected, type, tm.getPhase() - 6);
		AnalyzeYz last5 = analyzeYzRepository.findByExpectedAndTypeAndPhase(expected, type, tm.getPhase() - 5);
		AnalyzeYz last4 = analyzeYzRepository.findByExpectedAndTypeAndPhase(expected, type, tm.getPhase() - 4);
		AnalyzeYz last3 = analyzeYzRepository.findByExpectedAndTypeAndPhase(expected, type, tm.getPhase() - 3);
		AnalyzeYz last2 = analyzeYzRepository.findByExpectedAndTypeAndPhase(expected, type, tm.getPhase() - 2);
		AnalyzeYz last1 = lastAYz;
		AnalyzeYz aYz = new AnalyzeYz();
		aYz.setExpected(expected);
		aYz.setPhase(tm.getPhase());
		aYz.setTm(tm.getNum());
		aYz.setType(type);
		PickNumPayload payload = new PickNumPayload();
		List<Integer> count0 = new ArrayList<>();
		List<Integer> count1p = new ArrayList<>();
		List<PickNumCountInfo> countInfos = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			PickNumCountInfo countInfo = new PickNumCountInfo();
			countInfo.setNum(i);
			for (ZInfo info : subInfos) {
				if (info != null && info.getNums() != null && info.getNums().contains(i)) {
					countInfo.setCount(countInfo.getCount() + 1);
				}
			}
			countInfos.add(countInfo);
			if (countInfo.getCount() > 0) {
				count1p.add(countInfo.getNum());
			} else {
				count0.add(countInfo.getNum());
			}
		}
		boolean is1p = false;
		PickNumPayload lastPayload = null;
		if(last1 != null) {
			PickNum lastPick = pickNumRepository.findByExpectedAndTypeAndPhase(expected, type, tm.getPhase() -1);
			lastPayload = map.readValue(lastPick.getPayload(), PickNumPayload.class);
			for (PickNumCountInfo countInfo : lastPayload.getInfos()) {
				if (countInfo.getCount() > 0) {
					if (tm.getNum() == countInfo.getNum()) {
						is1p = true;
						break;
					}
				} 
			}
		}
		if (is1p) {
			aYz.setYz1p(0);
			if (lastAYz != null) {
				aYz.setYz0(lastAYz.getYz0() + 1);
			} else {
				aYz.setYz0(1);
			}
		} else {
			aYz.setYz0(0);
			if (lastAYz != null) {
				aYz.setYz1p(lastAYz.getYz1p() + 1);
			} else {
				aYz.setYz1p(1);
			}
		}
		aYz.setNums0arr(Joiner.on(",").join(count0));
		aYz.setNums1parr(Joiner.on(",").join(count1p));
		aYz.setNums0(count0.size());
		aYz.setNums1p(count1p.size());

		if (last1 != null) {
			aYz.setNums0Avg(aYz.getNums0() + last1.getNums0());
			aYz.setNums1pAvg(aYz.getNums1p() + last1.getNums1p());
			if (last2 != null) {
				aYz.setNums0Avg(aYz.getNums0Avg() + last2.getNums0());
				aYz.setNums1pAvg(aYz.getNums1pAvg() + last2.getNums1p());
				if (last3 != null) {
					aYz.setNums0Avg(aYz.getNums0Avg() + last3.getNums0());
					aYz.setNums1pAvg(aYz.getNums1pAvg() + last3.getNums1p());
					if (last4 != null) {
						aYz.setNums0Avg(aYz.getNums0Avg() + last4.getNums0());
						aYz.setNums1pAvg(aYz.getNums1pAvg() + last4.getNums1p());
						if (last5 != null) {
							aYz.setNums0Avg(aYz.getNums0Avg() + last5.getNums0());
							aYz.setNums1pAvg(aYz.getNums1pAvg() + last5.getNums1p());
							if (last6 != null) {
								aYz.setNums0Avg(aYz.getNums0Avg() + last5.getNums0());
								aYz.setNums1pAvg(aYz.getNums1pAvg() + last5.getNums1p());
								aYz.setNums0Avg(new BigDecimal(aYz.getNums0Avg()).divide(new BigDecimal(7), 0, RoundingMode.HALF_UP).intValue());
								aYz.setNums1pAvg(new BigDecimal(aYz.getNums1pAvg()).divide(new BigDecimal(7), RoundingMode.HALF_UP).intValue());
							} else {
								aYz.setNums0Avg(new BigDecimal(aYz.getNums0Avg()).divide(new BigDecimal(6), 0, RoundingMode.HALF_UP).intValue());
								aYz.setNums1pAvg(new BigDecimal(aYz.getNums1pAvg()).divide(new BigDecimal(6), 0, RoundingMode.HALF_UP).intValue());
							}
						} else {
							aYz.setNums0Avg(new BigDecimal(aYz.getNums0Avg()).divide(new BigDecimal(5), 0, RoundingMode.HALF_UP).intValue());
							aYz.setNums1pAvg(new BigDecimal(aYz.getNums1pAvg()).divide(new BigDecimal(5), 0, RoundingMode.HALF_UP).intValue());
						}
					} else {
						aYz.setNums0Avg(new BigDecimal(aYz.getNums0Avg()).divide(new BigDecimal(4), 0, RoundingMode.HALF_UP).intValue());
						aYz.setNums1pAvg(new BigDecimal(aYz.getNums1pAvg()).divide(new BigDecimal(4), 0, RoundingMode.HALF_UP).intValue());
					}
				} else {
					aYz.setNums0Avg(new BigDecimal(aYz.getNums0Avg()).divide(new BigDecimal(3), 0, RoundingMode.HALF_UP).intValue());
					aYz.setNums1pAvg(new BigDecimal(aYz.getNums1pAvg()).divide(new BigDecimal(3), 0, RoundingMode.HALF_UP).intValue());
				}
			} else {
				aYz.setNums0Avg(new BigDecimal(aYz.getNums0Avg()).divide(new BigDecimal(2), 0, RoundingMode.HALF_UP).intValue());
				aYz.setNums1pAvg(new BigDecimal(aYz.getNums1pAvg()).divide(new BigDecimal(2), 0, RoundingMode.HALF_UP).intValue());
			}
		} else {
			aYz.setNums0Avg(aYz.getNums0());
			aYz.setNums1pAvg(aYz.getNums1p());
		}

		if (last1 != null) {
			aYz.setLastNums0(last1.getNums0());
			aYz.setLastNums0Avg(last1.getNums0Avg());
			aYz.setLastNums1p(last1.getNums1p());
			aYz.setLastNums1pAvg(last1.getNums1pAvg());
			aYz.setLastYz0(last1.getYz0());
			aYz.setLastYz1p(last1.getYz1p());
			
			if (aYz.getYz0() == 0 && aYz.getLastNums0() < aYz.getLastNums0Avg()) {
				aYz.setLastYz0light(0);
			} else {
				aYz.setLastYz0light(last1.getYz0light() + 1);
			}
			if (aYz.getYz1p() == 0 && aYz.getLastNums1p() < aYz.getLastNums1pAvg()) {
				aYz.setLastYz1pLight(0);
			} else {
				aYz.setLastYz1pLight(last1.getYz1pLight() + 1);
			}
			
		} else {
			aYz.setLastYz0light(1);
			aYz.setLastYz1pLight(1);
		}
		analyzeYzRepository.save(aYz);

//		payload.setPhase(tm.getPhase() + "");
		payload.setInfos(countInfos);

		PickNum pickNum = new PickNum();
		pickNum.setExpected(expected);
		pickNum.setPayload(map.writeValueAsString(payload));
		pickNum.setPhase(tm.getPhase());
		pickNum.setTm(tm.getNum());
		pickNum.setType(type);
		pickNumRepository.save(pickNum);
		return aYz;
	}

}
