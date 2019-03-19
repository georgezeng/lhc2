package net.geozen.lhc2.service.mw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.mw.Mwsw;
import net.geozen.lhc2.domain.mw.Mwyz;
import net.geozen.lhc2.domain.mw.Mwzf;
import net.geozen.lhc2.jpa.mw.MwswRepository;
import net.geozen.lhc2.jpa.mw.MwyzRepository;
import net.geozen.lhc2.jpa.mw.MwzfRepository;
import net.geozen.lhc2.nums.MwNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class MwzfZValueCalService extends BaseZfZValueCalService<Mwyz, Mwzf, Mwsw> {
	@Autowired
	private MwyzRepository yzRepository;
	@Autowired
	private MwzfRepository zfRepository;
	@Autowired
	private MwswRepository swRepository;

	@Override
	protected BaseYzRepository<Mwyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Mwzf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Mwsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 10;
	}

	@Override
	protected Class<?> getNumsClass() {
		return MwNums.class;
	}

	@Override
	protected String[] getFields() {
		return new String[] { "zf0", "zf1", "zf2", "zf3", "zf4", "zf5", "zf6", "zf7", "zf8", "zf9", "zf10", "zf11" };
	}

}
