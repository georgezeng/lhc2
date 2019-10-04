package net.geozen.lhc3.service;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.domain.Lhc3PickNum;
import net.geozen.lhc3.domain.Lhc3Stake;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.jpa.Lhc3PickNumRepository;
import net.geozen.lhc3.jpa.Lhc3StakeRepository;

@Service
public class Lhc3StakeService {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private Lhc3PickNumRepository pickNumRepository;

	@Autowired
	private Lhc3StakeRepository repository;

	@Async
	public Future<Exception> cal(List<Lhc3Tm> tmList, String type, int tables, int totalTables) {
		Exception t = null;
		try {
			for (Lhc3Tm tm : tmList) {
				Map<Integer, Integer> lastMap = new HashMap<>();
				Map<Integer, Integer> map = new HashMap<>();
				for (int i = 1; i < 50; i++) {
					lastMap.put(i, 0);
					map.put(i, 0);
				}
				Optional<Lhc3PickNum> lastOpTotal = pickNumRepository.findFirstByExpectedAndTypeAndPhaseLessThanOrderByPhaseDesc(totalTables, type,
						tm.getPhase());
				List<Integer> time1PlusNums = new ArrayList<>();
				if (lastOpTotal.isPresent()) {
					List<String> time0Nums = Arrays.asList(lastOpTotal.get().getTime0().split(","));
					for (int j = 1; j < 50; j++) {
						if (!time0Nums.contains(j + "")) {
							time1PlusNums.add(j);
						}
					}
				}
				for (int i = 1; i <= tables; i++) {
					Optional<Lhc3PickNum> op = pickNumRepository.findFirstByExpectedAndTypeAndPhaseLessThanOrderByPhaseDesc(i, type, tm.getPhase());
					if (op.isPresent()) {
						List<Integer> currentTime1PlusNums = new ArrayList<>();
						Lhc3PickNum lastPn = op.get();
						List<String> time0Nums = Arrays.asList(lastPn.getTime0().split(","));
						for (int j = 1; j < 50; j++) {
							if (!time0Nums.contains(j + "")) {
								currentTime1PlusNums.add(j);
							}
						}
						for (Integer j : time1PlusNums) {
							if (!currentTime1PlusNums.contains(j)) {
								lastMap.put(j, lastMap.get(j) + 1);
							}
						}
					}
				}
				
				int count = 0;
				Optional<Lhc3PickNum> opTotal = pickNumRepository.findByExpectedAndTypeAndPhase(totalTables, type,
						tm.getPhase());
				time1PlusNums = new ArrayList<>();
				if (opTotal.isPresent()) {
					List<String> time0Nums = Arrays.asList(opTotal.get().getTime0().split(","));
					for (int j = 1; j < 50; j++) {
						if (!time0Nums.contains(j + "")) {
							time1PlusNums.add(j);
						}
					}
				}
				for (int i = 1; i <= tables; i++) {
					Optional<Lhc3PickNum> op = pickNumRepository.findByExpectedAndTypeAndPhase(i, type, tm.getPhase());
					if (op.isPresent()) {
						List<Integer> currentTime1PlusNums = new ArrayList<>();
						Lhc3PickNum pn = op.get();
						List<String> time0Nums = Arrays.asList(pn.getTime0().split(","));
						for (int j = 1; j < 50; j++) {
							if (!time0Nums.contains(j + "")) {
								currentTime1PlusNums.add(j);
							}
						}
						for (Integer j : time1PlusNums) {
							if (!currentTime1PlusNums.contains(j)) {
								map.put(j, map.get(j) + 1);
								count++;
							}
						}
					}
				}
				
				Optional<Lhc3Stake> lastOp = repository.findFirstByTypeAndPhaseLessThanOrderByPhaseDesc(type, tm.getPhase());
				BigDecimal historyAmount = BigDecimal.ZERO;
				BigDecimal historyBonus = BigDecimal.ZERO;
				if (lastOp.isPresent()) {
					historyAmount = lastOp.get().getHistoryAmount();
					historyBonus = lastOp.get().getHistoryBonus();
				}
				Lhc3Stake stake = new Lhc3Stake();
				stake.setType(type);
				stake.setNum(tm.getNum());
				stake.setPhase(tm.getPhase());
				stake.setCurrentAmount(new BigDecimal(count));
				stake.setHistoryAmount(historyAmount.add(stake.getCurrentAmount()));
				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					Method m = Lhc3Stake.class.getDeclaredMethod("setTime" + entry.getKey(), int.class);
					m.invoke(stake, entry.getValue());
				}
				Map.Entry<Integer, Integer> bonusEntry = null;
				for (Map.Entry<Integer, Integer> entry : lastMap.entrySet()) {
					if (entry.getKey() == tm.getNum()) {
						bonusEntry = entry;
						break;
					}
//					Method m = Lhc3Stake.class.getDeclaredMethod("setTime" + entry.getKey(), int.class);
//					m.invoke(stake, entry.getValue());
				}
				if (bonusEntry != null) {
					stake.setLastBonus(new BigDecimal(bonusEntry.getValue()).multiply(new BigDecimal("48.5")));
					stake.setHistoryBonus(historyBonus.add(stake.getLastBonus()));
				}
				repository.save(stake);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<>(t);
	}

}
