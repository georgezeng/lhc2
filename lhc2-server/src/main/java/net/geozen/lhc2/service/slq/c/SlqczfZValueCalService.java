package net.geozen.lhc2.service.slq.c;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.c.Slqcsw;
import net.geozen.lhc2.domain.slq.c.Slqcyz;
import net.geozen.lhc2.domain.slq.c.Slqczf;
import net.geozen.lhc2.jpa.slq.c.SlqcswRepository;
import net.geozen.lhc2.jpa.slq.c.SlqcyzRepository;
import net.geozen.lhc2.jpa.slq.c.SlqczfRepository;
import net.geozen.lhc2.nums.SlqcNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class SlqczfZValueCalService extends BaseZfZValueCalService<Slqcyz, Slqczf, Slqcsw> {
	@Autowired
	private SlqcyzRepository yzRepository;
	@Autowired
	private SlqczfRepository zfRepository;
	@Autowired
	private SlqcswRepository swRepository;

	@Override
	protected BaseYzRepository<Slqcyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Slqczf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Slqcsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 16;
	}

	@Override
	protected Class<?> getNumsClass() {
		return SlqcNums.class;
	}

	@Override
	protected String[] getFields() {
		return new String[] { "zf0", "zf1", "zf2", "zf3", "zf4", "zf5", "zf6", "zf7", "zf8", "zf9", "zf10", "zf11", "zf12", "zf13", "zf14", "zf15" };
	}

}
