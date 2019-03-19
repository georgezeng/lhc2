package net.geozen.lhc2.service.seq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.seq.Seqsw;
import net.geozen.lhc2.domain.seq.Seqyz;
import net.geozen.lhc2.domain.seq.Seqzf;
import net.geozen.lhc2.jpa.seq.SeqswRepository;
import net.geozen.lhc2.jpa.seq.SeqyzRepository;
import net.geozen.lhc2.jpa.seq.SeqzfRepository;
import net.geozen.lhc2.nums.SeqNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class SeqzfZValueCalService extends BaseZfZValueCalService<Seqyz, Seqzf, Seqsw> {
	@Autowired
	private SeqyzRepository yzRepository;
	@Autowired
	private SeqzfRepository zfRepository;
	@Autowired
	private SeqswRepository swRepository;

	@Override
	protected BaseYzRepository<Seqyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Seqzf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Seqsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 12;
	}

	@Override
	protected Class<?> getNumsClass() {
		return SeqNums.class;
	}

	@Override
	protected String[] getFields() {
		return new String[] { "zf0", "zf1", "zf2", "zf3", "zf4", "zf5", "zf6", "zf7", "zf8", "zf9", "zf10", "zf11" };
	}

}
