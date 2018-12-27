package net.geozen.lhc2.service.slq.b;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.slq.b.Slqbsw;
import net.geozen.lhc2.domain.slq.b.Slqbyz;
import net.geozen.lhc2.jpa.slq.b.SlqbswRepository;
import net.geozen.lhc2.jpa.slq.b.SlqbyzRepository;
import net.geozen.lhc2.nums.SlqbNums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;

@Service
public class SlqbyzZValueCalService extends BaseYzZValueCalService<Integer, Slqbyz, Slqbsw> {
	@Autowired
	private SlqbyzRepository yzRepository;
	@Autowired
	private SlqbswRepository swRepository;

	@Override
	protected BaseYzRepository<Slqbyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Slqbsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getColumns() throws Exception {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
	}

	@Override
	protected List<Integer> getNums(Integer max) {
		return SlqbNums.LISTS.get(max);
	}

	@Override
	protected int getEndPos() {
		return 16;
	}

}
