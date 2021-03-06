package net.geozen.lhc3.service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.geozen.lhc2.dto.PickNumCountInfo;
import net.geozen.lhc2.dto.PickNumPayload;
import net.geozen.lhc3.domain.Lhc3ColorYz;
import net.geozen.lhc3.domain.Lhc3ColorYz2;
import net.geozen.lhc3.domain.Lhc3PickNum;
import net.geozen.lhc3.domain.Lhc3TimesYz;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.jpa.Lhc3ColorYz2Repository;
import net.geozen.lhc3.jpa.Lhc3ColorYzRepository;
import net.geozen.lhc3.jpa.Lhc3PickNumRepository;
import net.geozen.lhc3.jpa.Lhc3TimesYzRepository;

@Service
public class Lhc3TimesColorService {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private Lhc3TimesYzRepository timesYzRepository;

	@Autowired
	private Lhc3ColorYzRepository colorYzRepository;

	@Autowired
	private Lhc3ColorYz2Repository colorYz2Repository;

	@Autowired
	private Lhc3PickNumRepository pickNumRepository;

	@Autowired
	private ObjectMapper mapper;

	@Async
	public Future<Exception> cal(List<Lhc3Tm> tmList, int tables, String type) {
		Exception t = null;
		try {
			for (Lhc3Tm tm : tmList) {
				Optional<Lhc3PickNum> prevPnOp = pickNumRepository.findFirstByExpectedAndTypeAndPhaseLessThanOrderByPhaseDesc(tables, type, tm.getPhase());
				if (prevPnOp.isPresent()) {
					Optional<Lhc3PickNum> pnOp = pickNumRepository.findByExpectedAndTypeAndPhase(tables, type, tm.getPhase());
					if (pnOp.isPresent()) {
						Lhc3PickNum prevNumInfo = prevPnOp.get();
						Lhc3PickNum numInfo = pnOp.get();
						Lhc3TimesYz timesYz = new Lhc3TimesYz();
						timesYz.setType(type);
						timesYz.setPhase(numInfo.getPhase());
						timesYz.setNum(numInfo.getNum());
						timesYz.setTables(tables + "");
						Lhc3ColorYz colorYz = new Lhc3ColorYz();
						colorYz.setPhase(numInfo.getPhase());
						colorYz.setTables(tables + "");
						colorYz.setType(type);
						PickNumPayload payload = mapper.readValue(prevNumInfo.getPayload(), PickNumPayload.class);
						PickNumCountInfo tmInfo = null;
						for (PickNumCountInfo info : payload.getInfos()) {
							if (numInfo.getNum() == info.getNum()) {
								tmInfo = info;
								break;
							}
						}
						String color = null;

						Optional<Lhc3TimesYz> lastTimesYzOp = timesYzRepository.findFirstByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(tables + "", type,
								tm.getPhase());
						Lhc3TimesYz lastTimesYz = lastTimesYzOp.orElseGet(Lhc3TimesYz::new);
						List<Lhc3TimesYz> lastLimitedYzList = timesYzRepository.findTop100ByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(tables + "", type,
								tm.getPhase());
						Lhc3TimesYz lastLmitedTimesYz = null;
						if (lastLimitedYzList != null && lastLimitedYzList.size() == 100) {
							lastLmitedTimesYz = lastLimitedYzList.get(99);
						}
						if (tmInfo.getCount() == 0) {
							color = "red";
							int lastLimitedCount = 0;
							if (lastLmitedTimesYz != null) {
								lastLimitedCount = lastLmitedTimesYz.getT0();
							}
							timesYz.setLt0(lastTimesYz.getT0() + 1 - lastLimitedCount);
							timesYz.setLt1(lastTimesYz.getLt1());
							timesYz.setLt2(lastTimesYz.getLt2());
							timesYz.setLt3Plus(lastTimesYz.getLt3Plus());
							timesYz.setLt1Plus(lastTimesYz.getLt1Plus());
							timesYz.setT0(lastTimesYz.getT0() + 1);
							timesYz.setT1(lastTimesYz.getT1());
							timesYz.setT2(lastTimesYz.getT2());
							timesYz.setT3Plus(lastTimesYz.getT3Plus());
							timesYz.setT1Plus(lastTimesYz.getT1Plus());
							timesYz.setTime0(0);
							timesYz.setTime1(lastTimesYz.getTime1() + 1);
							timesYz.setTime2(lastTimesYz.getTime2() + 1);
							timesYz.setTime3Plus(lastTimesYz.getTime3Plus() + 1);
							timesYz.setTime1Plus(lastTimesYz.getTime1Plus() + 1);
						} else {
							color = "green";
							timesYz.setLt0(lastTimesYz.getLt0());
							timesYz.setT0(lastTimesYz.getT0());
							timesYz.setTime0(lastTimesYz.getTime0() + 1);
							int lastLimitedCount = 0;
							if (lastLmitedTimesYz != null) {
								lastLimitedCount = lastLmitedTimesYz.getT1Plus();
							}
							timesYz.setLt1Plus(lastTimesYz.getT1Plus() + 1 - lastLimitedCount);
							timesYz.setT1Plus(lastTimesYz.getT1Plus() + 1);
							timesYz.setTime1Plus(0);
							switch (tmInfo.getCount()) {
							case 1: {
								lastLimitedCount = 0;
								if (lastLmitedTimesYz != null) {
									lastLimitedCount = lastLmitedTimesYz.getT1();
								}
								timesYz.setLt1(lastTimesYz.getT1() + 1 - lastLimitedCount);
								timesYz.setLt2(lastTimesYz.getLt2());
								timesYz.setLt3Plus(lastTimesYz.getLt3Plus());
								timesYz.setT1(lastTimesYz.getT1() + 1);
								timesYz.setT2(lastTimesYz.getT2());
								timesYz.setT3Plus(lastTimesYz.getT3Plus());
								timesYz.setTime1(0);
								timesYz.setTime2(lastTimesYz.getTime2() + 1);
								timesYz.setTime3Plus(lastTimesYz.getTime3Plus() + 1);
							}
								break;
							case 2: {
								timesYz.setLt1(lastTimesYz.getLt1());
								lastLimitedCount = 0;
								if (lastLmitedTimesYz != null) {
									lastLimitedCount = lastLmitedTimesYz.getT2();
								}
								timesYz.setLt2(lastTimesYz.getT2() + 1 - lastLimitedCount);
								timesYz.setLt3Plus(lastTimesYz.getLt3Plus());
								timesYz.setT1(lastTimesYz.getT1());
								timesYz.setT2(lastTimesYz.getT2() + 1);
								timesYz.setT3Plus(lastTimesYz.getT3Plus());
								timesYz.setTime1(lastTimesYz.getTime1() + 1);
								timesYz.setTime2(0);
								timesYz.setTime3Plus(lastTimesYz.getTime3Plus() + 1);
							}
								break;
							default: {
								timesYz.setLt1(lastTimesYz.getLt1());
								timesYz.setLt2(lastTimesYz.getLt2());
								lastLimitedCount = 0;
								if (lastLmitedTimesYz != null) {
									lastLimitedCount = lastLmitedTimesYz.getT3Plus();
								}
								timesYz.setLt3Plus(lastTimesYz.getT3Plus() + 1 - lastLimitedCount);
								timesYz.setT1(lastTimesYz.getT1());
								timesYz.setT2(lastTimesYz.getT2());
								timesYz.setT3Plus(lastTimesYz.getT3Plus() + 1);
								timesYz.setTime1(lastTimesYz.getTime1() + 1);
								timesYz.setTime2(lastTimesYz.getTime2() + 1);
								timesYz.setTime3Plus(0);
							}
							}
						}
						timesYzRepository.save(timesYz);

						Optional<Lhc3ColorYz> lastColorYzOp = colorYzRepository.findFirstByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(tables + "", type,
								tm.getPhase());
						Lhc3ColorYz lastColorYz = lastColorYzOp.orElseGet(Lhc3ColorYz::new);
						List<Lhc3ColorYz> lastLimitedColorYzList = colorYzRepository.findTop100ByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(tables + "", type,
								tm.getPhase());
						Optional<Lhc3ColorYz> lastLimitedColorYzOp = Optional.empty();
						if (lastLimitedColorYzList != null && lastLimitedColorYzList.size() == 100) {
							lastLimitedColorYzOp = Optional.of(lastLimitedColorYzList.get(99));
						}
						colorYz.setYzColor(color);
						if (color.equals(lastColorYz.getYzColor())) {
							colorYz.setYz(lastColorYz.getYz() + 1);
						} else {
							colorYz.setYz(1);
						}

						if (colorYz.getYzColor().equals("red")) {
							if ("white".equals(lastColorYz.getR1Color())) {
								colorYz.setR1(1);
							} else {
								colorYz.setR1(lastColorYz.getR1() + 1);
							}
							if ("white".equals(lastColorYz.getR2Color())) {
								colorYz.setR2(1);
							} else {
								colorYz.setR2(lastColorYz.getR2() + 1);
							}
							if ("white".equals(lastColorYz.getR3Color())) {
								colorYz.setR3(1);
							} else {
								colorYz.setR3(lastColorYz.getR3() + 1);
							}
							if ("white".equals(lastColorYz.getR4Color())) {
								colorYz.setR4(1);
							} else {
								colorYz.setR4(lastColorYz.getR4() + 1);
							}
							if ("white".equals(lastColorYz.getR5Color())) {
								colorYz.setR5(1);
							} else {
								colorYz.setR5(lastColorYz.getR5() + 1);
							}
							if ("white".equals(lastColorYz.getR6Color())) {
								colorYz.setR6(1);
							} else {
								colorYz.setR6(lastColorYz.getR6() + 1);
							}
							if ("white".equals(lastColorYz.getR7Color())) {
								colorYz.setR7(1);
							} else {
								colorYz.setR7(lastColorYz.getR7() + 1);
							}
							if ("white".equals(lastColorYz.getR8Color())) {
								colorYz.setR8(1);
							} else {
								colorYz.setR8(lastColorYz.getR8() + 1);
							}
							colorYz.setR1Color("red");
							colorYz.setR2Color("red");
							colorYz.setR3Color("red");
							colorYz.setR4Color("red");
							colorYz.setR5Color("red");
							colorYz.setR6Color("red");
							colorYz.setR7Color("red");
							colorYz.setR8Color("red");
							colorYz.setLtR1(lastColorYz.getLtR1());
							colorYz.setLtR2(lastColorYz.getLtR2());
							colorYz.setLtR3(lastColorYz.getLtR3());
							colorYz.setLtR4(lastColorYz.getLtR4());
							colorYz.setLtR5(lastColorYz.getLtR5());
							colorYz.setLtR6(lastColorYz.getLtR6());
							colorYz.setLtR7(lastColorYz.getLtR7());
							colorYz.setLtR8(lastColorYz.getLtR8());
							colorYz.settR1(lastColorYz.gettR1());
							colorYz.settR2(lastColorYz.gettR2());
							colorYz.settR3(lastColorYz.gettR3());
							colorYz.settR4(lastColorYz.gettR4());
							colorYz.settR5(lastColorYz.gettR5());
							colorYz.settR6(lastColorYz.gettR6());
							colorYz.settR7(lastColorYz.gettR7());
							colorYz.settR8(lastColorYz.gettR8());

							switch (colorYz.getYz()) {
							case 1: {
								colorYz.setG1(lastColorYz.getG1() + 1);
								colorYz.setG2(lastColorYz.getG2() + 1);
								colorYz.setG3(lastColorYz.getG3() + 1);
								colorYz.setG4(lastColorYz.getG4() + 1);
								colorYz.setG5(lastColorYz.getG5() + 1);
								colorYz.setG6(lastColorYz.getG6() + 1);
								colorYz.setG7(lastColorYz.getG7() + 1);
								colorYz.setG8(lastColorYz.getG8() + 1);
								colorYz.setG1Color("green");
								colorYz.setG2Color("green");
								colorYz.setG3Color("green");
								colorYz.setG4Color("green");
								colorYz.setG5Color("green");
								colorYz.setG6Color("green");
								colorYz.setG7Color("green");
								colorYz.setG8Color("green");
								colorYz.setLtG1(lastColorYz.getLtG1());
								colorYz.setLtG2(lastColorYz.getLtG2());
								colorYz.setLtG3(lastColorYz.getLtG3());
								colorYz.setLtG4(lastColorYz.getLtG4());
								colorYz.setLtG5(lastColorYz.getLtG5());
								colorYz.setLtG6(lastColorYz.getLtG6());
								colorYz.setLtG7(lastColorYz.getLtG7());
								colorYz.setLtG8(lastColorYz.getLtG8());
								colorYz.settG1(lastColorYz.gettG1());
								colorYz.settG2(lastColorYz.gettG2());
								colorYz.settG3(lastColorYz.gettG3());
								colorYz.settG4(lastColorYz.gettG4());
								colorYz.settG5(lastColorYz.gettG5());
								colorYz.settG6(lastColorYz.gettG6());
								colorYz.settG7(lastColorYz.gettG7());
								colorYz.settG8(lastColorYz.gettG8());
							}
								break;
							case 2: {
								colorYz.setG1(1);
								colorYz.setG2(lastColorYz.getG2() + 1);
								colorYz.setG3(lastColorYz.getG3() + 1);
								colorYz.setG4(lastColorYz.getG4() + 1);
								colorYz.setG5(lastColorYz.getG5() + 1);
								colorYz.setG6(lastColorYz.getG6() + 1);
								colorYz.setG7(lastColorYz.getG7() + 1);
								colorYz.setG8(lastColorYz.getG8() + 1);
								colorYz.setG1Color("white");
								colorYz.setG2Color("green");
								colorYz.setG3Color("green");
								colorYz.setG4Color("green");
								colorYz.setG5Color("green");
								colorYz.setG6Color("green");
								colorYz.setG7Color("green");
								colorYz.setG8Color("green");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettG1();
								}
								colorYz.setLtG1(lastColorYz.gettG1() + 1 - lastLimitedCount);
								colorYz.settG1(lastColorYz.gettG1() + 1);
								colorYz.setLtG2(lastColorYz.getLtG2());
								colorYz.setLtG3(lastColorYz.getLtG3());
								colorYz.setLtG4(lastColorYz.getLtG4());
								colorYz.setLtG5(lastColorYz.getLtG5());
								colorYz.setLtG6(lastColorYz.getLtG6());
								colorYz.setLtG7(lastColorYz.getLtG7());
								colorYz.setLtG8(lastColorYz.getLtG8());
								colorYz.settG2(lastColorYz.gettG2());
								colorYz.settG3(lastColorYz.gettG3());
								colorYz.settG4(lastColorYz.gettG4());
								colorYz.settG5(lastColorYz.gettG5());
								colorYz.settG6(lastColorYz.gettG6());
								colorYz.settG7(lastColorYz.gettG7());
								colorYz.settG8(lastColorYz.gettG8());
							}
								break;
							case 3: {
								colorYz.setG1(2);
								colorYz.setG2(1);
								colorYz.setG3(lastColorYz.getG3() + 1);
								colorYz.setG4(lastColorYz.getG4() + 1);
								colorYz.setG5(lastColorYz.getG5() + 1);
								colorYz.setG6(lastColorYz.getG6() + 1);
								colorYz.setG7(lastColorYz.getG7() + 1);
								colorYz.setG8(lastColorYz.getG8() + 1);
								colorYz.setG1Color("white");
								colorYz.setG2Color("white");
								colorYz.setG3Color("green");
								colorYz.setG4Color("green");
								colorYz.setG5Color("green");
								colorYz.setG6Color("green");
								colorYz.setG7Color("green");
								colorYz.setG8Color("green");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettG2();
								}
								colorYz.setLtG2(lastColorYz.gettG2() + 1 - lastLimitedCount);
								colorYz.settG2(lastColorYz.gettG2() + 1);
								colorYz.setLtG1(lastColorYz.getLtG1());
								colorYz.setLtG3(lastColorYz.getLtG3());
								colorYz.setLtG4(lastColorYz.getLtG4());
								colorYz.setLtG5(lastColorYz.getLtG5());
								colorYz.setLtG6(lastColorYz.getLtG6());
								colorYz.setLtG7(lastColorYz.getLtG7());
								colorYz.setLtG8(lastColorYz.getLtG8());
								colorYz.settG1(lastColorYz.gettG1());
								colorYz.settG3(lastColorYz.gettG3());
								colorYz.settG4(lastColorYz.gettG4());
								colorYz.settG5(lastColorYz.gettG5());
								colorYz.settG6(lastColorYz.gettG6());
								colorYz.settG7(lastColorYz.gettG7());
								colorYz.settG8(lastColorYz.gettG8());
							}
								break;
							case 4: {
								colorYz.setG1(3);
								colorYz.setG2(2);
								colorYz.setG3(1);
								colorYz.setG4(lastColorYz.getG4() + 1);
								colorYz.setG5(lastColorYz.getG5() + 1);
								colorYz.setG6(lastColorYz.getG6() + 1);
								colorYz.setG7(lastColorYz.getG7() + 1);
								colorYz.setG8(lastColorYz.getG8() + 1);
								colorYz.setG1Color("white");
								colorYz.setG2Color("white");
								colorYz.setG3Color("white");
								colorYz.setG4Color("green");
								colorYz.setG5Color("green");
								colorYz.setG6Color("green");
								colorYz.setG7Color("green");
								colorYz.setG8Color("green");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettG3();
								}
								colorYz.setLtG3(lastColorYz.gettG3() + 1 - lastLimitedCount);
								colorYz.settG3(lastColorYz.gettG3() + 1);
								colorYz.setLtG1(lastColorYz.getLtG1());
								colorYz.setLtG2(lastColorYz.getLtG2());
								colorYz.setLtG4(lastColorYz.getLtG4());
								colorYz.setLtG5(lastColorYz.getLtG5());
								colorYz.setLtG6(lastColorYz.getLtG6());
								colorYz.setLtG7(lastColorYz.getLtG7());
								colorYz.setLtG8(lastColorYz.getLtG8());
								colorYz.settG1(lastColorYz.gettG1());
								colorYz.settG2(lastColorYz.gettG2());
								colorYz.settG4(lastColorYz.gettG4());
								colorYz.settG5(lastColorYz.gettG5());
								colorYz.settG6(lastColorYz.gettG6());
								colorYz.settG7(lastColorYz.gettG7());
								colorYz.settG8(lastColorYz.gettG8());
							}
								break;
							case 5: {
								colorYz.setG1(4);
								colorYz.setG2(3);
								colorYz.setG3(2);
								colorYz.setG4(1);
								colorYz.setG5(lastColorYz.getG5() + 1);
								colorYz.setG6(lastColorYz.getG6() + 1);
								colorYz.setG7(lastColorYz.getG7() + 1);
								colorYz.setG8(lastColorYz.getG8() + 1);
								colorYz.setG1Color("white");
								colorYz.setG2Color("white");
								colorYz.setG3Color("white");
								colorYz.setG4Color("white");
								colorYz.setG5Color("green");
								colorYz.setG6Color("green");
								colorYz.setG7Color("green");
								colorYz.setG8Color("green");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettG4();
								}
								colorYz.setLtG4(lastColorYz.gettG4() + 1 - lastLimitedCount);
								colorYz.settG4(lastColorYz.gettG4() + 1);
								colorYz.setLtG1(lastColorYz.getLtG1());
								colorYz.setLtG2(lastColorYz.getLtG2());
								colorYz.setLtG3(lastColorYz.getLtG3());
								colorYz.setLtG5(lastColorYz.getLtG5());
								colorYz.setLtG6(lastColorYz.getLtG6());
								colorYz.setLtG7(lastColorYz.getLtG7());
								colorYz.setLtG8(lastColorYz.getLtG8());
								colorYz.settG1(lastColorYz.gettG1());
								colorYz.settG2(lastColorYz.gettG2());
								colorYz.settG3(lastColorYz.gettG3());
								colorYz.settG5(lastColorYz.gettG5());
								colorYz.settG6(lastColorYz.gettG6());
								colorYz.settG7(lastColorYz.gettG7());
								colorYz.settG8(lastColorYz.gettG8());
							}
								break;
							case 6: {
								colorYz.setG1(5);
								colorYz.setG2(4);
								colorYz.setG3(3);
								colorYz.setG4(2);
								colorYz.setG5(1);
								colorYz.setG6(lastColorYz.getG6() + 1);
								colorYz.setG7(lastColorYz.getG7() + 1);
								colorYz.setG8(lastColorYz.getG8() + 1);
								colorYz.setG1Color("white");
								colorYz.setG2Color("white");
								colorYz.setG3Color("white");
								colorYz.setG4Color("white");
								colorYz.setG5Color("white");
								colorYz.setG6Color("green");
								colorYz.setG7Color("green");
								colorYz.setG8Color("green");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettG5();
								}
								colorYz.setLtG5(lastColorYz.gettG5() + 1 - lastLimitedCount);
								colorYz.settG5(lastColorYz.gettG5() + 1);
								colorYz.setLtG1(lastColorYz.getLtG1());
								colorYz.setLtG2(lastColorYz.getLtG2());
								colorYz.setLtG3(lastColorYz.getLtG3());
								colorYz.setLtG4(lastColorYz.getLtG4());
								colorYz.setLtG6(lastColorYz.getLtG6());
								colorYz.setLtG7(lastColorYz.getLtG7());
								colorYz.setLtG8(lastColorYz.getLtG8());
								colorYz.settG1(lastColorYz.gettG1());
								colorYz.settG2(lastColorYz.gettG2());
								colorYz.settG3(lastColorYz.gettG3());
								colorYz.settG4(lastColorYz.gettG4());
								colorYz.settG6(lastColorYz.gettG6());
								colorYz.settG7(lastColorYz.gettG7());
								colorYz.settG8(lastColorYz.gettG8());
							}
								break;
							case 7: {
								colorYz.setG1(6);
								colorYz.setG2(5);
								colorYz.setG3(4);
								colorYz.setG4(3);
								colorYz.setG5(2);
								colorYz.setG6(1);
								colorYz.setG7(lastColorYz.getG7() + 1);
								colorYz.setG8(lastColorYz.getG8() + 1);
								colorYz.setG1Color("white");
								colorYz.setG2Color("white");
								colorYz.setG3Color("white");
								colorYz.setG4Color("white");
								colorYz.setG5Color("white");
								colorYz.setG6Color("white");
								colorYz.setG7Color("green");
								colorYz.setG8Color("green");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettG6();
								}
								colorYz.setLtG6(lastColorYz.gettG6() + 1 - lastLimitedCount);
								colorYz.settG6(lastColorYz.gettG6() + 1);
								colorYz.setLtG1(lastColorYz.getLtG1());
								colorYz.setLtG2(lastColorYz.getLtG2());
								colorYz.setLtG3(lastColorYz.getLtG3());
								colorYz.setLtG4(lastColorYz.getLtG4());
								colorYz.setLtG5(lastColorYz.getLtG5());
								colorYz.setLtG7(lastColorYz.getLtG7());
								colorYz.setLtG8(lastColorYz.getLtG8());
								colorYz.settG1(lastColorYz.gettG1());
								colorYz.settG2(lastColorYz.gettG2());
								colorYz.settG3(lastColorYz.gettG3());
								colorYz.settG4(lastColorYz.gettG4());
								colorYz.settG5(lastColorYz.gettG5());
								colorYz.settG7(lastColorYz.gettG7());
								colorYz.settG8(lastColorYz.gettG8());
							}
								break;
							case 8: {
								colorYz.setG1(7);
								colorYz.setG2(6);
								colorYz.setG3(5);
								colorYz.setG4(4);
								colorYz.setG5(3);
								colorYz.setG6(2);
								colorYz.setG7(1);
								colorYz.setG8(lastColorYz.getG8() + 1);
								colorYz.setG1Color("white");
								colorYz.setG2Color("white");
								colorYz.setG3Color("white");
								colorYz.setG4Color("white");
								colorYz.setG5Color("white");
								colorYz.setG6Color("white");
								colorYz.setG7Color("white");
								colorYz.setG8Color("green");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettG7();
								}
								colorYz.setLtG7(lastColorYz.gettG7() + 1 - lastLimitedCount);
								colorYz.settG7(lastColorYz.gettG7() + 1);
								colorYz.setLtG1(lastColorYz.getLtG1());
								colorYz.setLtG2(lastColorYz.getLtG2());
								colorYz.setLtG3(lastColorYz.getLtG3());
								colorYz.setLtG4(lastColorYz.getLtG4());
								colorYz.setLtG5(lastColorYz.getLtG5());
								colorYz.setLtG6(lastColorYz.getLtG6());
								colorYz.setLtG8(lastColorYz.getLtG8());
								colorYz.settG1(lastColorYz.gettG1());
								colorYz.settG2(lastColorYz.gettG2());
								colorYz.settG3(lastColorYz.gettG3());
								colorYz.settG4(lastColorYz.gettG4());
								colorYz.settG5(lastColorYz.gettG5());
								colorYz.settG6(lastColorYz.gettG6());
								colorYz.settG8(lastColorYz.gettG8());
							}
								break;
							case 9: {
								colorYz.setG1(8);
								colorYz.setG2(7);
								colorYz.setG3(6);
								colorYz.setG4(5);
								colorYz.setG5(4);
								colorYz.setG6(3);
								colorYz.setG7(2);
								colorYz.setG8(1);
								colorYz.setG1Color("white");
								colorYz.setG2Color("white");
								colorYz.setG3Color("white");
								colorYz.setG4Color("white");
								colorYz.setG5Color("white");
								colorYz.setG6Color("white");
								colorYz.setG7Color("white");
								colorYz.setG8Color("white");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettG8();
								}
								colorYz.setLtG8(lastColorYz.gettG8() + 1 - lastLimitedCount);
								colorYz.settG8(lastColorYz.gettG8() + 1);
								colorYz.setLtG1(lastColorYz.getLtG1());
								colorYz.setLtG2(lastColorYz.getLtG2());
								colorYz.setLtG3(lastColorYz.getLtG3());
								colorYz.setLtG4(lastColorYz.getLtG4());
								colorYz.setLtG5(lastColorYz.getLtG5());
								colorYz.setLtG6(lastColorYz.getLtG6());
								colorYz.setLtG7(lastColorYz.getLtG7());
								colorYz.settG1(lastColorYz.gettG1());
								colorYz.settG2(lastColorYz.gettG2());
								colorYz.settG3(lastColorYz.gettG3());
								colorYz.settG4(lastColorYz.gettG4());
								colorYz.settG5(lastColorYz.gettG5());
								colorYz.settG6(lastColorYz.gettG6());
								colorYz.settG7(lastColorYz.gettG7());
							}
								break;
							default: {
								colorYz.setG1(lastColorYz.getG1() + 1);
								colorYz.setG2(lastColorYz.getG2() + 1);
								colorYz.setG3(lastColorYz.getG3() + 1);
								colorYz.setG4(lastColorYz.getG4() + 1);
								colorYz.setG5(lastColorYz.getG5() + 1);
								colorYz.setG6(lastColorYz.getG6() + 1);
								colorYz.setG7(lastColorYz.getG7() + 1);
								colorYz.setG8(lastColorYz.getG8() + 1);
								colorYz.setG1Color("white");
								colorYz.setG2Color("white");
								colorYz.setG3Color("white");
								colorYz.setG4Color("white");
								colorYz.setG5Color("white");
								colorYz.setG6Color("white");
								colorYz.setG7Color("white");
								colorYz.setG8Color("white");
								colorYz.setLtG1(lastColorYz.getLtG1());
								colorYz.setLtG2(lastColorYz.getLtG2());
								colorYz.setLtG3(lastColorYz.getLtG3());
								colorYz.setLtG4(lastColorYz.getLtG4());
								colorYz.setLtG5(lastColorYz.getLtG5());
								colorYz.setLtG6(lastColorYz.getLtG6());
								colorYz.setLtG7(lastColorYz.getLtG7());
								colorYz.setLtG8(lastColorYz.getLtG8());
								colorYz.settG1(lastColorYz.gettG1());
								colorYz.settG2(lastColorYz.gettG2());
								colorYz.settG3(lastColorYz.gettG3());
								colorYz.settG4(lastColorYz.gettG4());
								colorYz.settG5(lastColorYz.gettG5());
								colorYz.settG6(lastColorYz.gettG6());
								colorYz.settG7(lastColorYz.gettG7());
								colorYz.settG8(lastColorYz.gettG8());
//								int lastLimitedCount = 0;
//								if (colorYz.getG1() == 1) {
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettG1();
//									}
//									colorYz.setLtG1(lastColorYz.gettG1() + 1 - lastLimitedCount);
//									colorYz.settG1(lastColorYz.gettG1() + 1);
//									colorYz.setLtG2(lastColorYz.getLtG2());
//									colorYz.setLtG3(lastColorYz.getLtG3());
//									colorYz.setLtG4(lastColorYz.getLtG4());
//									colorYz.setLtG5(lastColorYz.getLtG5());
//									colorYz.setLtG6(lastColorYz.getLtG6());
//									colorYz.setLtG7(lastColorYz.getLtG7());
//									colorYz.setLtG8(lastColorYz.getLtG8());
//									colorYz.settG2(lastColorYz.gettG2());
//									colorYz.settG3(lastColorYz.gettG3());
//									colorYz.settG4(lastColorYz.gettG4());
//									colorYz.settG5(lastColorYz.gettG5());
//									colorYz.settG6(lastColorYz.gettG6());
//									colorYz.settG7(lastColorYz.gettG7());
//									colorYz.settG8(lastColorYz.gettG8());
//								} else if (colorYz.getG2() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettG2();
//									}
//									colorYz.setLtG2(lastColorYz.gettG2() + 1 - lastLimitedCount);
//									colorYz.settG2(lastColorYz.gettG2() + 1);
//									colorYz.setLtG1(lastColorYz.getLtG1());
//									colorYz.setLtG3(lastColorYz.getLtG3());
//									colorYz.setLtG4(lastColorYz.getLtG4());
//									colorYz.setLtG5(lastColorYz.getLtG5());
//									colorYz.setLtG6(lastColorYz.getLtG6());
//									colorYz.setLtG7(lastColorYz.getLtG7());
//									colorYz.setLtG8(lastColorYz.getLtG8());
//									colorYz.settG1(lastColorYz.gettG1());
//									colorYz.settG3(lastColorYz.gettG3());
//									colorYz.settG4(lastColorYz.gettG4());
//									colorYz.settG5(lastColorYz.gettG5());
//									colorYz.settG6(lastColorYz.gettG6());
//									colorYz.settG7(lastColorYz.gettG7());
//									colorYz.settG8(lastColorYz.gettG8());
//								} else if (colorYz.getG3() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettG3();
//									}
//									colorYz.setLtG3(lastColorYz.gettG3() + 1 - lastLimitedCount);
//									colorYz.settG3(lastColorYz.gettG3() + 1);
//									colorYz.setLtG1(lastColorYz.getLtG1());
//									colorYz.setLtG2(lastColorYz.getLtG2());
//									colorYz.setLtG4(lastColorYz.getLtG4());
//									colorYz.setLtG5(lastColorYz.getLtG5());
//									colorYz.setLtG6(lastColorYz.getLtG6());
//									colorYz.setLtG7(lastColorYz.getLtG7());
//									colorYz.setLtG8(lastColorYz.getLtG8());
//									colorYz.settG1(lastColorYz.gettG1());
//									colorYz.settG2(lastColorYz.gettG2());
//									colorYz.settG4(lastColorYz.gettG4());
//									colorYz.settG5(lastColorYz.gettG5());
//									colorYz.settG6(lastColorYz.gettG6());
//									colorYz.settG7(lastColorYz.gettG7());
//									colorYz.settG8(lastColorYz.gettG8());
//								} else if (colorYz.getG4() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettG4();
//									}
//									colorYz.setLtG4(lastColorYz.gettG4() + 1 - lastLimitedCount);
//									colorYz.settG4(lastColorYz.gettG4() + 1);
//									colorYz.setLtG1(lastColorYz.getLtG1());
//									colorYz.setLtG2(lastColorYz.getLtG2());
//									colorYz.setLtG3(lastColorYz.getLtG3());
//									colorYz.setLtG5(lastColorYz.getLtG5());
//									colorYz.setLtG6(lastColorYz.getLtG6());
//									colorYz.setLtG7(lastColorYz.getLtG7());
//									colorYz.setLtG8(lastColorYz.getLtG8());
//									colorYz.settG1(lastColorYz.gettG1());
//									colorYz.settG2(lastColorYz.gettG2());
//									colorYz.settG3(lastColorYz.gettG3());
//									colorYz.settG5(lastColorYz.gettG5());
//									colorYz.settG6(lastColorYz.gettG6());
//									colorYz.settG7(lastColorYz.gettG7());
//									colorYz.settG8(lastColorYz.gettG8());
//								} else if (colorYz.getG5() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettG5();
//									}
//									colorYz.setLtG5(lastColorYz.gettG5() + 1 - lastLimitedCount);
//									colorYz.settG5(lastColorYz.gettG5() + 1);
//									colorYz.setLtG1(lastColorYz.getLtG1());
//									colorYz.setLtG2(lastColorYz.getLtG2());
//									colorYz.setLtG3(lastColorYz.getLtG3());
//									colorYz.setLtG4(lastColorYz.getLtG4());
//									colorYz.setLtG6(lastColorYz.getLtG6());
//									colorYz.setLtG7(lastColorYz.getLtG7());
//									colorYz.setLtG8(lastColorYz.getLtG8());
//									colorYz.settG1(lastColorYz.gettG1());
//									colorYz.settG2(lastColorYz.gettG2());
//									colorYz.settG3(lastColorYz.gettG3());
//									colorYz.settG4(lastColorYz.gettG4());
//									colorYz.settG6(lastColorYz.gettG6());
//									colorYz.settG7(lastColorYz.gettG7());
//									colorYz.settG8(lastColorYz.gettG8());
//								} else if (colorYz.getG6() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettG6();
//									}
//									colorYz.setLtG6(lastColorYz.gettG6() + 1 - lastLimitedCount);
//									colorYz.settG6(lastColorYz.gettG6() + 1);
//									colorYz.setLtG1(lastColorYz.getLtG1());
//									colorYz.setLtG2(lastColorYz.getLtG2());
//									colorYz.setLtG3(lastColorYz.getLtG3());
//									colorYz.setLtG4(lastColorYz.getLtG4());
//									colorYz.setLtG5(lastColorYz.getLtG5());
//									colorYz.setLtG7(lastColorYz.getLtG7());
//									colorYz.setLtG8(lastColorYz.getLtG8());
//									colorYz.settG1(lastColorYz.gettG1());
//									colorYz.settG2(lastColorYz.gettG2());
//									colorYz.settG3(lastColorYz.gettG3());
//									colorYz.settG4(lastColorYz.gettG4());
//									colorYz.settG5(lastColorYz.gettG5());
//									colorYz.settG7(lastColorYz.gettG7());
//									colorYz.settG8(lastColorYz.gettG8());
//								} else if (colorYz.getG7() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettG7();
//									}
//									colorYz.setLtG7(lastColorYz.gettG7() + 1 - lastLimitedCount);
//									colorYz.settG7(lastColorYz.gettG7() + 1);
//									colorYz.setLtG1(lastColorYz.getLtG1());
//									colorYz.setLtG2(lastColorYz.getLtG2());
//									colorYz.setLtG3(lastColorYz.getLtG3());
//									colorYz.setLtG4(lastColorYz.getLtG4());
//									colorYz.setLtG5(lastColorYz.getLtG5());
//									colorYz.setLtG6(lastColorYz.getLtG6());
//									colorYz.setLtG8(lastColorYz.getLtG8());
//									colorYz.settG1(lastColorYz.gettG1());
//									colorYz.settG2(lastColorYz.gettG2());
//									colorYz.settG3(lastColorYz.gettG3());
//									colorYz.settG4(lastColorYz.gettG4());
//									colorYz.settG5(lastColorYz.gettG5());
//									colorYz.settG6(lastColorYz.gettG6());
//									colorYz.settG8(lastColorYz.gettG8());
//								} else if (colorYz.getG8() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettG8();
//									}
//									colorYz.setLtG8(lastColorYz.gettG8() + 1 - lastLimitedCount);
//									colorYz.settG8(lastColorYz.gettG8() + 1);
//									colorYz.setLtG1(lastColorYz.getLtG1());
//									colorYz.setLtG2(lastColorYz.getLtG2());
//									colorYz.setLtG3(lastColorYz.getLtG3());
//									colorYz.setLtG4(lastColorYz.getLtG4());
//									colorYz.setLtG5(lastColorYz.getLtG5());
//									colorYz.setLtG6(lastColorYz.getLtG6());
//									colorYz.setLtG7(lastColorYz.getLtG7());
//									colorYz.settG1(lastColorYz.gettG1());
//									colorYz.settG2(lastColorYz.gettG2());
//									colorYz.settG3(lastColorYz.gettG3());
//									colorYz.settG4(lastColorYz.gettG4());
//									colorYz.settG5(lastColorYz.gettG5());
//									colorYz.settG6(lastColorYz.gettG6());
//									colorYz.settG7(lastColorYz.gettG7());
//								}
							}
							}
						} else {
							if ("white".equals(lastColorYz.getG1Color())) {
								colorYz.setG1(1);
							} else {
								colorYz.setG1(lastColorYz.getG1() + 1);
							}
							if ("white".equals(lastColorYz.getG2Color())) {
								colorYz.setG2(1);
							} else {
								colorYz.setG2(lastColorYz.getG2() + 1);
							}
							if ("white".equals(lastColorYz.getG3Color())) {
								colorYz.setG3(1);
							} else {
								colorYz.setG3(lastColorYz.getG3() + 1);
							}
							if ("white".equals(lastColorYz.getG4Color())) {
								colorYz.setG4(1);
							} else {
								colorYz.setG4(lastColorYz.getG4() + 1);
							}
							if ("white".equals(lastColorYz.getG5Color())) {
								colorYz.setG5(1);
							} else {
								colorYz.setG5(lastColorYz.getG5() + 1);
							}
							if ("white".equals(lastColorYz.getG6Color())) {
								colorYz.setG6(1);
							} else {
								colorYz.setG6(lastColorYz.getG6() + 1);
							}
							if ("white".equals(lastColorYz.getG7Color())) {
								colorYz.setG7(1);
							} else {
								colorYz.setG7(lastColorYz.getG7() + 1);
							}
							if ("white".equals(lastColorYz.getG8Color())) {
								colorYz.setG8(1);
							} else {
								colorYz.setG8(lastColorYz.getG8() + 1);
							}
							colorYz.setG1Color("green");
							colorYz.setG2Color("green");
							colorYz.setG3Color("green");
							colorYz.setG4Color("green");
							colorYz.setG5Color("green");
							colorYz.setG6Color("green");
							colorYz.setG7Color("green");
							colorYz.setG8Color("green");
							colorYz.setLtG1(lastColorYz.getLtG1());
							colorYz.setLtG2(lastColorYz.getLtG2());
							colorYz.setLtG3(lastColorYz.getLtG3());
							colorYz.setLtG4(lastColorYz.getLtG4());
							colorYz.setLtG5(lastColorYz.getLtG5());
							colorYz.setLtG6(lastColorYz.getLtG6());
							colorYz.setLtG7(lastColorYz.getLtG7());
							colorYz.setLtG8(lastColorYz.getLtG8());
							colorYz.settG1(lastColorYz.gettG1());
							colorYz.settG2(lastColorYz.gettG2());
							colorYz.settG3(lastColorYz.gettG3());
							colorYz.settG4(lastColorYz.gettG4());
							colorYz.settG5(lastColorYz.gettG5());
							colorYz.settG6(lastColorYz.gettG6());
							colorYz.settG7(lastColorYz.gettG7());
							colorYz.settG8(lastColorYz.gettG8());

							switch (colorYz.getYz()) {
							case 1: {
								colorYz.setR1(lastColorYz.getR1() + 1);
								colorYz.setR2(lastColorYz.getR2() + 1);
								colorYz.setR3(lastColorYz.getR3() + 1);
								colorYz.setR4(lastColorYz.getR4() + 1);
								colorYz.setR5(lastColorYz.getR5() + 1);
								colorYz.setR6(lastColorYz.getR6() + 1);
								colorYz.setR7(lastColorYz.getR7() + 1);
								colorYz.setR8(lastColorYz.getR8() + 1);
								colorYz.setR1Color("red");
								colorYz.setR2Color("red");
								colorYz.setR3Color("red");
								colorYz.setR4Color("red");
								colorYz.setR5Color("red");
								colorYz.setR6Color("red");
								colorYz.setR7Color("red");
								colorYz.setR8Color("red");
								colorYz.setLtR1(lastColorYz.getLtR1());
								colorYz.setLtR2(lastColorYz.getLtR2());
								colorYz.setLtR3(lastColorYz.getLtR3());
								colorYz.setLtR4(lastColorYz.getLtR4());
								colorYz.setLtR5(lastColorYz.getLtR5());
								colorYz.setLtR6(lastColorYz.getLtR6());
								colorYz.setLtR7(lastColorYz.getLtR7());
								colorYz.setLtR8(lastColorYz.getLtR8());
								colorYz.settR1(lastColorYz.gettR1());
								colorYz.settR2(lastColorYz.gettR2());
								colorYz.settR3(lastColorYz.gettR3());
								colorYz.settR4(lastColorYz.gettR4());
								colorYz.settR5(lastColorYz.gettR5());
								colorYz.settR6(lastColorYz.gettR6());
								colorYz.settR7(lastColorYz.gettR7());
								colorYz.settR8(lastColorYz.gettR8());
							}
								break;
							case 2: {
								colorYz.setR1(1);
								colorYz.setR2(lastColorYz.getR2() + 1);
								colorYz.setR3(lastColorYz.getR3() + 1);
								colorYz.setR4(lastColorYz.getR4() + 1);
								colorYz.setR5(lastColorYz.getR5() + 1);
								colorYz.setR6(lastColorYz.getR6() + 1);
								colorYz.setR7(lastColorYz.getR7() + 1);
								colorYz.setR8(lastColorYz.getR8() + 1);
								colorYz.setR1Color("white");
								colorYz.setR2Color("red");
								colorYz.setR3Color("red");
								colorYz.setR4Color("red");
								colorYz.setR5Color("red");
								colorYz.setR6Color("red");
								colorYz.setR7Color("red");
								colorYz.setR8Color("red");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettR1();
								}
								colorYz.setLtR1(lastColorYz.gettR1() + 1 - lastLimitedCount);
								colorYz.settR1(lastColorYz.gettR1() + 1);
								colorYz.setLtR2(lastColorYz.getLtR2());
								colorYz.setLtR3(lastColorYz.getLtR3());
								colorYz.setLtR4(lastColorYz.getLtR4());
								colorYz.setLtR5(lastColorYz.getLtR5());
								colorYz.setLtR6(lastColorYz.getLtR6());
								colorYz.setLtR7(lastColorYz.getLtR7());
								colorYz.setLtR8(lastColorYz.getLtR8());
								colorYz.settR2(lastColorYz.gettR2());
								colorYz.settR3(lastColorYz.gettR3());
								colorYz.settR4(lastColorYz.gettR4());
								colorYz.settR5(lastColorYz.gettR5());
								colorYz.settR6(lastColorYz.gettR6());
								colorYz.settR7(lastColorYz.gettR7());
								colorYz.settR8(lastColorYz.gettR8());
							}
								break;
							case 3: {
								colorYz.setR1(2);
								colorYz.setR2(1);
								colorYz.setR3(lastColorYz.getR3() + 1);
								colorYz.setR4(lastColorYz.getR4() + 1);
								colorYz.setR5(lastColorYz.getR5() + 1);
								colorYz.setR6(lastColorYz.getR6() + 1);
								colorYz.setR7(lastColorYz.getR7() + 1);
								colorYz.setR8(lastColorYz.getR8() + 1);
								colorYz.setR1Color("white");
								colorYz.setR2Color("white");
								colorYz.setR3Color("red");
								colorYz.setR4Color("red");
								colorYz.setR5Color("red");
								colorYz.setR6Color("red");
								colorYz.setR7Color("red");
								colorYz.setR8Color("red");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettR2();
								}
								colorYz.setLtR2(lastColorYz.gettR2() + 1 - lastLimitedCount);
								colorYz.settR2(lastColorYz.gettR2() + 1);
								colorYz.setLtR1(lastColorYz.getLtR1());
								colorYz.setLtR3(lastColorYz.getLtR3());
								colorYz.setLtR4(lastColorYz.getLtR4());
								colorYz.setLtR5(lastColorYz.getLtR5());
								colorYz.setLtR6(lastColorYz.getLtR6());
								colorYz.setLtR7(lastColorYz.getLtR7());
								colorYz.setLtR8(lastColorYz.getLtR8());
								colorYz.settR1(lastColorYz.gettR1());
								colorYz.settR3(lastColorYz.gettR3());
								colorYz.settR4(lastColorYz.gettR4());
								colorYz.settR5(lastColorYz.gettR5());
								colorYz.settR6(lastColorYz.gettR6());
								colorYz.settR7(lastColorYz.gettR7());
								colorYz.settR8(lastColorYz.gettR8());
							}
								break;
							case 4: {
								colorYz.setR1(3);
								colorYz.setR2(2);
								colorYz.setR3(1);
								colorYz.setR4(lastColorYz.getR4() + 1);
								colorYz.setR5(lastColorYz.getR5() + 1);
								colorYz.setR6(lastColorYz.getR6() + 1);
								colorYz.setR7(lastColorYz.getR7() + 1);
								colorYz.setR8(lastColorYz.getR8() + 1);
								colorYz.setR1Color("white");
								colorYz.setR2Color("white");
								colorYz.setR3Color("white");
								colorYz.setR4Color("red");
								colorYz.setR5Color("red");
								colorYz.setR6Color("red");
								colorYz.setR7Color("red");
								colorYz.setR8Color("red");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettR3();
								}
								colorYz.setLtR3(lastColorYz.gettR3() + 1 - lastLimitedCount);
								colorYz.settR3(lastColorYz.gettR3() + 1);
								colorYz.setLtR1(lastColorYz.getLtR1());
								colorYz.setLtR2(lastColorYz.getLtR2());
								colorYz.setLtR4(lastColorYz.getLtR4());
								colorYz.setLtR5(lastColorYz.getLtR5());
								colorYz.setLtR6(lastColorYz.getLtR6());
								colorYz.setLtR7(lastColorYz.getLtR7());
								colorYz.setLtR8(lastColorYz.getLtR8());
								colorYz.settR1(lastColorYz.gettR1());
								colorYz.settR2(lastColorYz.gettR2());
								colorYz.settR4(lastColorYz.gettR4());
								colorYz.settR5(lastColorYz.gettR5());
								colorYz.settR6(lastColorYz.gettR6());
								colorYz.settR7(lastColorYz.gettR7());
								colorYz.settR8(lastColorYz.gettR8());
							}
								break;
							case 5: {
								colorYz.setR1(4);
								colorYz.setR2(3);
								colorYz.setR3(2);
								colorYz.setR4(1);
								colorYz.setR5(lastColorYz.getR5() + 1);
								colorYz.setR6(lastColorYz.getR6() + 1);
								colorYz.setR7(lastColorYz.getR7() + 1);
								colorYz.setR8(lastColorYz.getR8() + 1);
								colorYz.setWrColor("red");
								colorYz.setWr(colorYz.getWr() + 1);
								colorYz.setR1Color("white");
								colorYz.setR2Color("white");
								colorYz.setR3Color("white");
								colorYz.setR4Color("white");
								colorYz.setR5Color("red");
								colorYz.setR6Color("red");
								colorYz.setR7Color("red");
								colorYz.setR8Color("red");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettR4();
								}
								colorYz.setLtR4(lastColorYz.gettR4() + 1 - lastLimitedCount);
								colorYz.settR4(lastColorYz.gettR4() + 1);
								colorYz.setLtR1(lastColorYz.getLtR1());
								colorYz.setLtR2(lastColorYz.getLtR2());
								colorYz.setLtR3(lastColorYz.getLtR3());
								colorYz.setLtR5(lastColorYz.getLtR5());
								colorYz.setLtR6(lastColorYz.getLtR6());
								colorYz.setLtR7(lastColorYz.getLtR7());
								colorYz.setLtR8(lastColorYz.getLtR8());
								colorYz.settR1(lastColorYz.gettR1());
								colorYz.settR2(lastColorYz.gettR2());
								colorYz.settR3(lastColorYz.gettR3());
								colorYz.settR5(lastColorYz.gettR5());
								colorYz.settR6(lastColorYz.gettR6());
								colorYz.settR7(lastColorYz.gettR7());
								colorYz.settR8(lastColorYz.gettR8());
							}
								break;
							case 6: {
								colorYz.setR1(5);
								colorYz.setR2(4);
								colorYz.setR3(3);
								colorYz.setR4(2);
								colorYz.setR5(1);
								colorYz.setR6(lastColorYz.getR6() + 1);
								colorYz.setR7(lastColorYz.getR7() + 1);
								colorYz.setR8(lastColorYz.getR8() + 1);
								colorYz.setR1Color("white");
								colorYz.setR2Color("white");
								colorYz.setR3Color("white");
								colorYz.setR4Color("white");
								colorYz.setR5Color("white");
								colorYz.setR6Color("red");
								colorYz.setR7Color("red");
								colorYz.setR8Color("red");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettR5();
								}
								colorYz.setLtR5(lastColorYz.gettR5() + 1 - lastLimitedCount);
								colorYz.settR5(lastColorYz.gettR5() + 1);
								colorYz.setLtR1(lastColorYz.getLtR1());
								colorYz.setLtR2(lastColorYz.getLtR2());
								colorYz.setLtR3(lastColorYz.getLtR3());
								colorYz.setLtR4(lastColorYz.getLtR4());
								colorYz.setLtR6(lastColorYz.getLtR6());
								colorYz.setLtR7(lastColorYz.getLtR7());
								colorYz.setLtR8(lastColorYz.getLtR8());
								colorYz.settR1(lastColorYz.gettR1());
								colorYz.settR2(lastColorYz.gettR2());
								colorYz.settR3(lastColorYz.gettR3());
								colorYz.settR4(lastColorYz.gettR4());
								colorYz.settR6(lastColorYz.gettR6());
								colorYz.settR7(lastColorYz.gettR7());
								colorYz.settR8(lastColorYz.gettR8());
							}
								break;
							case 7: {
								colorYz.setR1(6);
								colorYz.setR2(5);
								colorYz.setR3(4);
								colorYz.setR4(3);
								colorYz.setR5(2);
								colorYz.setR6(1);
								colorYz.setR7(lastColorYz.getR7() + 1);
								colorYz.setR8(lastColorYz.getR8() + 1);
								colorYz.setR1Color("white");
								colorYz.setR2Color("white");
								colorYz.setR3Color("white");
								colorYz.setR4Color("white");
								colorYz.setR5Color("white");
								colorYz.setR6Color("white");
								colorYz.setR7Color("red");
								colorYz.setR8Color("red");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettR6();
								}
								colorYz.setLtR6(lastColorYz.gettR6() + 1 - lastLimitedCount);
								colorYz.settR6(lastColorYz.gettR6() + 1);
								colorYz.setLtR1(lastColorYz.getLtR1());
								colorYz.setLtR2(lastColorYz.getLtR2());
								colorYz.setLtR3(lastColorYz.getLtR3());
								colorYz.setLtR4(lastColorYz.getLtR4());
								colorYz.setLtR5(lastColorYz.getLtR5());
								colorYz.setLtR7(lastColorYz.getLtR7());
								colorYz.setLtR8(lastColorYz.getLtR8());
								colorYz.settR1(lastColorYz.gettR1());
								colorYz.settR2(lastColorYz.gettR2());
								colorYz.settR3(lastColorYz.gettR3());
								colorYz.settR4(lastColorYz.gettR4());
								colorYz.settR5(lastColorYz.gettR5());
								colorYz.settR7(lastColorYz.gettR7());
								colorYz.settR8(lastColorYz.gettR8());
							}
								break;
							case 8: {
								colorYz.setR1(7);
								colorYz.setR2(6);
								colorYz.setR3(5);
								colorYz.setR4(4);
								colorYz.setR5(3);
								colorYz.setR6(2);
								colorYz.setR7(1);
								colorYz.setR8(lastColorYz.getR8() + 1);
								colorYz.setR1Color("white");
								colorYz.setR2Color("white");
								colorYz.setR3Color("white");
								colorYz.setR4Color("white");
								colorYz.setR5Color("white");
								colorYz.setR6Color("white");
								colorYz.setR7Color("white");
								colorYz.setR8Color("red");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettR7();
								}
								colorYz.setLtR7(lastColorYz.gettR7() + 1 - lastLimitedCount);
								colorYz.settR7(lastColorYz.gettR7() + 1);
								colorYz.setLtR1(lastColorYz.getLtR1());
								colorYz.setLtR2(lastColorYz.getLtR2());
								colorYz.setLtR3(lastColorYz.getLtR3());
								colorYz.setLtR4(lastColorYz.getLtR4());
								colorYz.setLtR5(lastColorYz.getLtR5());
								colorYz.setLtR6(lastColorYz.getLtR6());
								colorYz.setLtR8(lastColorYz.getLtR8());
								colorYz.settR1(lastColorYz.gettR1());
								colorYz.settR2(lastColorYz.gettR2());
								colorYz.settR3(lastColorYz.gettR3());
								colorYz.settR4(lastColorYz.gettR4());
								colorYz.settR5(lastColorYz.gettR5());
								colorYz.settR6(lastColorYz.gettR6());
								colorYz.settR8(lastColorYz.gettR8());
							}
								break;
							case 9: {
								colorYz.setR1(8);
								colorYz.setR2(7);
								colorYz.setR3(6);
								colorYz.setR4(5);
								colorYz.setR5(4);
								colorYz.setR6(3);
								colorYz.setR7(2);
								colorYz.setR8(1);
								colorYz.setR1Color("white");
								colorYz.setR2Color("white");
								colorYz.setR3Color("white");
								colorYz.setR4Color("white");
								colorYz.setR5Color("white");
								colorYz.setR6Color("white");
								colorYz.setR7Color("white");
								colorYz.setR8Color("white");
								int lastLimitedCount = 0;
								if (lastLimitedColorYzOp.isPresent()) {
									lastLimitedCount = lastLimitedColorYzOp.get().gettR8();
								}
								colorYz.setLtR8(lastColorYz.gettR8() + 1 - lastLimitedCount);
								colorYz.settR8(lastColorYz.gettR8() + 1);
								colorYz.setLtR1(lastColorYz.getLtR1());
								colorYz.setLtR2(lastColorYz.getLtR2());
								colorYz.setLtR3(lastColorYz.getLtR3());
								colorYz.setLtR4(lastColorYz.getLtR4());
								colorYz.setLtR5(lastColorYz.getLtR5());
								colorYz.setLtR6(lastColorYz.getLtR6());
								colorYz.setLtR7(lastColorYz.getLtR7());
								colorYz.settR1(lastColorYz.gettR1());
								colorYz.settR2(lastColorYz.gettR2());
								colorYz.settR3(lastColorYz.gettR3());
								colorYz.settR4(lastColorYz.gettR4());
								colorYz.settR5(lastColorYz.gettR5());
								colorYz.settR6(lastColorYz.gettR6());
								colorYz.settR7(lastColorYz.gettR7());
							}
								break;
							default: {
								colorYz.setR1(lastColorYz.getR1() + 1);
								colorYz.setR2(lastColorYz.getR2() + 1);
								colorYz.setR3(lastColorYz.getR3() + 1);
								colorYz.setR4(lastColorYz.getR4() + 1);
								colorYz.setR5(lastColorYz.getR5() + 1);
								colorYz.setR6(lastColorYz.getR6() + 1);
								colorYz.setR7(lastColorYz.getR7() + 1);
								colorYz.setR8(lastColorYz.getR8() + 1);
								colorYz.setR1Color("white");
								colorYz.setR2Color("white");
								colorYz.setR3Color("white");
								colorYz.setR4Color("white");
								colorYz.setR5Color("white");
								colorYz.setR6Color("white");
								colorYz.setR7Color("white");
								colorYz.setR8Color("white");
								colorYz.setLtR1(lastColorYz.getLtR1());
								colorYz.setLtR2(lastColorYz.getLtR2());
								colorYz.setLtR3(lastColorYz.getLtR3());
								colorYz.setLtR4(lastColorYz.getLtR4());
								colorYz.setLtR5(lastColorYz.getLtR5());
								colorYz.setLtR6(lastColorYz.getLtR6());
								colorYz.setLtR7(lastColorYz.getLtR7());
								colorYz.setLtR8(lastColorYz.getLtR8());
								colorYz.settR1(lastColorYz.gettR1());
								colorYz.settR2(lastColorYz.gettR2());
								colorYz.settR3(lastColorYz.gettR3());
								colorYz.settR4(lastColorYz.gettR4());
								colorYz.settR5(lastColorYz.gettR5());
								colorYz.settR6(lastColorYz.gettR6());
								colorYz.settR7(lastColorYz.gettR7());
								colorYz.settR8(lastColorYz.gettR8());
//								int lastLimitedCount = 0;
//								if (colorYz.getR1() == 1) {
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettR1();
//									}
//									colorYz.setLtR1(lastColorYz.gettR1() + 1 - lastLimitedCount);
//									colorYz.settR1(lastColorYz.gettR1() + 1);
//									colorYz.setLtR2(lastColorYz.getLtR2());
//									colorYz.setLtR3(lastColorYz.getLtR3());
//									colorYz.setLtR4(lastColorYz.getLtR4());
//									colorYz.setLtR5(lastColorYz.getLtR5());
//									colorYz.setLtR6(lastColorYz.getLtR6());
//									colorYz.setLtR7(lastColorYz.getLtR7());
//									colorYz.setLtR8(lastColorYz.getLtR8());
//									colorYz.settR2(lastColorYz.gettR2());
//									colorYz.settR3(lastColorYz.gettR3());
//									colorYz.settR4(lastColorYz.gettR4());
//									colorYz.settR5(lastColorYz.gettR5());
//									colorYz.settR6(lastColorYz.gettR6());
//									colorYz.settR7(lastColorYz.gettR7());
//									colorYz.settR8(lastColorYz.gettR8());
//								} else if (colorYz.getR2() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettR2();
//									}
//									colorYz.setLtR2(lastColorYz.gettR2() + 1 - lastLimitedCount);
//									colorYz.settR2(lastColorYz.gettR2() + 1);
//									colorYz.setLtR1(lastColorYz.getLtR1());
//									colorYz.setLtR3(lastColorYz.getLtR3());
//									colorYz.setLtR4(lastColorYz.getLtR4());
//									colorYz.setLtR5(lastColorYz.getLtR5());
//									colorYz.setLtR6(lastColorYz.getLtR6());
//									colorYz.setLtR7(lastColorYz.getLtR7());
//									colorYz.setLtR8(lastColorYz.getLtR8());
//									colorYz.settR1(lastColorYz.gettR1());
//									colorYz.settR3(lastColorYz.gettR3());
//									colorYz.settR4(lastColorYz.gettR4());
//									colorYz.settR5(lastColorYz.gettR5());
//									colorYz.settR6(lastColorYz.gettR6());
//									colorYz.settR7(lastColorYz.gettR7());
//									colorYz.settR8(lastColorYz.gettR8());
//								} else if (colorYz.getR3() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettR3();
//									}
//									colorYz.setLtR3(lastColorYz.gettR3() + 1 - lastLimitedCount);
//									colorYz.settR3(lastColorYz.gettR3() + 1);
//									colorYz.setLtR1(lastColorYz.getLtR1());
//									colorYz.setLtR2(lastColorYz.getLtR2());
//									colorYz.setLtR4(lastColorYz.getLtR4());
//									colorYz.setLtR5(lastColorYz.getLtR5());
//									colorYz.setLtR6(lastColorYz.getLtR6());
//									colorYz.setLtR7(lastColorYz.getLtR7());
//									colorYz.setLtR8(lastColorYz.getLtR8());
//									colorYz.settR1(lastColorYz.gettR1());
//									colorYz.settR2(lastColorYz.gettR2());
//									colorYz.settR4(lastColorYz.gettR4());
//									colorYz.settR5(lastColorYz.gettR5());
//									colorYz.settR6(lastColorYz.gettR6());
//									colorYz.settR7(lastColorYz.gettR7());
//									colorYz.settR8(lastColorYz.gettR8());
//								} else if (colorYz.getR4() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettR4();
//									}
//									colorYz.setLtR4(lastColorYz.gettR4() + 1 - lastLimitedCount);
//									colorYz.settR4(lastColorYz.gettR4() + 1);
//									colorYz.setLtR1(lastColorYz.getLtR1());
//									colorYz.setLtR2(lastColorYz.getLtR2());
//									colorYz.setLtR3(lastColorYz.getLtR3());
//									colorYz.setLtR5(lastColorYz.getLtR5());
//									colorYz.setLtR6(lastColorYz.getLtR6());
//									colorYz.setLtR7(lastColorYz.getLtR7());
//									colorYz.setLtR8(lastColorYz.getLtR8());
//									colorYz.settR1(lastColorYz.gettR1());
//									colorYz.settR2(lastColorYz.gettR2());
//									colorYz.settR3(lastColorYz.gettR3());
//									colorYz.settR5(lastColorYz.gettR5());
//									colorYz.settR6(lastColorYz.gettR6());
//									colorYz.settR7(lastColorYz.gettR7());
//									colorYz.settR8(lastColorYz.gettR8());
//								} else if (colorYz.getR5() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettR5();
//									}
//									colorYz.setLtR5(lastColorYz.gettR5() + 1 - lastLimitedCount);
//									colorYz.settR5(lastColorYz.gettR5() + 1);
//									colorYz.setLtR1(lastColorYz.getLtR1());
//									colorYz.setLtR2(lastColorYz.getLtR2());
//									colorYz.setLtR3(lastColorYz.getLtR3());
//									colorYz.setLtR4(lastColorYz.getLtR4());
//									colorYz.setLtR6(lastColorYz.getLtR6());
//									colorYz.setLtR7(lastColorYz.getLtR7());
//									colorYz.setLtR8(lastColorYz.getLtR8());
//									colorYz.settR1(lastColorYz.gettR1());
//									colorYz.settR2(lastColorYz.gettR2());
//									colorYz.settR3(lastColorYz.gettR3());
//									colorYz.settR4(lastColorYz.gettR4());
//									colorYz.settR6(lastColorYz.gettR6());
//									colorYz.settR7(lastColorYz.gettR7());
//									colorYz.settR8(lastColorYz.gettR8());
//								} else if (colorYz.getR6() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettR6();
//									}
//									colorYz.setLtR6(lastColorYz.gettR6() + 1 - lastLimitedCount);
//									colorYz.settR6(lastColorYz.gettR6() + 1);
//									colorYz.setLtR1(lastColorYz.getLtR1());
//									colorYz.setLtR2(lastColorYz.getLtR2());
//									colorYz.setLtR3(lastColorYz.getLtR3());
//									colorYz.setLtR4(lastColorYz.getLtR4());
//									colorYz.setLtR5(lastColorYz.getLtR5());
//									colorYz.setLtR7(lastColorYz.getLtR7());
//									colorYz.setLtR8(lastColorYz.getLtR8());
//									colorYz.settR1(lastColorYz.gettR1());
//									colorYz.settR2(lastColorYz.gettR2());
//									colorYz.settR3(lastColorYz.gettR3());
//									colorYz.settR4(lastColorYz.gettR4());
//									colorYz.settR5(lastColorYz.gettR5());
//									colorYz.settR7(lastColorYz.gettR7());
//									colorYz.settR8(lastColorYz.gettR8());
//								} else if (colorYz.getR7() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettR7();
//									}
//									colorYz.setLtR7(lastColorYz.gettR7() + 1 - lastLimitedCount);
//									colorYz.settR7(lastColorYz.gettR7() + 1);
//									colorYz.setLtR1(lastColorYz.getLtR1());
//									colorYz.setLtR2(lastColorYz.getLtR2());
//									colorYz.setLtR3(lastColorYz.getLtR3());
//									colorYz.setLtR4(lastColorYz.getLtR4());
//									colorYz.setLtR5(lastColorYz.getLtR5());
//									colorYz.setLtR6(lastColorYz.getLtR6());
//									colorYz.setLtR8(lastColorYz.getLtR8());
//									colorYz.settR1(lastColorYz.gettR1());
//									colorYz.settR2(lastColorYz.gettR2());
//									colorYz.settR3(lastColorYz.gettR3());
//									colorYz.settR4(lastColorYz.gettR4());
//									colorYz.settR5(lastColorYz.gettR5());
//									colorYz.settR6(lastColorYz.gettR6());
//									colorYz.settR8(lastColorYz.gettR8());
//								} else if (colorYz.getR8() == 1) {
//									lastLimitedCount = 0;
//									if (lastLimitedColorYzOp.isPresent()) {
//										lastLimitedCount = lastLimitedColorYzOp.get().gettR8();
//									}
//									colorYz.setLtR8(lastColorYz.gettR8() + 1 - lastLimitedCount);
//									colorYz.settR8(lastColorYz.gettR8() + 1);
//									colorYz.setLtR1(lastColorYz.getLtR1());
//									colorYz.setLtR2(lastColorYz.getLtR2());
//									colorYz.setLtR3(lastColorYz.getLtR3());
//									colorYz.setLtR4(lastColorYz.getLtR4());
//									colorYz.setLtR5(lastColorYz.getLtR5());
//									colorYz.setLtR6(lastColorYz.getLtR6());
//									colorYz.setLtR7(lastColorYz.getLtR7());
//									colorYz.settR1(lastColorYz.gettR1());
//									colorYz.settR2(lastColorYz.gettR2());
//									colorYz.settR3(lastColorYz.gettR3());
//									colorYz.settR4(lastColorYz.gettR4());
//									colorYz.settR5(lastColorYz.gettR5());
//									colorYz.settR6(lastColorYz.gettR6());
//									colorYz.settR7(lastColorYz.gettR7());
//								}
							}
							}
						}

						if (colorYz.getR1Color().equals("white") || colorYz.getG1Color().equals("white")) {
							colorYz.setWrColor("red");
							if ("white".equals(lastColorYz.getWrColor())) {
								colorYz.setWr(1);
							} else {
								colorYz.setWr(lastColorYz.getWr() + 1);
							}
						} else {
							colorYz.setWrColor("white");
							if ("red".equals(lastColorYz.getWrColor())) {
								colorYz.setWr(1);
							} else {
								colorYz.setWr(lastColorYz.getWr() + 1);
							}
						}

						colorYzRepository.save(colorYz);

						Optional<Lhc3ColorYz2> lastColorYz2Op = colorYz2Repository.findFirstByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(tables + "", type,
								tm.getPhase());
						Lhc3ColorYz2 colorYz2 = new Lhc3ColorYz2();
						colorYz2.setPhase(tm.getPhase());
						colorYz2.setTables(tables + "");
						colorYz2.setType(type);
						if (!lastColorYz2Op.isPresent()) {
							colorYz2.setWr(1);
							colorYz2.setWrPos(0);
							colorYz2.setWrBase(1);
							colorYz2.setWrColor(colorYz.getWrColor());
							if (colorYz.getWrColor().equals("red")) {
								colorYz2.setWrIncome(48.5 * colorYz2.getWr());
							}
							colorYz2.setYzr(1);
							colorYz2.setYzrBase(1);
							colorYz2.setYzrPos(0);
							if ("red".equals(colorYz.getYzColor())) {
								colorYz2.setYzrColor("red");
								colorYz2.setYzrIncome(48.5 * colorYz2.getYzr());
							} else {
								colorYz2.setYzrColor("white");
							}
							colorYz2.setYzg(1);
							colorYz2.setYzgBase(1);
							colorYz2.setYzgPos(0);
							if ("green".equals(colorYz.getYzColor())) {
								colorYz2.setYzgColor("red");
								colorYz2.setYzgIncome(48.5 * colorYz2.getYzg());
							} else {
								colorYz2.setYzgColor("white");
							}
							colorYz2.setWrCost(25 * colorYz2.getWr());
							colorYz2.setYzrCost(25 * colorYz2.getYzr());
							colorYz2.setYzgCost(25 * colorYz2.getYzg());
							colorYz2.setWrCostt(colorYz2.getWrCost());
							colorYz2.setYzrCostt(colorYz2.getYzrCost());
							colorYz2.setYzgCostt(colorYz2.getYzgCost());
							colorYz2.setWrCostlt(colorYz2.getWrCost());
							colorYz2.setYzrCostlt(colorYz2.getYzrCost());
							colorYz2.setYzgCostlt(colorYz2.getYzgCost());
							colorYz2.setWrIncomet(colorYz2.getWrIncome());
							colorYz2.setWrIncomelt(colorYz2.getWrIncome());
							colorYz2.setYzrIncomet(colorYz2.getYzrIncome());
							colorYz2.setYzrIncomelt(colorYz2.getYzrIncome());
							colorYz2.setYzgIncomet(colorYz2.getYzgIncome());
							colorYz2.setYzgIncomelt(colorYz2.getYzgIncome());
						} else {
							List<Lhc3ColorYz2> lastLimitedColorYz2List = colorYz2Repository.findTop100ByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(tables + "",
									type, tm.getPhase());
							Lhc3ColorYz2 lastLimitedYz = null;
							if (lastLimitedColorYz2List != null && lastLimitedColorYz2List.size() == 100) {
								lastLimitedYz = lastLimitedColorYz2List.get(99);
							}
							Lhc3ColorYz2 lastColorYz2 = lastColorYz2Op.get();
							setColor2(lastColorYz2, colorYz, colorYz2, "Wr", "red", lastLimitedYz);
							setColor2(lastColorYz2, colorYz, colorYz2, "Yzr", "red", lastLimitedYz);
							setColor2(lastColorYz2, colorYz, colorYz2, "Yzg", "green", lastLimitedYz);
						}
						colorYz2Repository.save(colorYz2);
					}
				}
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<Exception>(t);
	}

	private int[] whiteTimes = { 1, 3, 7, 15, 32, 67, 141, 293, 611, 611 };
	private int[] redTimes = { 1, 7, 17, 45, 45 };

	private void setColor2(Lhc3ColorYz2 lastYz, Lhc3ColorYz yz, Lhc3ColorYz2 colorYz2, String method, String specColor, Lhc3ColorYz2 lastLimitedYz)
			throws Exception {

		Method colorGm = null;
		if (method.equals("Wr")) {
			colorGm = ReflectionUtils.findMethod(Lhc3ColorYz.class, "getWrColor");
		} else {
			colorGm = ReflectionUtils.findMethod(Lhc3ColorYz.class, "getYzColor");
		}
		String yzColor = (String) colorGm.invoke(yz);
		Method colorGm2 = ReflectionUtils.findMethod(Lhc3ColorYz2.class, "get" + method + "Color");
		String lastColor = (String) colorGm2.invoke(lastYz);
		Method posGm = ReflectionUtils.findMethod(Lhc3ColorYz2.class, "get" + method + "Pos");
		Method baseGm = ReflectionUtils.findMethod(Lhc3ColorYz2.class, "get" + method + "Base");
		Method yzSm = ReflectionUtils.findMethod(Lhc3ColorYz2.class, "set" + method, int.class);
		Method yzGm = ReflectionUtils.findMethod(Lhc3ColorYz2.class, "get" + method);
		Method posSm = ReflectionUtils.findMethod(Lhc3ColorYz2.class, "set" + method + "Pos", int.class);
		Method colorSm = ReflectionUtils.findMethod(Lhc3ColorYz2.class, "set" + method + "Color", String.class);
		Method baseSm = ReflectionUtils.findMethod(Lhc3ColorYz2.class, "set" + method + "Base", int.class);
		Method incomeSm = ReflectionUtils.findMethod(Lhc3ColorYz2.class, "set" + method + "Income", double.class);
		if (lastColor.equals("white")) {
			if (yzColor.equals(specColor)) {
				int times = 0;
				int pos = (Integer) posGm.invoke(lastYz) + 1;
				if (whiteTimes.length > pos) {
					times = whiteTimes[pos];
				}
				int base = (Integer) baseGm.invoke(lastYz) * times;
				yzSm.invoke(colorYz2, base);
				posSm.invoke(colorYz2, -1);
				baseSm.invoke(colorYz2, 1);
				colorSm.invoke(colorYz2, "red");
				incomeSm.invoke(colorYz2, 48.5 * (int) yzGm.invoke(colorYz2));
			} else {
				int times = 0;
				int pos = (Integer) posGm.invoke(lastYz) + 1;
				if (whiteTimes.length > pos) {
					times = whiteTimes[pos];
				}
				Integer base = (Integer) baseGm.invoke(lastYz);
				yzSm.invoke(colorYz2, base * times);
				posSm.invoke(colorYz2, pos);
				baseSm.invoke(colorYz2, 1);
				colorSm.invoke(colorYz2, "white");
			}
		} else {
			if (yzColor.equals(specColor)) {
				int pos = (Integer) posGm.invoke(lastYz) + 1;
				if (pos >= redTimes.length) {
					pos = 0;
				}
				int times = redTimes[pos];
				yzSm.invoke(colorYz2, times);
				posSm.invoke(colorYz2, pos);
				baseSm.invoke(colorYz2, 1);
				colorSm.invoke(colorYz2, "red");
				colorYz2.setWrCost(25 * colorYz2.getWr());
				colorYz2.setYzrCost(25 * colorYz2.getYzr());
				colorYz2.setYzgCost(25 * colorYz2.getYzg());
				incomeSm.invoke(colorYz2, 48.5 * (int) yzGm.invoke(colorYz2));
			} else {
				int pos = (Integer) posGm.invoke(lastYz) + 1;
				if (pos >= redTimes.length) {
					pos = 0;
				}
				int base = redTimes[pos];
				yzSm.invoke(colorYz2, base);
				posSm.invoke(colorYz2, 0);
				baseSm.invoke(colorYz2, base);
				colorSm.invoke(colorYz2, "white");
			}
		}
		colorYz2.setWrCost(25 * colorYz2.getWr());
		colorYz2.setYzrCost(25 * colorYz2.getYzr());
		colorYz2.setYzgCost(25 * colorYz2.getYzg());
		colorYz2.setWrCostt(lastYz.getWrCostt() + colorYz2.getWrCost());
		colorYz2.setYzrCostt(lastYz.getYzrCostt() + colorYz2.getYzrCost());
		colorYz2.setYzgCostt(lastYz.getYzgCostt() + colorYz2.getYzgCost());
		colorYz2.setWrCostlt(lastYz.getWrCostlt() + colorYz2.getWrCost());
		colorYz2.setYzrCostlt(lastYz.getYzrCostlt() + colorYz2.getYzrCost());
		colorYz2.setYzgCostlt(lastYz.getYzgCostlt() + colorYz2.getYzgCost());
		colorYz2.setWrIncomet(lastYz.getWrIncomet() + colorYz2.getWrIncome());
		colorYz2.setWrIncomelt(lastYz.getWrIncomet() + colorYz2.getWrIncome());
		colorYz2.setYzrIncomet(lastYz.getYzrIncomet() + colorYz2.getYzrIncome());
		colorYz2.setYzrIncomelt(lastYz.getYzrIncomet() + colorYz2.getYzrIncome());
		colorYz2.setYzgIncomet(lastYz.getYzgIncomet() + colorYz2.getYzgIncome());
		colorYz2.setYzgIncomelt(lastYz.getYzgIncomet() + colorYz2.getYzgIncome());
		if (lastLimitedYz != null) {
			colorYz2.setWrCostlt(colorYz2.getWrCostt() - lastLimitedYz.getWrCostt());
			colorYz2.setYzrCostlt(colorYz2.getYzrCostt() - lastLimitedYz.getYzrCostt());
			colorYz2.setYzgCostlt(colorYz2.getYzgCostt() - lastLimitedYz.getYzgCostt());
			colorYz2.setWrIncomelt(colorYz2.getWrIncomet() - lastLimitedYz.getWrIncomet());
			colorYz2.setYzrIncomelt(colorYz2.getYzrIncomet() - lastLimitedYz.getYzrIncomet());
			colorYz2.setYzgIncomelt(colorYz2.getYzgIncomet() - lastLimitedYz.getYzgIncomet());
		}
	}

}
