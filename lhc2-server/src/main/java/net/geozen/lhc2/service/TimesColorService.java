package net.geozen.lhc2.service;

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
import net.geozen.lhc2.domain.PickNum;
import net.geozen.lhc2.domain.TimesYz;
import net.geozen.lhc2.dto.PickNumCountInfo;
import net.geozen.lhc2.dto.PickNumPayload;
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
	private PickNumRepository pickNumRepository;

	@Autowired
	ObjectMapper mapper;

	@Transactional
	@Async
	public Future<Exception> process() {
		Exception t = null;
		try {
			Pageable pageable = PageRequest.of(0, SystemConstants.CALCULATION_SIZE, Direction.DESC, "phase");
			Page<PickNum> pResult = null;
			ColorYz lastColorYz = new ColorYz();
			TimesYz lastTimesYz = new TimesYz();
			List<ColorYz> colorYzList = new ArrayList<>();
			List<TimesYz> timesYzList = new ArrayList<>();
			// do {
			pResult = pickNumRepository.findAllByExpected(16, pageable);
			for (int i = pResult.getContent().size() - 1; i > -1; i--) {
				// for (PickNum numInfo : pResult.getContent()) {
				PickNum numInfo = pResult.getContent().get(i);
				TimesYz timesYz = new TimesYz();
				timesYz.setPhase(numInfo.getPhase());
				timesYz.setTables("16");
				ColorYz colorYz = new ColorYz();
				colorYz.setPhase(numInfo.getPhase());
				colorYz.setTables("16");
				PickNumPayload payload = mapper.readValue(numInfo.getPayload(), PickNumPayload.class);
				PickNumCountInfo tmInfo = null;
				for (PickNumCountInfo info : payload.getInfos()) {
					if (numInfo.getTm() == info.getNum()) {
						tmInfo = info;
						break;
					}
				}
				String color = null;
				switch (tmInfo.getCount()) {
				case 0: {
					color = "green";
					timesYz.setTime0(0);
					timesYz.setTime12(lastTimesYz.getTime12() + 1);
					timesYz.setTime3Plus(lastTimesYz.getTime3Plus() + 1);
				}
					break;
				case 1:
				case 2: {
					color = "red";
					timesYz.setTime0(lastTimesYz.getTime0() + 1);
					timesYz.setTime12(0);
					timesYz.setTime3Plus(lastTimesYz.getTime3Plus() + 1);
				}
					break;
				default: {
					color = "green";
					timesYz.setTime0(lastTimesYz.getTime0() + 1);
					timesYz.setTime12(lastTimesYz.getTime12() + 1);
					timesYz.setTime3Plus(0);
				}
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

				lastColorYz = colorYz;
				colorYzList.add(colorYz);
			}
			// if (pResult.hasNext()) {
			// pageable = pageable.next();
			// }
			// } while (pResult.hasNext());
			timesYzRepository.deleteAll();
			colorYzRepository.deleteAll();
			timesYzRepository.saveAll(timesYzList);
			colorYzRepository.saveAll(colorYzList);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			t = e;
		}
		return new AsyncResult<Exception>(t);
	}

}
