package net.geozen.lhc2.service.seq;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.seq.Seqsw;
import net.geozen.lhc2.domain.seq.Seqyz;
import net.geozen.lhc2.jpa.seq.SeqswRepository;
import net.geozen.lhc2.jpa.seq.SeqyzRepository;
import net.geozen.lhc2.nums.SeqNums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class SeqyzZValueCalService extends BaseYzZValueCalService<Integer, Seqyz, Seqsw> {
	@Autowired
	private SeqyzRepository yzRepository;
	@Autowired
	private SeqswRepository swRepository;

	@Override
	protected BaseYzRepository<Seqyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Seqsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SeqNums.LISTS.get(pos);
	}

	@Override
	protected int getEndPos() {
		return 12;
	}

	@Override
	protected String[] getFields() {
		return new String[] { "w0", "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11" };
	}


}
