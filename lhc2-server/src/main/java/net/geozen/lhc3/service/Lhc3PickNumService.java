package net.geozen.lhc3.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.geozen.lhc2.dto.PickNumCountInfo;
import net.geozen.lhc2.dto.PickNumPayload;
import net.geozen.lhc2.dto.ZInfo;
import net.geozen.lhc2.utils.CommonUtil;
import net.geozen.lhc3.domain.Lhc3PickNum;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.jpa.Lhc3PickNumRepository;
import net.geozen.lhc3.service.fd.Lhc3FdSwZValueService;
import net.geozen.lhc3.service.seqa.Lhc3SeqaYzZValueService;
import net.geozen.lhc3.service.seqb.Lhc3SeqbSwZValueService;
import net.geozen.lhc3.service.seqb.Lhc3SeqbYzZValueService;
import net.geozen.lhc3.service.seqb.Lhc3SeqbZfZValueService;
import net.geozen.lhc3.service.seqc.Lhc3SeqcSwZValueService;
import net.geozen.lhc3.service.seqc.Lhc3SeqcYzZValueService;
import net.geozen.lhc3.service.seqc.Lhc3SeqcZfZValueService;
import net.geozen.lhc3.service.seqd.Lhc3SeqdSwZValueService;
import net.geozen.lhc3.service.seqd.Lhc3SeqdYzZValueService;
import net.geozen.lhc3.service.seqd.Lhc3SeqdZfZValueService;
import net.geozen.lhc3.service.seqe.Lhc3SeqeSwZValueService;
import net.geozen.lhc3.service.seqe.Lhc3SeqeYzZValueService;
import net.geozen.lhc3.service.seqe.Lhc3SeqeZfZValueService;
import net.geozen.lhc3.service.seqf.Lhc3SeqfSwZValueService;
import net.geozen.lhc3.service.seqf.Lhc3SeqfYzZValueService;
import net.geozen.lhc3.service.seqf.Lhc3SeqfZfZValueService;
import net.geozen.lhc3.service.seqg.Lhc3SeqgSwZValueService;
import net.geozen.lhc3.service.seqg.Lhc3SeqgYzZValueService;
import net.geozen.lhc3.service.seqg.Lhc3SeqgZfZValueService;
import net.geozen.lhc3.service.seqh.Lhc3SeqhSwZValueService;
import net.geozen.lhc3.service.seqh.Lhc3SeqhYzZValueService;
import net.geozen.lhc3.service.seqh.Lhc3SeqhZfZValueService;
import net.geozen.lhc3.service.seqi.Lhc3SeqiSwZValueService;
import net.geozen.lhc3.service.seqi.Lhc3SeqiYzZValueService;
import net.geozen.lhc3.service.seqi.Lhc3SeqiZfZValueService;
import net.geozen.lhc3.service.seqj.Lhc3SeqjSwZValueService;
import net.geozen.lhc3.service.seqj.Lhc3SeqjYzZValueService;
import net.geozen.lhc3.service.seqj.Lhc3SeqjZfZValueService;
import net.geozen.lhc3.service.seqk.Lhc3SeqkSwZValueService;
import net.geozen.lhc3.service.seqk.Lhc3SeqkYzZValueService;
import net.geozen.lhc3.service.seqk.Lhc3SeqkZfZValueService;
import net.geozen.lhc3.service.seql.Lhc3SeqlSwZValueService;
import net.geozen.lhc3.service.seql.Lhc3SeqlYzZValueService;
import net.geozen.lhc3.service.seql.Lhc3SeqlZfZValueService;
import net.geozen.lhc3.service.seqm.Lhc3SeqmSwZValueService;
import net.geozen.lhc3.service.seqm.Lhc3SeqmYzZValueService;
import net.geozen.lhc3.service.seqm.Lhc3SeqmZfZValueService;
import net.geozen.lhc3.service.seqn.Lhc3SeqnSwZValueService;
import net.geozen.lhc3.service.seqn.Lhc3SeqnYzZValueService;
import net.geozen.lhc3.service.seqn.Lhc3SeqnZfZValueService;
import net.geozen.lhc3.service.seqo.Lhc3SeqoSwZValueService;
import net.geozen.lhc3.service.seqo.Lhc3SeqoYzZValueService;
import net.geozen.lhc3.service.seqo.Lhc3SeqoZfZValueService;
import net.geozen.lhc3.service.seqp.Lhc3SeqpSwZValueService;
import net.geozen.lhc3.service.seqp.Lhc3SeqpYzZValueService;
import net.geozen.lhc3.service.seqp.Lhc3SeqpZfZValueService;
import net.geozen.lhc3.service.seqq.Lhc3SeqqSwZValueService;
import net.geozen.lhc3.service.seqq.Lhc3SeqqYzZValueService;
import net.geozen.lhc3.service.seqq.Lhc3SeqqZfZValueService;
import net.geozen.lhc3.service.seqr.Lhc3SeqrSwZValueService;
import net.geozen.lhc3.service.seqr.Lhc3SeqrYzZValueService;
import net.geozen.lhc3.service.seqr.Lhc3SeqrZfZValueService;

