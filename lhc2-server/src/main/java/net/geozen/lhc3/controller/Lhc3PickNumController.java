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
import net.geozen.lhc3.domain.Lhc3PickNum;
import net.geozen.lhc3.jpa.Lhc3PickNumRepository;

@RestController
@Transactional
@RequestMapping(value = "/lhc3/pickNum")
public class Lhc3PickNumController {
	@Autowired
	private Lhc3PickNumRepository pickNumRepository;

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Result<PageResult<Lhc3PickNum>> list(@RequestBody QueryInfo<Lhc3PickNum> queryInfo) throws Exception {
		Page<Lhc3PickNum> result = pickNumRepository.findAllByExpectedAndType(queryInfo.getData().getExpected(), queryInfo.getData().getType(),
				queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

}
