package net.geozen.lhc2.service.slq.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.a.Slqasw;
import net.geozen.lhc2.domain.slq.a.Slqayz;
import net.geozen.lhc2.domain.slq.a.Slqazf;
import net.geozen.lhc2.jpa.slq.a.SlqaswRepository;
import net.geozen.lhc2.jpa.slq.a.SlqayzRepository;
import net.geozen.lhc2.jpa.slq.a.SlqazfRepository;
import net.geozen.lhc2.nums.SlqaNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class SlqazfZValueCalService extends BaseZfZValueCalService<Slqayz, Slqazf, Slqasw> {
	@Autowired
	private SlqayzRepository yzRepository;
	@Autowired
	private SlqazfRepository zfRepository;
	@Autowired
	private SlqaswRepository swRepository;

	@Override
	protected BaseYzRepository<Slqayz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Slqazf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Slqasw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 16;
	}

	@Override
	protected Class<?> getNumsClass() {
		return SlqaNums.class;
	}

}
