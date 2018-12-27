package net.geozen.lhc2.service.slq.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.b.Slqbsw;
import net.geozen.lhc2.domain.slq.b.Slqbyz;
import net.geozen.lhc2.domain.slq.b.Slqbzf;
import net.geozen.lhc2.jpa.slq.b.SlqbswRepository;
import net.geozen.lhc2.jpa.slq.b.SlqbyzRepository;
import net.geozen.lhc2.jpa.slq.b.SlqbzfRepository;
import net.geozen.lhc2.nums.SlqbNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class SlqbzfZValueCalService extends BaseZfZValueCalService<Slqbyz, Slqbzf, Slqbsw> {
	@Autowired
	private SlqbyzRepository yzRepository;
	@Autowired
	private SlqbzfRepository zfRepository;
	@Autowired
	private SlqbswRepository swRepository;

	@Override
	protected BaseYzRepository<Slqbyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Slqbzf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Slqbsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 16;
	}

	@Override
	protected Class<?> getNumsClass() {
		return SlqbNums.class;
	}

}
