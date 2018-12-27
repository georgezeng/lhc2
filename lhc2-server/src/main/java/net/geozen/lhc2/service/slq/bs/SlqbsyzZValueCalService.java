package net.geozen.lhc2.service.slq.bs;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.bs.Slqbssw;
import net.geozen.lhc2.domain.slq.bs.Slqbsyz;
import net.geozen.lhc2.jpa.slq.bs.SlqbsswRepository;
import net.geozen.lhc2.jpa.slq.bs.SlqbsyzRepository;
import net.geozen.lhc2.nums.SlqbsNums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class SlqbsyzZValueCalService extends BaseYzZValueCalService<Integer, Slqbsyz, Slqbssw> {
	@Autowired
	private SlqbsyzRepository yzRepository;
	@Autowired
	private SlqbsswRepository swRepository;

	@Override
	protected BaseYzRepository<Slqbsyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Slqbssw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
	}

	@Override
	protected List<Integer> getNums(Integer max) {
		return SlqbsNums.LISTS.get(max);
	}

	@Override
	protected int getEndPos() {
		return 16;
	}

}
