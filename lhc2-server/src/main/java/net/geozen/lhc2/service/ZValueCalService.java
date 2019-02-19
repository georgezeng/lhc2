package net.geozen.lhc2.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.domain.PickNum;
import net.geozen.lhc2.domain.Tm;
import net.geozen.lhc2.dto.PickNumCountInfo;
import net.geozen.lhc2.dto.PickNumPayload;
import net.geozen.lhc2.dto.ZInfo;
import net.geozen.lhc2.jpa.PickNumRepository;
import net.geozen.lhc2.jpa.TmRepository;
import net.geozen.lhc2.service.ds.DsyzZValueCalService;
import net.geozen.lhc2.service.ds.DszfZValueCalService;
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
@Slf4j
public class ZValueCalService {
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
	private PickNumRepository pickNumRepository;

	private ObjectMapper map = new ObjectMapper();

	public void process() {
		try {
			Pageable pageable = PageRequest.of(0, 1000, Direction.ASC, "phase");
			Page<Tm> pResult = null;
			do {
				pResult = tmRepository.findAll(pageable);
				if (pResult.hasContent()) {
					for (Tm tm : pResult.getContent()) {
						List<Future<ZInfo>> futures = new ArrayList<>();

						futures.add(slqayzZValueCalService.process(tm));
//						futures.add(slqazfZValueCalService.process(tm));

						futures.add(slqbyzZValueCalService.process(tm));
//						futures.add(slqbzfZValueCalService.process(tm));

						futures.add(slqcyzZValueCalService.process(tm));
//						futures.add(slqczfZValueCalService.process(tm));

						futures.add(slqdyzZValueCalService.process(tm));
//						futures.add(slqdzfZValueCalService.process(tm));

						futures.add(slqbsyzZValueCalService.process(tm));
//						futures.add(slqbszfZValueCalService.process(tm));

						futures.add(slqzsyzZValueCalService.process(tm));
//						futures.add(slqzszfZValueCalService.process(tm));

						futures.add(slqwxyzZValueCalService.process(tm));
//						futures.add(slqwxzfZValueCalService.process(tm));

						futures.add(sxyzZValueCalService.process(tm));
//						futures.add(sxzfZValueCalService.process(tm));

						futures.add(seqyzZValueCalService.process(tm));
//						futures.add(seqzfZValueCalService.process(tm));

						futures.add(pdyzZValueCalService.process(tm));
//						futures.add(pdzfZValueCalService.process(tm));

						futures.add(z2yzZValueCalService.process(tm));
//						futures.add(z2zfZValueCalService.process(tm));

						futures.add(z13yzZValueCalService.process(tm));
//						futures.add(z13zfZValueCalService.process(tm));

						futures.add(mwyzZValueCalService.process(tm));
//						futures.add(mwzfZValueCalService.process(tm));

						futures.add(hsyzZValueCalService.process(tm));
//						futures.add(hszfZValueCalService.process(tm));

						futures.add(dsyzZValueCalService.process(tm));
//						futures.add(dszfZValueCalService.process(tm));

						futures.add(z7yzZValueCalService.process(tm));
//						futures.add(z7zfZValueCalService.process(tm));

//						futures.add(z7zfZValueCalService.process(tm));

						List<ZInfo> infos = CommonUtil.waitForResult(futures);
//						System.out.println("=============================");
//						infos.stream().forEach(System.out::println);
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
								return o1.getZ().compareTo(o2.getZ());
							}
						});
						// P2
						pickNumForP2(tm, infos.subList(0, 2), 2);
						pickNumForP2(tm, infos.subList(0, 4), 4);
						pickNumForP2(tm, infos.subList(0, 8), 8);
						pickNumForP2(tm, infos.subList(0, 10), 10);
						pickNumForP2(tm, infos.subList(0, 12), 12);
						pickNumForP2(tm, infos, 16);
//						pickNumForP2(tm, infos.subList(0, 16), 16);
//						pickNumForP2(tm, infos.subList(0, 20), 20);
//						pickNumForP2(tm, infos.subList(0, 24), 24);
//						pickNumForP2(tm, infos.subList(0, 33), 33);
						
						// P3
//						pickNumForP3(tm, infos.subList(31, 33), 2);
//						pickNumForP3(tm, infos.subList(30, 33), 3);
//						pickNumForP3(tm, infos.subList(29, 33), 4);
//						pickNumForP3(tm, infos.subList(25, 33), 8);
//						pickNumForP3(tm, infos.subList(17, 33), 16);
						pickNumForP3(tm, infos.subList(14, 16), 2);
						pickNumForP3(tm, infos.subList(13, 16), 3);
						pickNumForP3(tm, infos.subList(12, 16), 4);
						pickNumForP3(tm, infos.subList(8, 16), 8);
						pickNumForP3(tm, infos, 16);
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

		PickNum pickNum = new PickNum();
		pickNum.setExpected(expected);
		pickNum.setPayload(map.writeValueAsString(payload));
		pickNum.setPhase(tm.getPhase());
		pickNum.setTm(tm.getNum());
		pickNum.setType("P2");
		pickNumRepository.save(pickNum);
	}
	
	private void pickNumForP3(Tm tm, List<ZInfo> subInfos, int expected) throws Exception {
		PickNumPayload payload = new PickNumPayload();
		List<PickNumCountInfo> countInfos = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			PickNumCountInfo countInfo = new PickNumCountInfo();
			countInfo.setNum(i);
			for (ZInfo info : subInfos) {
				if (info != null && info.getMinNums() != null && info.getMinNums().contains(i)) {
					countInfo.setCount(countInfo.getCount() + 1);
				}
			}
			countInfos.add(countInfo);
		}
		payload.setInfos(countInfos);

		PickNum pickNum = new PickNum();
		pickNum.setExpected(expected);
		pickNum.setPayload(map.writeValueAsString(payload));
		pickNum.setPhase(tm.getPhase());
		pickNum.setTm(tm.getNum());
		pickNum.setType("P3");
		pickNumRepository.save(pickNum);
	}

}
