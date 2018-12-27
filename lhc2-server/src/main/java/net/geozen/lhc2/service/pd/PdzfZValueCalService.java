package net.geozen.lhc2.service.pd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.pd.Pdsw;
import net.geozen.lhc2.domain.pd.Pdyz;
import net.geozen.lhc2.domain.pd.Pdzf;
import net.geozen.lhc2.jpa.pd.PdswRepository;
import net.geozen.lhc2.jpa.pd.PdyzRepository;
import net.geozen.lhc2.jpa.pd.PdzfRepository;
import net.geozen.lhc2.nums.PdNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class PdzfZValueCalService extends BaseZfZValueCalService<Pdyz, Pdzf, Pdsw> {
	@Autowired
	private PdyzRepository yzRepository;
	@Autowired
	private PdzfRepository zfRepository;
	@Autowired
	private PdswRepository swRepository;

	@Override
	protected BaseYzRepository<Pdyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Pdzf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Pdsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 12;
	}

	@Override
	protected Class<?> getNumsClass() {
		return PdNums.class;
	}

}
