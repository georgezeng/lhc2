package net.geozen.lhc3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseSwRepository;
import net.geozen.lhc3.def.jpa.BaseYzRepository;
import net.geozen.lhc3.def.jpa.BaseZfRepository;
import net.geozen.lhc3.domain.seqi.Lhc3SeqiSw;
import net.geozen.lhc3.domain.seqi.Lhc3SeqiYz;
import net.geozen.lhc3.domain.seqi.Lhc3SeqiZf;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiSwRepository;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiYzRepository;
import net.geozen.lhc3.jpa.seqi.Lhc3SeqiZfRepository;
import net.geozen.lhc3.nums.SeqiNums;
import net.geozen.lhc3.service.base.Lhc3BaseService;

@Service
public class Lhc3SeqiService extends Lhc3BaseService<Lhc3SeqiYz, Lhc3SeqiZf, Lhc3SeqiSw> {
	@Autowired
	private Lhc3SeqiYzRepository yzRepository;
	@Autowired
	private Lhc3SeqiZfRepository zfRepository;
	@Autowired
	private Lhc3SeqiSwRepository swRepository;

	@Override
	protected List<List<Integer>> getNums() {
		return SeqiNums.LISTS;
	}

	@Override
	protected BaseYzRepository<Lhc3SeqiYz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Lhc3SeqiZf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Lhc3SeqiSw> getSwRepository() {
		return swRepository;
	}
}
