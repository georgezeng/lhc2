package net.geozen.lhc2.service.slq.d;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.d.Slqdsw;
import net.geozen.lhc2.domain.slq.d.Slqdyz;
import net.geozen.lhc2.domain.slq.d.Slqdzf;
import net.geozen.lhc2.jpa.slq.d.SlqdswRepository;
import net.geozen.lhc2.jpa.slq.d.SlqdyzRepository;
import net.geozen.lhc2.jpa.slq.d.SlqdzfRepository;
import net.geozen.lhc2.nums.SlqdNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class SlqdzfZValueCalService extends BaseZfZValueCalService<Slqdyz, Slqdzf, Slqdsw> {
	@Autowired
	private SlqdyzRepository yzRepository;
	@Autowired
	private SlqdzfRepository zfRepository;
	@Autowired
	private SlqdswRepository swRepository;

	@Override
	protected BaseYzRepository<Slqdyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Slqdzf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Slqdsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 16;
	}

	@Override
	protected Class<?> getNumsClass() {
		return SlqdNums.class;
	}

}
