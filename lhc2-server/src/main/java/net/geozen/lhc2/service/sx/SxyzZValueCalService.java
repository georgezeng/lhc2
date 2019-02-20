package net.geozen.lhc2.service.sx;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.def.jpa.BaseYzRepository;
import net.geozen.lhc2.domain.sx.Sxsw;
import net.geozen.lhc2.domain.sx.Sxyz;
import net.geozen.lhc2.enums.SX;
import net.geozen.lhc2.jpa.sx.SxswRepository;
import net.geozen.lhc2.jpa.sx.SxyzRepository;
import net.geozen.lhc2.nums.SxNums;
import net.geozen.lhc2.service.base.BaseYzZValueCalService;
import net.geozen.lhc2.utils.SxUtil;

@Service
public class SxyzZValueCalService extends BaseYzZValueCalService<SX, Sxyz, Sxsw> {
	@Autowired
	private SxyzRepository yzRepository;
	@Autowired
	private SxswRepository swRepository;

	@Override
	protected BaseYzRepository<Sxyz> getYzRepository() {
		return yzRepository;
	}

	@Override
	protected BaseSwRepository<Sxsw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<SX> getColumns() throws Exception {
		return SX.list();
	}

	@Override
	protected String getColumnName(SX o) {
		return o.getColumn();
	}

	@Override
	protected List<Integer> getNums(SX max) {
//		SX bmnSx = SxUtil.getSxByYear(new Date());
//		return SxUtil.getSxNums(bmnSx, max);
		return SxNums.LISTS.get(max.getNumsPos());
	}

	@Override
	protected int getEndPos() {
		return 12;
	}

}
