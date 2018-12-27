package net.geozen.lhc2.service.slq.a;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.a.Slqasw;
import net.geozen.lhc2.domain.slq.a.Slqayz;
import net.geozen.lhc2.jpa.slq.a.SlqaswRepository;
import net.geozen.lhc2.jpa.slq.a.SlqayzRepository;
import net.geozen.lhc2.nums.SlqaNums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class SlqayzZValueCalService extends BaseYzZValueCalService<Integer, Slqayz, Slqasw> {
	@Autowired
	private SlqayzRepository yzRepository;
	@Autowired
	private SlqaswRepository swRepository;

	@Override
	protected BaseYzRepository<Slqayz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Slqasw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
	}

	@Override
	protected List<Integer> getNums(Integer max) {
		return SlqaNums.LISTS.get(max);
	}

	@Override
	protected int getEndPos() {
		return 16;
	}

}