@Service
public class Lhc3PickNumService {
	@Autowired
	private Lhc3SeqaYzZValueService seqaYzZValueService;

	@Autowired
	private Lhc3SeqcZfZValueService seqaZfZValueService;

	@Autowired
	private Lhc3SeqcSwZValueService seqaSwZValueService;

	@Autowired
	private Lhc3SeqbYzZValueService seqbYzZValueService;

	@Autowired
	private Lhc3SeqbZfZValueService seqbZfZValueService;

	@Autowired
	private Lhc3SeqbSwZValueService seqbSwZValueService;

	@Autowired
	private Lhc3SeqcYzZValueService seqcYzZValueService;

	@Autowired
	private Lhc3SeqcZfZValueService seqcZfZValueService;

	@Autowired
	private Lhc3SeqcSwZValueService seqcSwZValueService;

	@Autowired
	private Lhc3SeqdYzZValueService seqdYzZValueService;

	@Autowired
	private Lhc3SeqdZfZValueService seqdZfZValueService;

	@Autowired
	private Lhc3SeqdSwZValueService seqdSwZValueService;

	@Autowired
	private Lhc3SeqeYzZValueService seqeYzZValueService;

	@Autowired
	private Lhc3SeqeZfZValueService seqeZfZValueService;

	@Autowired
	private Lhc3SeqeSwZValueService seqeSwZValueService;

	@Autowired
	private Lhc3SeqfYzZValueService seqfYzZValueService;

	@Autowired
	private Lhc3SeqfZfZValueService seqfZfZValueService;

	@Autowired
	private Lhc3SeqfSwZValueService seqfSwZValueService;

	@Autowired
	private Lhc3SeqgYzZValueService seqgYzZValueService;

	@Autowired
	private Lhc3SeqgZfZValueService seqgZfZValueService;

	@Autowired
	private Lhc3SeqgSwZValueService seqgSwZValueService;

	@Autowired
	private Lhc3SeqhYzZValueService seqhYzZValueService;

	@Autowired
	private Lhc3SeqhZfZValueService seqhZfZValueService;

	@Autowired
	private Lhc3SeqhSwZValueService seqhSwZValueService;

	@Autowired
	private Lhc3SeqiYzZValueService seqiYzZValueService;

	@Autowired
	private Lhc3SeqiZfZValueService seqiZfZValueService;

	@Autowired
	private Lhc3SeqiSwZValueService seqiSwZValueService;

	@Autowired
	private Lhc3SeqjYzZValueService seqjYzZValueService;

	@Autowired
	private Lhc3SeqjZfZValueService seqjZfZValueService;

	@Autowired
	private Lhc3SeqjSwZValueService seqjSwZValueService;

	@Autowired
	private Lhc3SeqkYzZValueService seqkYzZValueService;

	@Autowired
	private Lhc3SeqkZfZValueService seqkZfZValueService;

	@Autowired
	private Lhc3SeqkSwZValueService seqkSwZValueService;

	@Autowired
	private Lhc3SeqlYzZValueService seqlYzZValueService;

	@Autowired
	private Lhc3SeqlZfZValueService seqlZfZValueService;

	@Autowired
	private Lhc3SeqlSwZValueService seqlSwZValueService;

	@Autowired
	private Lhc3SeqmYzZValueService seqmYzZValueService;

	@Autowired
	private Lhc3SeqmZfZValueService seqmZfZValueService;

