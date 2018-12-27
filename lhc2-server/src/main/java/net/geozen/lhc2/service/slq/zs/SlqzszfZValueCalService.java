package net.geozen.lhc2.service.slq.zs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.zs.Slqzssw;
import net.geozen.lhc2.domain.slq.zs.Slqzsyz;
import net.geozen.lhc2.domain.slq.zs.Slqzszf;
import net.geozen.lhc2.jpa.slq.zs.SlqzsswRepository;
import net.geozen.lhc2.jpa.slq.zs.SlqzsyzRepository;
import net.geozen.lhc2.jpa.slq.zs.SlqzszfRepository;
import net.geozen.lhc2.nums.SlqzsNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class SlqzszfZValueCalService extends BaseZfZValueCalService<Slqzsyz, Slqzszf, Slqzssw> {
	@Autowired
	private SlqzsyzRepository yzRepository;
	@Autowired
	private SlqzszfRepository zfRepository;
	@Autowired
	private SlqzsswRepository swRepository;

	@Override
	protected BaseYzRepository<Slqzsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Slqzszf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Slqzssw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 16;
	}

	@Override
	protected Class<?> getNumsClass() {
		return SlqzsNums.class;
	}

}
