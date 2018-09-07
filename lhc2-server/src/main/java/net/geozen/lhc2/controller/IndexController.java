package net.geozen.lhc2.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Future;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.Sxsw;
import net.geozen.lhc2.domain.Sxyz;
import net.geozen.lhc2.domain.Sxzf;
import net.geozen.lhc2.domain.Tm;
import net.geozen.lhc2.dto.PageResult;
import net.geozen.lhc2.dto.QueryInfo;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.enums.SX;
import net.geozen.lhc2.jpa.SxswRepository;
import net.geozen.lhc2.jpa.SxyzRepository;
import net.geozen.lhc2.jpa.SxzfRepository;
import net.geozen.lhc2.jpa.TmRepository;
import net.geozen.lhc2.service.CalculationService;

@RestController
@Transactional
public class IndexController {
	@Autowired
	private TmRepository tmRepository;

	@Autowired
	private SxyzRepository sxyzRepository;

	@Autowired
	private SxzfRepository sxzfRepository;
	
	@Autowired
	private SxswRepository sxswRepository;

	@Autowired
	private CalculationService calService;

	@Autowired
	private EntityManager em;

	@RequestMapping(value = "/tm/save", method = RequestMethod.POST)
	public void save(@RequestBody Tm data) {
		if (data.getId() != null) {
			data = em.merge(data);
		}
		em.persist(data);
	}

	@RequestMapping(value = "/tm/list", method = RequestMethod.POST)
	public Result<PageResult<Tm>> list(@RequestBody QueryInfo<String> queryInfo) {
		Page<Tm> result = tmRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/tm/{id}/delete", method = RequestMethod.GET)
	public void delete(@PathVariable("id") Long id) {
		Optional<Tm> result = tmRepository.findById(id);
		if (result.isPresent()) {
			tmRepository.delete(result.get());
		}
	}

	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public void calculate() {
		calService.process();
	}

	@RequestMapping(value = "/calculation/status", method = RequestMethod.GET)
	public Result<Map<String, Object>> calculationStatus() throws Exception {
		int count = 0;
		Map<String, Object> result = new HashMap<>();
		List<String> errors = new ArrayList<>();
		for (Future<Exception> f : calService.getFutures()) {
			if (f.isDone()) {
				if (f.get() != null) {
					errors.add(f.get().getMessage());
				}
				count++;
			}
		}
		result.put("errors", errors);
		result.put("finished", count == calService.getFutures().size());
		return Result.genSuccessResult(result);
	}

	@RequestMapping(value = "/sxList", method = RequestMethod.GET)
	public Result<List<SX>> sxList() {
		return Result.genSuccessResult(Arrays.asList(SX.seq()));
	}

	@RequestMapping(value = "/sx/yz/list", method = RequestMethod.GET)
	public Result<Iterable<Sxyz>> sxyzList() {
		return Result.genSuccessResult(sxyzRepository.findAll());
	}

	@RequestMapping(value = "/sx/zf/list", method = RequestMethod.GET)
	public Result<Iterable<Sxzf>> sxzfList() {
		return Result.genSuccessResult(sxzfRepository.findAll());
	}
	
	@RequestMapping(value = "/sx/sw/list", method = RequestMethod.GET)
	public Result<Iterable<Sxsw>> sxswList() {
		return Result.genSuccessResult(sxswRepository.findAll());
	}
}
