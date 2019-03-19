package net.geozen.lhc2.service.pd;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.pd.Pdsw;
import net.geozen.lhc2.domain.pd.Pdyz;
import net.geozen.lhc2.jpa.pd.PdswRepository;
import net.geozen.lhc2.jpa.pd.PdyzRepository;
import net.geozen.lhc2.nums.PdNums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class PdyzZValueCalService extends BaseYzZValueCalService<Integer, Pdyz, Pdsw> {
	@Autowired
	private PdyzRepository yzRepository;
	@Autowired
	private PdswRepository swRepository;

	@Override
	protected BaseYzRepository<Pdyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Pdsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return PdNums.LISTS.get(pos);
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