	@Autowired
	private Lhc3SeqmSwZValueService seqmSwZValueService;

	@Autowired
	private Lhc3SeqnYzZValueService seqnYzZValueService;

	@Autowired
	private Lhc3SeqnZfZValueService seqnZfZValueService;

	@Autowired
	private Lhc3SeqnSwZValueService seqnSwZValueService;

	@Autowired
	private Lhc3SeqoYzZValueService seqoYzZValueService;

	@Autowired
	private Lhc3SeqoZfZValueService seqoZfZValueService;

	@Autowired
	private Lhc3SeqoSwZValueService seqoSwZValueService;

	@Autowired
	private Lhc3SeqpYzZValueService seqpYzZValueService;

	@Autowired
	private Lhc3SeqpZfZValueService seqpZfZValueService;

	@Autowired
	private Lhc3SeqpSwZValueService seqpSwZValueService;

	@Autowired
	private Lhc3SeqqYzZValueService seqqYzZValueService;

	@Autowired
	private Lhc3SeqqZfZValueService seqqZfZValueService;

	@Autowired
	private Lhc3SeqqSwZValueService seqqSwZValueService;

	@Autowired
	private Lhc3SeqrYzZValueService seqrYzZValueService;

	@Autowired
	private Lhc3SeqrZfZValueService seqrZfZValueService;

	@Autowired
	private Lhc3SeqrSwZValueService seqrSwZValueService;

	@Autowired
	private Lhc3FdSwZValueService fdSwZValueService;

	@Autowired
	private Lhc3PickNumRepository pickNumRepository;

	@Autowired
	private ObjectMapper mapper;

	@Async
	public Future<Exception> cal(List<Lhc3Tm> tmList) {
		Exception t = null;
		try {
			for (Lhc3Tm tm : tmList) {
				List<Future<ZInfo>> fs = new ArrayList<>();
				fs.add(seqaYzZValueService.process(tm, 1));
				fs.add(seqaZfZValueService.process(tm, 2));
				fs.add(seqaSwZValueService.process(tm, 3));
				fs.add(seqbYzZValueService.process(tm, 4));
				fs.add(seqbZfZValueService.process(tm, 5));
				fs.add(seqbSwZValueService.process(tm, 6));
				fs.add(seqcYzZValueService.process(tm, 7));
				fs.add(seqcZfZValueService.process(tm, 8));
				fs.add(seqcSwZValueService.process(tm, 9));
				fs.add(seqdYzZValueService.process(tm, 10));
				fs.add(seqdZfZValueService.process(tm, 11));
				fs.add(seqdSwZValueService.process(tm, 12));
				fs.add(seqeYzZValueService.process(tm, 13));
				fs.add(seqeZfZValueService.process(tm, 14));
				fs.add(seqeSwZValueService.process(tm, 15));
				fs.add(seqfYzZValueService.process(tm, 16));
				fs.add(seqfZfZValueService.process(tm, 17));
				fs.add(seqfSwZValueService.process(tm, 18));
				fs.add(seqgYzZValueService.process(tm, 19));
				fs.add(seqgZfZValueService.process(tm, 20));
				fs.add(seqgSwZValueService.process(tm, 21));
				fs.add(seqhYzZValueService.process(tm, 22));
				fs.add(seqhZfZValueService.process(tm, 23));
				fs.add(seqhSwZValueService.process(tm, 24));
				fs.add(seqiYzZValueService.process(tm, 25));
				fs.add(seqiZfZValueService.process(tm, 26));
				fs.add(seqiSwZValueService.process(tm, 27));
				fs.add(seqjYzZValueService.process(tm, 28));
				fs.add(seqjZfZValueService.process(tm, 29));
				fs.add(seqjSwZValueService.process(tm, 30));
				fs.add(seqkYzZValueService.process(tm, 31));
				fs.add(seqkZfZValueService.process(tm, 32));
				fs.add(seqkSwZValueService.process(tm, 33));
				fs.add(seqlYzZValueService.process(tm, 34));
				fs.add(seqlZfZValueService.process(tm, 35));
				fs.add(seqlSwZValueService.process(tm, 36));
				fs.add(seqmYzZValueService.process(tm, 37));
				fs.add(seqmZfZValueService.process(tm, 38));
				fs.add(seqmSwZValueService.process(tm, 39));
				fs.add(seqnYzZValueService.process(tm, 40));
				fs.add(seqnZfZValueService.process(tm, 41));
				fs.add(seqnSwZValueService.process(tm, 42));
				fs.add(seqoYzZValueService.process(tm, 43));
				fs.add(seqoZfZValueService.process(tm, 44));
				fs.add(seqoSwZValueService.process(tm, 45));
				fs.add(seqpYzZValueService.process(tm, 46));
				fs.add(seqpZfZValueService.process(tm, 47));
				fs.add(seqpSwZValueService.process(tm, 48));
				fs.add(seqqYzZValueService.process(tm, 49));
				fs.add(seqqZfZValueService.process(tm, 50));
				fs.add(seqqSwZValueService.process(tm, 51));
				fs.add(seqrYzZValueService.process(tm, 52));
				fs.add(seqrZfZValueService.process(tm, 53));
				fs.add(seqrSwZValueService.process(tm, 54));
				fs.add(fdSwZValueService.process(tm, 55));
				List<ZInfo> infos = CommonUtil.waitForResult(fs);
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
				pickNumForP1(tm, infos);
				pickNum(tm, infos.subList(0, 12), 12, "P2");
				pickNum(tm, infos.subList(12, 24), 12, "P3");
				pickNumForP4(tm, infos);
			}
		} catch (Exception e) {
			t = e;
		}
		return new AsyncResult<>(t);
	}
	
