package net.geozen.lhc3.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc3.domain.Lhc3Stake;
import net.geozen.lhc3.jpa.Lhc3StakeRepository;

@RestController
@Transactional
@RequestMapping(value = "/lhc3")
public class Lhc3StakeController {
	@Autowired
	private Lhc3StakeRepository repository;

	@RequestMapping(value = "/stake/{type}")
	public Result<Lhc3Stake> stake(@PathVariable String type) throws Exception {
		Optional<Lhc3Stake> result = repository.findFirstByTypeOrderByPhaseDesc(type);
		return Result.genSuccessResult(result.orElse(null));
	}

}
