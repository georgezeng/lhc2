package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.PageResult;
import net.geozen.lhc2.dto.QueryInfo;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.fd.Lhc3FdSw;
import net.geozen.lhc3.domain.fd.Lhc3FdYz;
import net.geozen.lhc3.jpa.fd.Lhc3FdSwRepository;
import net.geozen.lhc3.jpa.fd.Lhc3FdYzRepository;

@RestController
@RequestMapping(value = "/lhc3/fd")
public class Lhc3FdController {

	@Autowired
	private Lhc3FdYzRepository yzRepository;

	@Autowired
	private Lhc3FdSwRepository swRepository;

	@RequestMapping(value = "/yz/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3FdYz>> yzList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3FdYz> result = yzRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	public Result<PageResult<Lhc3FdSw>> swList(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3FdSw> result = swRepository.findAll(queryInfo.getPage().pageable());
		if (queryInfo.getPage().getNum() == 1 && result.hasContent()) {
			Lhc3FdSw first = result.getContent().get(0);

			Lhc3FdSw topForTotal = new Lhc3FdSw();
			topForTotal.setPhase("遗值和(无限制)");
			topForTotal.setW1(first.getT1());
			topForTotal.setW2(first.getT2());
			topForTotal.setW3(first.getT3());
			topForTotal.setW4(first.getT4());
			topForTotal.setW5(first.getT5());
			topForTotal.setW6(first.getT6());
			topForTotal.setW7(first.getT7());
			topForTotal.setW8(first.getT8());
			topForTotal.setW9(first.getT9());
			topForTotal.setW10(first.getT10());
			topForTotal.setW11(first.getT11());
			topForTotal.setW12(first.getT12());
			result.getContent().add(0, topForTotal);

			Lhc3FdSw topForLimitedTotal = new Lhc3FdSw();
			topForLimitedTotal.setPhase("遗值和(有限制)");
			topForLimitedTotal.setW1(first.getLt1());
			topForLimitedTotal.setW2(first.getLt2());
			topForLimitedTotal.setW3(first.getLt3());
			topForLimitedTotal.setW4(first.getLt4());
			topForLimitedTotal.setW5(first.getLt5());
			topForLimitedTotal.setW6(first.getLt6());
			topForLimitedTotal.setW7(first.getLt7());
			topForLimitedTotal.setW8(first.getLt8());
			topForLimitedTotal.setW9(first.getLt9());
			topForLimitedTotal.setW10(first.getLt10());
			topForLimitedTotal.setW11(first.getLt11());
			topForLimitedTotal.setW12(first.getLt12());
			result.getContent().add(0, topForLimitedTotal);
		}
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

}