	private void pickNumForP1(Lhc3Tm tm, List<ZInfo> infos) throws Exception {
		PickNumPayload payload = new PickNumPayload();
		List<PickNumCountInfo> countInfos = new ArrayList<>();
		List<ZInfo> subInfos1 = infos.subList(0, 8);
		List<ZInfo> subInfos2 = infos.subList(54, 56);
		for (int i = 1; i < 50; i++) {
			PickNumCountInfo countInfo = new PickNumCountInfo();
			countInfo.setNum(i);
			for (ZInfo info : subInfos1) {
				if (info != null && info.getNumsForD1() != null && info.getNumsForD1().contains(i)) {
					countInfo.setCount(countInfo.getCount() + 1);
				}
			}
			for (ZInfo info : subInfos2) {
				if (info != null && info.getNumsForD2() != null && info.getNumsForD2().contains(i)) {
					countInfo.setCount(countInfo.getCount() + 1);
				}
			}
			countInfos.add(countInfo);
		}
		payload.setInfos(countInfos);
		List<Integer> time0Arr = new ArrayList<>();
		List<Integer> time1Arr = new ArrayList<>();
		List<Integer> time2Arr = new ArrayList<>();
		List<Integer> time2PlusArr = new ArrayList<>();
		List<Integer> time3PlusArr = new ArrayList<>();
		for (PickNumCountInfo info : countInfos) {
			switch (info.getCount()) {
			case 0:
				time0Arr.add(info.getNum());
				break;
			case 1:
				time1Arr.add(info.getNum());
				break;
			case 2:
				time2Arr.add(info.getNum());
				break;
			default:
				time3PlusArr.add(info.getNum());
			}
			if (info.getCount() > 1) {
				time2PlusArr.add(info.getNum());
			}
		}

		Lhc3PickNum pickNum = new Lhc3PickNum();
		pickNum.setExpected(10);
		pickNum.setPayload(mapper.writeValueAsString(payload));
		pickNum.setPhase(tm.getPhase());
		pickNum.setNum(tm.getNum());
		pickNum.setType("P1");
		pickNum.setTime0(StringUtils.collectionToCommaDelimitedString(time0Arr));
		pickNum.setTime1(StringUtils.collectionToCommaDelimitedString(time1Arr));
		pickNum.setTime2(StringUtils.collectionToCommaDelimitedString(time2Arr));
		pickNum.setTime2Plus(StringUtils.collectionToCommaDelimitedString(time2PlusArr));
		pickNum.setTime3Plus(StringUtils.collectionToCommaDelimitedString(time3PlusArr));
		pickNumRepository.save(pickNum);
	}
	
