package net.geozen.lhc2.service.slq.c;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.c.Slqcsw;
import net.geozen.lhc2.domain.slq.c.Slqcyz;
import net.geozen.lhc2.jpa.slq.c.SlqcswRepository;
import net.geozen.lhc2.jpa.slq.c.SlqcyzRepository;
import net.geozen.lhc2.nums.SlqcNums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class SlqcyzZValueCalService extends BaseYzZValueCalService<Integer, Slqcyz, Slqcsw> {
	@Autowired
	private SlqcyzRepository yzRepository;
	@Autowired
	private SlqcswRepository swRepository;

	@Override
	protected BaseYzRepository<Slqcyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Slqcsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return SlqcNums.LISTS.get(pos);
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
