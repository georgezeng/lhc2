package net.geozen.lhc2.service.slq.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.domain.slq.wx.Slqwxsw;
import net.geozen.lhc2.domain.slq.wx.Slqwxyz;
import net.geozen.lhc2.jpa.slq.wx.SlqwxswRepository;
import net.geozen.lhc2.service.base.BaseSwCalculationService;
import net.geozen.lhc2.service.base.CalculationHandler;

@Service
public class SlqwxswCalculationService extends BaseSwCalculationService<Slqwxyz, Slqwxsw> {

	@Autowired
	private SlqwxswRepository swRepository;

	@Autowired
	private SlqwxCalculationHandler handler;

	@Override
	protected PagingAndSortingRepository<Slqwxsw, Long> getRepository() {
		return swRepository;
	}

	@Override
	protected CalculationHandler getHandler() {
		return handler;
	}

}
