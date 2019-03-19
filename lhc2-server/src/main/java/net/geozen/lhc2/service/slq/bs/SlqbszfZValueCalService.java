package net.geozen.lhc2.service.slq.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.bs.Slqbssw;
import net.geozen.lhc2.domain.slq.bs.Slqbsyz;
import net.geozen.lhc2.domain.slq.bs.Slqbszf;
import net.geozen.lhc2.jpa.slq.bs.SlqbsswRepository;
import net.geozen.lhc2.jpa.slq.bs.SlqbsyzRepository;
import net.geozen.lhc2.jpa.slq.bs.SlqbszfRepository;
import net.geozen.lhc2.nums.SlqbsNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class SlqbszfZValueCalService extends BaseZfZValueCalService<Slqbsyz, Slqbszf, Slqbssw> {
	@Autowired
	private SlqbsyzRepository yzRepository;
	@Autowired
	private SlqbszfRepository zfRepository;
	@Autowired
	private SlqbsswRepository swRepository;

	@Override
	protected BaseYzRepository<Slqbsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Slqbszf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Slqbssw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 16;
	}

	@Override
	protected Class<?> getNumsClass() {
		return SlqbsNums.class;
	}

	@Override
	protected String[] getFields() {
		return new String[] { "zf0", "zf1", "zf2", "zf3", "zf4", "zf5", "zf6", "zf7", "zf8", "zf9", "zf10", "zf11", "zf12", "zf13", "zf14", "zf15" };
	}

}
