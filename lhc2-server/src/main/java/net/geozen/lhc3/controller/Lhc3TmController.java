package net.geozen.lhc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.PageResult;
import net.geozen.lhc2.dto.QueryInfo;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.jpa.Lhc3TmRepository;

@RestController
@Transactional
@RequestMapping(value = "/lhc3/tm")
public class Lhc3TmController {
	@Autowired
	private Lhc3TmRepository tmRepository;

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3Tm>> list(@RequestBody QueryInfo<String> queryInfo) {
		Page<Lhc3Tm> result = tmRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

}
