package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaSw;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaYz;
import net.geozen.lhc3.domain.seqa.Lhc3SeqaZf;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaSwRepository;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaYzRepository;
import net.geozen.lhc3.jpa.seqa.Lhc3SeqaZfRepository;
import net.geozen.lhc3.nums.SeqaNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqaService extends Lhc3BaseService<Lhc3SeqaYz, Lhc3SeqaZf, Lhc3SeqaSw> {
	@Autowired
	private Lhc3SeqaYzRepository yzRepository;
	@Autowired
	private Lhc3SeqaZfRepository zfRepository;
	@Autowired
	private Lhc3SeqaSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqaNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqaYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqaZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqaSw> getSwRepository() {
		return swRepository;
	}
}
