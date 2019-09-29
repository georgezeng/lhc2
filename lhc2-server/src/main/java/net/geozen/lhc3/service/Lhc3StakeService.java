package net.geozen.lhc3.service;

import java.lang.reflect.Method;
import java.math.BigDecimal;
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
	public Future<Exception> cal(List<Lhc3Tm> tmList, String type, int tables) {
		Exception t = null;
		try {
			for (Lhc3Tm tm : tmList) {
				Map<Integer, Integer> map = new HashMap<>();
				for (int i = 1; i < 50; i++) {
					map.put(i, 0);
				}
				int count = 0;
				for (int i = 1; i <= tables; i++) {
					Optional<Lhc3PickNum> op = pickNumRepository.findFirstByExpectedAndTypeAndPhaseLessThanOrderByPhaseDesc(i, type, tm.getPhase());
					if (op.isPresent()) {
						Lhc3PickNum lastPn = op.get();
						List<String> time0Nums = Arrays.asList(lastPn.getTime0().split(","));
						for (int j = 1; j < 50; j++) {
							if (!time0Nums.contains(j + "")) {
								map.put(j, map.get(j) + 1);
								count++;
							}
						}
					}
				}
				Lhc3Stake stake = new Lhc3Stake();
				stake.setNum(tm.getNum());
				stake.setPhase(tm.getPhase());
				stake.setCurrentAmount(new BigDecimal(count));
				stake.setHistoryAmount(stake.getHistoryAmount().add(stake.getCurrentAmount()));
				Map.Entry<Integer, Integer> bonusEntry = null;
				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					if (entry.getKey() == tm.getNum()) {
						bonusEntry = entry;
					}
					Method m = Lhc3Stake.class.getDeclaredMethod("setTime" + entry.getKey(), Integer.class);
					m.invoke(stake, entry.getValue());
				}
				if (bonusEntry != null) {
					stake.setLastBonus(new BigDecimal(bonusEntry.getValue()).multiply(new BigDecimal("48.5")));
					stake.setHistoryBonus(stake.getHistoryBonus().add(stake.getLastBonus()));
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
