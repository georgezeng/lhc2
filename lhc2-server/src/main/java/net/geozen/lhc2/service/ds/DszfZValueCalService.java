package net.geozen.lhc2.service.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.ds.Dssw;
import net.geozen.lhc2.domain.ds.Dsyz;
import net.geozen.lhc2.domain.ds.Dszf;
import net.geozen.lhc2.jpa.ds.DsswRepository;
import net.geozen.lhc2.jpa.ds.DsyzRepository;
import net.geozen.lhc2.jpa.ds.DszfRepository;
import net.geozen.lhc2.nums.DsNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class DszfZValueCalService extends BaseZfZValueCalService<Dsyz, Dszf, Dssw> {
	@Autowired
	private DsyzRepository yzRepository;
	@Autowired
	private DszfRepository zfRepository;
	@Autowired
	private DsswRepository swRepository;

	@Override
	protected BaseYzRepository<Dsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Dszf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Dssw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 10;
	}

	@Override
	protected Class<?> getNumsClass() {
		return DsNums.class;
	}

	@Override
	protected String[] getFields() {
		return new String[] { "zf0", "zf1", "zf2", "zf3", "zf4", "zf5", "zf6", "zf7", "zf8", "zf9" };
	}

}
