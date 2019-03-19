package net.geozen.lhc2.service.z13;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.z13.Z13sw;
import net.geozen.lhc2.domain.z13.Z13yz;
import net.geozen.lhc2.jpa.z13.Z13swRepository;
import net.geozen.lhc2.jpa.z13.Z13yzRepository;
import net.geozen.lhc2.nums.Z13Nums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class Z13yzZValueCalService extends BaseYzZValueCalService<Integer, Z13yz, Z13sw> {
	@Autowired
	private Z13yzRepository yzRepository;
	@Autowired
	private Z13swRepository swRepository;

	@Override
	protected BaseYzRepository<Z13yz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Z13sw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return Z13Nums.LISTS.get(pos);
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
