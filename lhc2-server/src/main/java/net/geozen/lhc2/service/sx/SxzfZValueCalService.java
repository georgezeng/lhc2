package net.geozen.lhc2.service.sx;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.def.jpa.BaseZfRepository;
import net.geozen.lhc2.domain.sx.Sxsw;
import net.geozen.lhc2.domain.sx.Sxyz;
import net.geozen.lhc2.domain.sx.Sxzf;
import net.geozen.lhc2.dto.MaxInfo;
import net.geozen.lhc2.enums.SX;
import net.geozen.lhc2.jpa.sx.SxswRepository;
import net.geozen.lhc2.jpa.sx.SxyzRepository;
import net.geozen.lhc2.jpa.sx.SxzfRepository;
import net.geozen.lhc2.nums.SxNums;
import net.geozen.lhc2.service.base.BaseZfZValueCalService;
import net.geozen.lhc2.utils.SxUtil;

@Service
public class SxzfZValueCalService extends BaseZfZValueCalService<Sxyz, Sxzf, Sxsw> {
	@Autowired
	private SxyzRepository yzRepository;
	@Autowired
	private SxzfRepository zfRepository;
	@Autowired
	private SxswRepository swRepository;

	@Override
	protected BaseZfRepository<Sxzf> getZfRepository() {
		return zfRepository;
	}

	@Override
	protected BaseSwRepository<Sxsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected BaseYzRepository<Sxyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected int getEndPos() {
		return 12;
	}

	@Override
	protected Class<?> getNumsClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Integer> getNums(Class<?> numsClass, MaxInfo info) throws Exception {
		int endPos = 12;
		Sxyz yz = yzRepository.findByPhase(info.getPhase());
		int pos = yz.getSx().getPos() + info.getPos();
		if (pos >= endPos) {
			pos = pos - endPos;
		}
//		SX bmnSx = SxUtil.getSxByYear(new Date());
//		return SxUtil.getSxNums(bmnSx, SX.posOf(pos + 1));
		return SxNums.LISTS.get(SX.posOf(pos + 1).getNumsPos());
	}

}
