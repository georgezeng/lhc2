package net.geozen.lhc2.service.slq.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.slq.wx.Slqwxsw;
import net.geozen.lhc2.domain.slq.wx.Slqwxyz;
import net.geozen.lhc2.domain.slq.wx.Slqwxzf;
import net.geozen.lhc2.jpa.slq.wx.SlqwxswRepository;
import net.geozen.lhc2.jpa.slq.wx.SlqwxyzRepository;
import net.geozen.lhc2.jpa.slq.wx.SlqwxzfRepository;
import net.geozen.lhc2.nums.SlqwxNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;

@Service
public class SlqwxzfZValueCalService extends BaseZfZValueCalService<Slqwxyz, Slqwxzf, Slqwxsw> {
	@Autowired
	private SlqwxyzRepository yzRepository;
	@Autowired
	private SlqwxzfRepository zfRepository;
	@Autowired
	private SlqwxswRepository swRepository;

	@Override
	protected BaseYzRepository<Slqwxyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseZfRepository<Slqwxzf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Slqwxsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected int getEndPos() {
		return 16;
	}

	@Override
	protected Class<?> getNumsClass() {
		return SlqwxNums.class;
	}

	@Override
	protected String[] getFields() {
		return new String[] { "zf0", "zf1", "zf2", "zf3", "zf4", "zf5", "zf6", "zf7", "zf8", "zf9", "zf10", "zf11", "zf12", "zf13", "zf14", "zf15" };
	}

}
