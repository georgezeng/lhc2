package net.geozen.lhc2.controller;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.geozen.lhc2.domain.Tm;
import net.geozen.lhc2.dto.PageInfo;
import net.geozen.lhc2.dto.PageResult;
import net.geozen.lhc2.dto.QueryInfo;
import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.jpa.TmRepository;

@RestController
@Transactional
@RequestMapping(value = "/tm")
public class TmController {
	@Autowired
	private TmRepository tmRepository;

	@Autowired
	private EntityManager em;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@RequestBody Tm data) {
		if (data.getId() != null) {
			data = em.merge(data);
		}
		em.persist(data);
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Result<PageResult<Tm>> list(@RequestBody QueryInfo<String> queryInfo) {
		Page<Tm> result = tmRepository.findAll(queryInfo.getPage().pageable());
		return Result.genSuccessResult(new PageResult<>(result.getContent(), result.getTotalElements()));
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public void delete(@PathVariable("id") Long id) {
		Optional<Tm> result = tmRepository.findById(id);
		if (result.isPresent()) {
			tmRepository.delete(result.get());
		}
	}

	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	public void clear() {
		tmRepository.deleteAll();
	}

	@RequestMapping(value = "/clear", method = RequestMethod.POST)
	public void clearPage(@RequestBody PageInfo pageInfo) {
		Page<Tm> result = tmRepository.findAll(pageInfo.pageable());
		tmRepository.deleteAll(result.getContent());
	}

}
