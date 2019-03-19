package net.geozen.lhc2.service.z7;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.z7.Z7sw;
import net.geozen.lhc2.domain.z7.Z7yz;
import net.geozen.lhc2.jpa.z7.Z7swRepository;
import net.geozen.lhc2.jpa.z7.Z7yzRepository;
import net.geozen.lhc2.nums.Z7Nums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class Z7yzZValueCalService extends BaseYzZValueCalService<Integer, Z7yz, Z7sw> {
	@Autowired
	private Z7yzRepository yzRepository;
	@Autowired
	private Z7swRepository swRepository;

	@Override
	protected BaseYzRepository<Z7yz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Z7sw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return Z7Nums.LISTS.get(pos);
	}

	@Override
	protected int getEndPos() {
		return 10;
	}

	@Override
	protected String[] getFields() {
		return new String[] { "w0", "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11" };
	}

}
