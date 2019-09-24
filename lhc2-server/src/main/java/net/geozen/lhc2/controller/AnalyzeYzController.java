package net.geozen.lhc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.AnalyzeYz;
import net.geozen.lhc2.dto.PageResult;
import net.geozen.lhc2.dto.QueryInfo;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.AnalyzeYzRepository;

@RestController
@Transactional
@RequestMapping(value = "/analyze")
public class AnalyzeYzController {
	@Autowired
	private AnalyzeYzRepository repository;

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Result<PageResult<AnalyzeYz>> list(@RequestBody QueryInfo<AnalyzeYz> queryInfo) throws Exception {
		Page<AnalyzeYz> result = repository.findAllByExpectedAndType(queryInfo.getData().getExpected(), queryInfo.getData().getType(),
				queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

}
