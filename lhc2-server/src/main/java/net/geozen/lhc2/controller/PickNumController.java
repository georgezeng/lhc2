package net.geozen.lhc2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.geozen.lhc2.domain.PickNum;
import net.geozen.lhc2.dto.PageResult;
import net.geozen.lhc2.dto.PickNumPayload;
import net.geozen.lhc2.dto.QueryInfo;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.PickNumRepository;

@RestController
@Transactional
@RequestMapping(value = "/pickNum")
public class PickNumController {
	@Autowired
	private PickNumRepository pickNumRepository;

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Result<PageResult<PickNumPayload>> list(@RequestBody QueryInfo<PickNum> queryInfo) throws Exception {
		ObjectMapper map = new ObjectMapper();
		Page<PickNum> result = pickNumRepository.findAllByExpectedAndType(queryInfo.getData().getExpected(), queryInfo.getData().getType(),
				queryInfo.getPage().pageable());
		List<PickNumPayload> payloads = new ArrayList<>();
		for (PickNum num : result.getContent()) {
			PickNumPayload payload = map.readValue(num.getPayload(), PickNumPayload.class);
			payload.setPhase(num.getPhase() + "");
			payloads.add(payload);
		}
		return Result.genSuccessResult(new PageResult<>(payloads, result.getTotalElements()));
	}

}