	private void pickNumForP4(Lhc3Tm tm, List<ZInfo> infos) throws Exception {
		PickNumPayload payload = new PickNumPayload();
		List<PickNumCountInfo> countInfos = new ArrayList<>();
		List<ZInfo> subInfos1 = infos.subList(0, 2);
		List<ZInfo> subInfos2 = infos.subList(48, 56);
		for (int i = 1; i < 50; i++) {
			PickNumCountInfo countInfo = new PickNumCountInfo();
			countInfo.setNum(i);
			for (ZInfo info : subInfos1) {
				if (info != null && info.getNumsForD1() != null && info.getNumsForD1().contains(i)) {
					countInfo.setCount(countInfo.getCount() + 1);
				}
			}
			for (ZInfo info : subInfos2) {
				if (info != null && info.getNumsForS2() != null && info.getNumsForS2().contains(i)) {
					countInfo.setCount(countInfo.getCount() + 1);
				}
			}
			countInfos.add(countInfo);
		}
		payload.setInfos(countInfos);
		List<Integer> time0Arr = new ArrayList<>();
		List<Integer> time1Arr = new ArrayList<>();
		List<Integer> time2Arr = new ArrayList<>();
		List<Integer> time2PlusArr = new ArrayList<>();
		List<Integer> time3PlusArr = new ArrayList<>();
		for (PickNumCountInfo info : countInfos) {
			switch (info.getCount()) {
			case 0:
				time0Arr.add(info.getNum());
				break;
			case 1:
				time1Arr.add(info.getNum());
				break;
			case 2:
				time2Arr.add(info.getNum());
				break;
			default:
				time3PlusArr.add(info.getNum());
			}
			if (info.getCount() > 1) {
				time2PlusArr.add(info.getNum());
			}
		}
		
		Lhc3PickNum pickNum = new Lhc3PickNum();
		pickNum.setExpected(10);
		pickNum.setPayload(mapper.writeValueAsString(payload));
		pickNum.setPhase(tm.getPhase());
		pickNum.setNum(tm.getNum());
		pickNum.setType("P4");
		pickNum.setTime0(StringUtils.collectionToCommaDelimitedString(time0Arr));
		pickNum.setTime1(StringUtils.collectionToCommaDelimitedString(time1Arr));
		pickNum.setTime2(StringUtils.collectionToCommaDelimitedString(time2Arr));
		pickNum.setTime2Plus(StringUtils.collectionToCommaDelimitedString(time2PlusArr));
		pickNum.setTime3Plus(StringUtils.collectionToCommaDelimitedString(time3PlusArr));
		pickNumRepository.save(pickNum);
	}

	private void pickNum(Lhc3Tm tm, List<ZInfo> subInfos, int expected, String type) throws Exception {
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
		List<Integer> time0Arr = new ArrayList<>();
		List<Integer> time1Arr = new ArrayList<>();
		List<Integer> time2Arr = new ArrayList<>();
		List<Integer> time2PlusArr = new ArrayList<>();
		List<Integer> time3PlusArr = new ArrayList<>();
		for (PickNumCountInfo info : countInfos) {
			switch (info.getCount()) {
			case 0:
				time0Arr.add(info.getNum());
				break;
			case 1:
				time1Arr.add(info.getNum());
				break;
			case 2:
				time2Arr.add(info.getNum());
				break;
			default:
				time3PlusArr.add(info.getNum());
			}
			if (info.getCount() > 1) {
				time2PlusArr.add(info.getNum());
			}
		}

		Lhc3PickNum pickNum = new Lhc3PickNum();
		pickNum.setExpected(expected);
		pickNum.setPayload(mapper.writeValueAsString(payload));
		pickNum.setPhase(tm.getPhase());
		pickNum.setNum(tm.getNum());
		pickNum.setType(type);
		pickNum.setTime0(StringUtils.collectionToCommaDelimitedString(time0Arr));
		pickNum.setTime1(StringUtils.collectionToCommaDelimitedString(time1Arr));
		pickNum.setTime2(StringUtils.collectionToCommaDelimitedString(time2Arr));
		pickNum.setTime2Plus(StringUtils.collectionToCommaDelimitedString(time2PlusArr));
		pickNum.setTime3Plus(StringUtils.collectionToCommaDelimitedString(time3PlusArr));
		pickNumRepository.save(pickNum);
	}
}
