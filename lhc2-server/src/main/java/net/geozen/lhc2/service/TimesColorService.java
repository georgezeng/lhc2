package net.geozen.lhc2.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
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
import net.geozen.lhc2.domain.ColorYz;
import net.geozen.lhc2.domain.ColorYz2;
import net.geozen.lhc2.domain.PickNum;
import net.geozen.lhc2.domain.TimesYz;
import net.geozen.lhc2.dto.PickNumCountInfo;
import net.geozen.lhc2.dto.PickNumPayload;
import net.geozen.lhc2.jpa.ColorYz2Repository;
import net.geozen.lhc2.jpa.ColorYzRepository;
import net.geozen.lhc2.jpa.PickNumRepository;
import net.geozen.lhc2.jpa.TimesYzRepository;
import net.geozen.lhc2.utils.SystemConstants;

@Service
@Slf4j
public class TimesColorService {
	@Autowired
	private TimesYzRepository timesYzRepository;

	@Autowired
	private ColorYzRepository colorYzRepository;

	@Autowired
	private ColorYz2Repository colorYz2Repository;

	@Autowired
	private PickNumRepository pickNumRepository;

	@Autowired
	ObjectMapper mapper;

	@Transactional
	@Async
	public Future<Exception> process(int tables, String type) {
		Exception t = null;
		try {
			Pageable pageable = PageRequest.of(0, SystemConstants.CALCULATION_SIZE, Direction.DESC, "phase");
			Page<PickNum> pResult = null;
			ColorYz lastColorYz = new ColorYz();
			TimesYz lastTimesYz = new TimesYz();
			List<ColorYz> colorYzList = new ArrayList<>();
			List<ColorYz2> colorYz2List = new ArrayList<>();
			List<TimesYz> timesYzList = new ArrayList<>();
			PickNum prevNumInfo = null;
			String initColor = null;
			// do {
			pResult = pickNumRepository.findAllByExpectedAndType(tables, type, pageable);
			for (int i = pResult.getContent().size() - 1; i > -1; i--) {
				// for (PickNum numInfo : pResult.getContent()) {
				PickNum numInfo = pResult.getContent().get(i);
				prevNumInfo = null;
				if (i < pResult.getContent().size() - 1) {
					prevNumInfo = pResult.getContent().get(i + 1);
				}
				if (prevNumInfo == null) {
					continue;
				}
				TimesYz timesYz = new TimesYz();
				timesYz.setType(type);
				timesYz.setPhase(numInfo.getPhase());
				timesYz.setTables(tables + "");
				timesYz.setNum(numInfo.getTm());
				ColorYz colorYz = new ColorYz();
				colorYz.setPhase(numInfo.getPhase());
				colorYz.setTables(tables + "");
				colorYz.setType(type);
				PickNumPayload payload = mapper.readValue(prevNumInfo.getPayload(), PickNumPayload.class);
				PickNumCountInfo tmInfo = null;
				for (PickNumCountInfo info : payload.getInfos()) {
					if (numInfo.getTm() == info.getNum()) {
						tmInfo = info;
						break;
					}
				}
				String color = null;
				if ("P1".equals(type)) {
					switch (tmInfo.getCount()) {
					case 0: {
						color = "green";
						timesYz.setTime0(0);
						timesYz.setPos(0);
						timesYz.setTime12(lastTimesYz.getTime12() + 1);
						timesYz.setTime3Plus(lastTimesYz.getTime3Plus() + 1);
					}
						break;
					case 1:
					case 2: {
						timesYz.setPos(1);
						color = "red";
						timesYz.setTime0(lastTimesYz.getTime0() + 1);
						timesYz.setTime12(0);
						timesYz.setTime3Plus(lastTimesYz.getTime3Plus() + 1);
					}
						break;
					default: {
						timesYz.setPos(2);
						color = "green";
						timesYz.setTime0(lastTimesYz.getTime0() + 1);
						timesYz.setTime12(lastTimesYz.getTime12() + 1);
						timesYz.setTime3Plus(0);
					}
					}
				} else {
					switch (tmInfo.getCount()) {
					case 0: {
						color = "green";
						timesYz.setTime0(0);
						timesYz.setPos(0);
						timesYz.setTime12(lastTimesYz.getTime12() + 1);
						timesYz.setTime3Plus(lastTimesYz.getTime3Plus() + 1);
					}
						break;
					case 1:
					case 2:
					case 3: {
						timesYz.setPos(1);
						color = "red";
						timesYz.setTime0(lastTimesYz.getTime0() + 1);
						timesYz.setTime12(0);
						timesYz.setTime3Plus(lastTimesYz.getTime3Plus() + 1);
					}
						break;
					default: {
						timesYz.setPos(2);
						color = "green";
						timesYz.setTime0(lastTimesYz.getTime0() + 1);
						timesYz.setTime12(lastTimesYz.getTime12() + 1);
						timesYz.setTime3Plus(0);
					}
					}
				}
				if (initColor == null) {
					initColor = color;
				}
				lastTimesYz = timesYz;
				timesYzList.add(timesYz);
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
					colorYz.setR1Color("red");
					colorYz.setR2Color("red");
					colorYz.setR3Color("red");
					colorYz.setR4Color("red");
					colorYz.setR5Color("red");

					switch (colorYz.getYz()) {
					case 1: {
						colorYz.setG1(lastColorYz.getG1() + 1);
						colorYz.setG2(lastColorYz.getG2() + 1);
						colorYz.setG3(lastColorYz.getG3() + 1);
						colorYz.setG4(lastColorYz.getG4() + 1);
						colorYz.setG5(lastColorYz.getG5() + 1);
						colorYz.setG1Color("green");
						colorYz.setG2Color("green");
						colorYz.setG3Color("green");
						colorYz.setG4Color("green");
						colorYz.setG5Color("green");
					}
						break;
					case 2: {
						colorYz.setG1(1);
						colorYz.setG2(lastColorYz.getG2() + 1);
						colorYz.setG3(lastColorYz.getG3() + 1);
						colorYz.setG4(lastColorYz.getG4() + 1);
						colorYz.setG5(lastColorYz.getG5() + 1);
						colorYz.setG1Color("white");
						colorYz.setG2Color("green");
						colorYz.setG3Color("green");
						colorYz.setG4Color("green");
						colorYz.setG5Color("green");
					}
						break;
					case 3: {
						colorYz.setG1(2);
						colorYz.setG2(1);
						colorYz.setG3(lastColorYz.getG3() + 1);
						colorYz.setG4(lastColorYz.getG4() + 1);
						colorYz.setG5(lastColorYz.getG5() + 1);
						colorYz.setG1Color("white");
						colorYz.setG2Color("white");
						colorYz.setG3Color("green");
						colorYz.setG4Color("green");
						colorYz.setG5Color("green");
					}
						break;
					case 4: {
						colorYz.setG1(3);
						colorYz.setG2(2);
						colorYz.setG3(1);
						colorYz.setG4(lastColorYz.getG4() + 1);
						colorYz.setG5(lastColorYz.getG5() + 1);
						colorYz.setG1Color("white");
						colorYz.setG2Color("white");
						colorYz.setG3Color("white");
						colorYz.setG4Color("green");
						colorYz.setG5Color("green");
					}
						break;
					case 5: {
						colorYz.setG1(4);
						colorYz.setG2(3);
						colorYz.setG3(2);
						colorYz.setG4(1);
						colorYz.setG5(lastColorYz.getG5() + 1);
						colorYz.setG1Color("white");
						colorYz.setG2Color("white");
						colorYz.setG3Color("white");
						colorYz.setG4Color("white");
						colorYz.setG5Color("green");
					}
						break;
					case 6: {
						colorYz.setG1(5);
						colorYz.setG2(4);
						colorYz.setG3(3);
						colorYz.setG4(2);
						colorYz.setG5(1);
						colorYz.setG1Color("white");
						colorYz.setG2Color("white");
						colorYz.setG3Color("white");
						colorYz.setG4Color("white");
						colorYz.setG5Color("white");
					}
						break;
					default: {
						colorYz.setG1(lastColorYz.getG1() + 1);
						colorYz.setG2(lastColorYz.getG2() + 1);
						colorYz.setG3(lastColorYz.getG3() + 1);
						colorYz.setG4(lastColorYz.getG4() + 1);
						colorYz.setG5(lastColorYz.getG5() + 1);
						colorYz.setG1Color("white");
						colorYz.setG2Color("white");
						colorYz.setG3Color("white");
						colorYz.setG4Color("white");
						colorYz.setG5Color("white");
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
					colorYz.setG1Color("green");
					colorYz.setG2Color("green");
					colorYz.setG3Color("green");
					colorYz.setG4Color("green");
					colorYz.setG5Color("green");

					switch (colorYz.getYz()) {
					case 1: {
						colorYz.setR1(lastColorYz.getR1() + 1);
						colorYz.setR2(lastColorYz.getR2() + 1);
						colorYz.setR3(lastColorYz.getR3() + 1);
						colorYz.setR4(lastColorYz.getR4() + 1);
						colorYz.setR5(lastColorYz.getR5() + 1);
						colorYz.setR1Color("red");
						colorYz.setR2Color("red");
						colorYz.setR3Color("red");
						colorYz.setR4Color("red");
						colorYz.setR5Color("red");
					}
						break;
					case 2: {
						colorYz.setR1(1);
						colorYz.setR2(lastColorYz.getR2() + 1);
						colorYz.setR3(lastColorYz.getR3() + 1);
						colorYz.setR4(lastColorYz.getR4() + 1);
						colorYz.setR5(lastColorYz.getR5() + 1);
						colorYz.setR1Color("white");
						colorYz.setR2Color("red");
						colorYz.setR3Color("red");
						colorYz.setR4Color("red");
						colorYz.setR5Color("red");
					}
						break;
					case 3: {
						colorYz.setR1(2);
						colorYz.setR2(1);
						colorYz.setR3(lastColorYz.getR3() + 1);
						colorYz.setR4(lastColorYz.getR4() + 1);
						colorYz.setR5(lastColorYz.getR5() + 1);
						colorYz.setR1Color("white");
						colorYz.setR2Color("white");
						colorYz.setR3Color("red");
						colorYz.setR4Color("red");
						colorYz.setR5Color("red");
					}
						break;
					case 4: {
						colorYz.setR1(3);
						colorYz.setR2(2);
						colorYz.setR3(1);
						colorYz.setR4(lastColorYz.getR4() + 1);
						colorYz.setR5(lastColorYz.getR5() + 1);
						colorYz.setR1Color("white");
						colorYz.setR2Color("white");
						colorYz.setR3Color("white");
						colorYz.setR4Color("red");
						colorYz.setR5Color("red");
					}
						break;
					case 5: {
						colorYz.setR1(4);
						colorYz.setR2(3);
						colorYz.setR3(2);
						colorYz.setR4(1);
						colorYz.setR5(lastColorYz.getR5() + 1);
						colorYz.setWrColor("red");
						colorYz.setWr(colorYz.getWr() + 1);
						colorYz.setR1Color("white");
						colorYz.setR2Color("white");
						colorYz.setR3Color("white");
						colorYz.setR4Color("white");
						colorYz.setR5Color("red");
					}
						break;
					case 6: {
						colorYz.setR1(5);
						colorYz.setR2(4);
						colorYz.setR3(3);
						colorYz.setR4(2);
						colorYz.setR5(1);
						colorYz.setR1Color("white");
						colorYz.setR2Color("white");
						colorYz.setR3Color("white");
						colorYz.setR4Color("white");
						colorYz.setR5Color("white");
					}
						break;
					default: {
						colorYz.setR1(lastColorYz.getR1() + 1);
						colorYz.setR2(lastColorYz.getR2() + 1);
						colorYz.setR3(lastColorYz.getR3() + 1);
						colorYz.setR4(lastColorYz.getR4() + 1);
						colorYz.setR5(lastColorYz.getR5() + 1);
						colorYz.setR1Color("white");
						colorYz.setR2Color("white");
						colorYz.setR3Color("white");
						colorYz.setR4Color("white");
						colorYz.setR5Color("white");
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

				lastColorYz = colorYz;
				colorYzList.add(colorYz);
			}
			// if (pResult.hasNext()) {
			// pageable = pageable.next();
			// }
			// } while (pResult.hasNext());

			int len = 3;
			for (int i = 1; i < timesYzList.size(); i++) {
				TimesYz lastYz = timesYzList.get(i - 1);
				TimesYz yz = timesYzList.get(i);
				int delta = yz.getPos() - lastYz.getPos();
				if (delta < 0) {
					delta += len;
				}
				TimesYz zf = yz;
				TimesYz lastZf = lastYz;
				for (int j = 0; j < len; j++) {
					Method setMethod = zf.getClass().getDeclaredMethod("setZf" + j, int.class);
					if (j != delta) {
						Method getMethod = zf.getClass().getDeclaredMethod("getZf" + j);
						int value = (int) getMethod.invoke(lastZf);
						setMethod.invoke(zf, value + 1);
					} else {
						setMethod.invoke(zf, 0);
					}
				}
				lastZf = zf;
			}

			int[] whiteTimes = { 1, 2, 5, 11, 23, 47 };
			int[] redTimes = { 1, 2, 4, 6, 8 };
			if ("P1".equals(type)) {
				ColorYz2 lastYz = null;
				for (ColorYz yz : colorYzList) {
					ColorYz2 colorYz2 = new ColorYz2();
					colorYz2.setPhase(yz.getPhase());
					colorYz2.setTables(yz.getTables());
					colorYz2.setType(yz.getType());

					if (lastYz == null) {
						colorYz2.setWr(1);
						colorYz2.setWrPos(0);
						colorYz2.setWrColor("white");
						colorYz2.setYzr(1);
						colorYz2.setYzrPos(0);
						if ("red".equals(initColor)) {
							colorYz2.setYzrColor("red");
						} else {
							colorYz2.setYzrColor("white");
						}
						colorYz2.setYzg(1);
						colorYz2.setYzgPos(0);
						if ("green".equals(initColor)) {
							colorYz2.setYzgColor("red");
						} else {
							colorYz2.setYzgColor("white");
						}
					} else {
						if (lastYz.getWrColor().equals("white")) {
							if (yz.getWrColor().equals("red")) {
								colorYz2.setWr(1);
								colorYz2.setWrPos(0);
								colorYz2.setWrColor("red");
							} else {
								int times = 0;
								int pos = lastYz.getWrPos() + 1;
								if (whiteTimes.length > pos) {
									times = whiteTimes[pos];
								}
								colorYz2.setWr(lastYz.getWr() * times);
								colorYz2.setWrPos(pos);
								colorYz2.setWrColor("white");
							}
						} else {
							if (yz.getWrColor().equals("red")) {
								int pos = lastYz.getWrPos();
								if (pos >= redTimes.length) {
									pos = 0;
								}
								int times = redTimes[pos];
								colorYz2.setWr(times);
								colorYz2.setWrPos(pos);
								colorYz2.setWrColor("red");
							} else {
								int times = 0;
								int pos = 0;
								if (whiteTimes.length > pos) {
									times = whiteTimes[pos];
								}
								colorYz2.setWr(lastYz.getWr() * times);
								colorYz2.setWrPos(pos);
								colorYz2.setWrColor("white");
							}
						}

						if (lastYz.getYzrColor().equals("white")) {
							if (yz.getYzColor().equals("red")) {
								colorYz2.setYzr(1);
								colorYz2.setYzrPos(0);
								colorYz2.setYzrColor("red");
							} else {
								int times = 0;
								int pos = lastYz.getYzrPos() + 1;
								if (whiteTimes.length > pos) {
									times = whiteTimes[pos];
								}
								colorYz2.setYzr(lastYz.getYzr() * times);
								colorYz2.setYzrPos(pos);
								colorYz2.setYzrColor("white");
							}
						} else {
							if (yz.getYzColor().equals("red")) {
								int pos = lastYz.getYzrPos();
								if (pos >= redTimes.length) {
									pos = 0;
								}
								int times = redTimes[pos];
								colorYz2.setYzr(times);
								colorYz2.setYzrPos(pos);
								colorYz2.setYzrColor("red");
							} else {
								int times = 0;
								int pos = 0;
								if (whiteTimes.length > pos) {
									times = whiteTimes[pos];
								}
								colorYz2.setYzr(lastYz.getYzr() * times);
								colorYz2.setYzrPos(pos);
								colorYz2.setYzrColor("white");
							}
						}

						if (lastYz.getYzgColor().equals("white")) {
							if (yz.getYzColor().equals("green")) {
								colorYz2.setYzg(1);
								colorYz2.setYzgPos(0);
								colorYz2.setYzgColor("red");
							} else {
								int times = 0;
								int pos = lastYz.getYzgPos() + 1;
								if (whiteTimes.length > pos) {
									times = whiteTimes[pos];
								}
								colorYz2.setYzg(lastYz.getYzg() * times);
								colorYz2.setYzgPos(pos);
								colorYz2.setYzgColor("white");
							}
						} else {
							if (yz.getYzColor().equals("green")) {
								int pos = lastYz.getYzgPos();
								if (pos >= redTimes.length) {
									pos = 0;
								}
								int times = redTimes[pos];
								colorYz2.setYzg(times);
								colorYz2.setYzgPos(pos);
								colorYz2.setYzgColor("red");
							} else {
								int times = 0;
								int pos = 0;
								if (whiteTimes.length > pos) {
									times = whiteTimes[pos];
								}
								colorYz2.setYzg(lastYz.getYzg() * times);
								colorYz2.setYzgPos(pos);
								colorYz2.setYzgColor("white");
							}
						}
					}

					colorYz2List.add(colorYz2);
					lastYz = colorYz2;
				}
			} else {
				ColorYz2 lastYz = null;
				int count = 0;
				for (ColorYz yz : colorYzList) {
					count++;
					ColorYz2 colorYz2 = new ColorYz2();
					colorYz2.setPhase(yz.getPhase());
					colorYz2.setTables(yz.getTables());
					colorYz2.setType(yz.getType());

					if (count > 19) {
						if (count == 20) {
							colorYz2.setWr(1);
							colorYz2.setWrPos(0);
							colorYz2.setWrColor("white");

							colorYz2.setYzr(1);
							colorYz2.setYzrPos(0);
							colorYz2.setYzrColor("red");

							colorYz2.setYzg(1);
							colorYz2.setYzgPos(0);
							colorYz2.setYzgColor("white");
						} else {
							if (lastYz.getWrColor().equals("white")) {
								if (yz.getWrColor().equals("red")) {
									colorYz2.setWr(1);
									colorYz2.setWrPos(0);
									colorYz2.setWrColor("red");
								} else {
									int times = 0;
									int pos = lastYz.getWrPos() + 1;
									if (whiteTimes.length > pos) {
										times = whiteTimes[pos];
									}
									colorYz2.setWr(lastYz.getWr() * times);
									colorYz2.setWrPos(pos);
									colorYz2.setWrColor("white");
								}
							} else {
								if (yz.getWrColor().equals("red")) {
									int pos = lastYz.getWrPos();
									if (pos >= redTimes.length) {
										pos = 0;
									}
									int times = redTimes[pos];
									colorYz2.setWr(times);
									colorYz2.setWrPos(pos);
									colorYz2.setWrColor("red");
								} else {
									int times = 0;
									int pos = 0;
									if (whiteTimes.length > pos) {
										times = whiteTimes[pos];
									}
									colorYz2.setWr(lastYz.getWr() * times);
									colorYz2.setWrPos(pos);
									colorYz2.setWrColor("white");
								}
							}

							if (lastYz.getYzrColor().equals("white")) {
								if (yz.getYzColor().equals("red")) {
									colorYz2.setYzr(1);
									colorYz2.setYzrPos(0);
									colorYz2.setYzrColor("red");
								} else {
									int times = 0;
									int pos = lastYz.getYzrPos() + 1;
									if (whiteTimes.length > pos) {
										times = whiteTimes[pos];
									}
									colorYz2.setYzr(lastYz.getYzr() * times);
									colorYz2.setYzrPos(pos);
									colorYz2.setYzrColor("white");
								}
							} else {
								if (yz.getYzColor().equals("red")) {
									int pos = lastYz.getYzrPos();
									if (pos >= redTimes.length) {
										pos = 0;
									}
									int times = redTimes[pos];
									colorYz2.setYzr(times);
									colorYz2.setYzrPos(pos);
									colorYz2.setYzrColor("red");
								} else {
									int times = 0;
									int pos = 0;
									if (whiteTimes.length > pos) {
										times = whiteTimes[pos];
									}
									colorYz2.setYzr(lastYz.getYzr() * times);
									colorYz2.setYzrPos(pos);
									colorYz2.setYzrColor("white");
								}
							}

							if (lastYz.getYzgColor().equals("white")) {
								if (yz.getYzColor().equals("green")) {
									colorYz2.setYzg(1);
									colorYz2.setYzgPos(0);
									colorYz2.setYzgColor("red");
								} else {
									int times = 0;
									int pos = lastYz.getYzgPos() + 1;
									if (whiteTimes.length > pos) {
										times = whiteTimes[pos];
									}
									colorYz2.setYzg(lastYz.getYzg() * times);
									colorYz2.setYzgPos(pos);
									colorYz2.setYzgColor("white");
								}
							} else {
								if (yz.getYzColor().equals("green")) {
									int pos = lastYz.getYzgPos();
									if (pos >= redTimes.length) {
										pos = 0;
									}
									int times = redTimes[pos];
									colorYz2.setYzg(times);
									colorYz2.setYzgPos(pos);
									colorYz2.setYzgColor("red");
								} else {
									int times = 0;
									int pos = 0;
									if (whiteTimes.length > pos) {
										times = whiteTimes[pos];
									}
									colorYz2.setYzg(lastYz.getYzg() * times);
									colorYz2.setYzgPos(pos);
									colorYz2.setYzgColor("white");
								}
							}
						}
					} else {
						colorYz2.setWrColor("white");
						colorYz2.setYzrColor("white");
						colorYz2.setYzgColor("white");
					}

					colorYz2List.add(colorYz2);
					lastYz = colorYz2;
				}
			}

			timesYzRepository.deleteAll(timesYzRepository.findAllByTablesAndType(tables + "", type));
			colorYzRepository.deleteAll(colorYzRepository.findAllByTablesAndType(tables + "", type));
			colorYz2Repository.deleteAll(colorYz2Repository.findAllByTablesAndType(tables + "", type));
			timesYzRepository.saveAll(timesYzList);
			colorYzRepository.saveAll(colorYzList);
			colorYz2Repository.saveAll(colorYz2List);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<Exception>(t);
	}

}
