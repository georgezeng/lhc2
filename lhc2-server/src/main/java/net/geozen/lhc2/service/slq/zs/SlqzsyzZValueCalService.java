package net.geozen.lhc2.service.slq.zs;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.zs.Slqzssw;
import net.geozen.lhc2.domain.slq.zs.Slqzsyz;
import net.geozen.lhc2.jpa.slq.zs.SlqzsswRepository;
import net.geozen.lhc2.jpa.slq.zs.SlqzsyzRepository;
import net.geozen.lhc2.nums.SlqzsNums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class SlqzsyzZValueCalService extends BaseYzZValueCalService<Integer, Slqzsyz, Slqzssw> {
	@Autowired
	private SlqzsyzRepository yzRepository;
	@Autowired
	private SlqzsswRepository swRepository;

	@Override
	protected BaseYzRepository<Slqzsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Slqzssw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SlqzsNums.LISTS.get(pos);
	}

	@Override
	protected int getEndPos() {
		return 16;
	}

	@Override
	protected String[] getFields() {
		return new String[] { "w0", "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11", "w12", "w13", "w14", "w15" };
	}

}
