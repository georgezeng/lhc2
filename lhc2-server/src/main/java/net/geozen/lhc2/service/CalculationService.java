package net.geozen.lhc2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import lombok.Getter;
import net.geozen.lhc2.service.bs.BsyzCalculationService;
import net.geozen.lhc2.service.ds.DsyzCalculationService;
import net.geozen.lhc2.service.fd.FdyzCalculationService;
import net.geozen.lhc2.service.hs.HsyzCalculationService;
import net.geozen.lhc2.service.mw.MwyzCalculationService;
import net.geozen.lhc2.service.pd.PdyzCalculationService;
import net.geozen.lhc2.service.qq.QqyzCalculationService;
import net.geozen.lhc2.service.seq.SeqyzCalculationService;
import net.geozen.lhc2.service.slq.SlqyzCalculationService;
import net.geozen.lhc2.service.sw.SwyzCalculationService;
import net.geozen.lhc2.service.sx.SxyzCalculationService;
import net.geozen.lhc2.service.z13.Z13yzCalculationService;
import net.geozen.lhc2.service.z2.Z2yzCalculationService;
import net.geozen.lhc2.service.z7.Z7yzCalculationService;
import net.geozen.lhc2.service.zs.ZsyzCalculationService;
import net.geozen.lhc2.utils.CommonUtil;

@Service
@Getter
public class CalculationService {

	@Autowired
	private SxyzCalculationService sxService;

	@Autowired
	private SwyzCalculationService swService;

	@Autowired
	private MwyzCalculationService mwService;

	@Autowired
	private HsyzCalculationService hsService;

	@Autowired
	private BsyzCalculationService bsService;

	@Autowired
	private ZsyzCalculationService zsService;

	@Autowired
	private QqyzCalculationService qqService;

	@Autowired
	private SeqyzCalculationService seqService;

	@Autowired
	private SlqyzCalculationService slqService;

	@Autowired
	private PdyzCalculationService pdService;

	@Autowired
	private Z2yzCalculationService z2Service;

	@Autowired
	private Z7yzCalculationService z7Service;

	@Autowired
	private Z13yzCalculationService z13Service;

	@Autowired
	private DsyzCalculationService dsService;

	@Autowired
	private FdyzCalculationService fdService;

	@Autowired
	private PickNumFacade pickNumFacade;

	@Autowired
	private CombineService combineService;

	@Autowired
	private TimesService timeService;

	@Async
	public Future<List<String>> process() throws Exception {
		List<Future<Exception>> futures = new ArrayList<>();
		futures.add(sxService.process());
		futures.add(swService.process());
		futures.add(mwService.process());
		futures.add(hsService.process());
		futures.add(bsService.process());
		futures.add(zsService.process());
		futures.add(qqService.process());
		futures.add(seqService.process());
		futures.add(slqService.process());
		futures.add(pdService.process());
		futures.add(z2Service.process());
		futures.add(z7Service.process());
		futures.add(z13Service.process());
		futures.add(dsService.process());
		futures.add(fdService.process());

		List<String> errors = new ArrayList<>();
		CommonUtil.waitWithException(futures, ex -> {
			errors.add(ex.getMessage());
		});

		if (errors.isEmpty()) {
			summary(errors);
		}

		return new AsyncResult<>(errors);
	}

	public void summary(List<String> errors) throws Exception {
		List<Future<Exception>> futures = new ArrayList<>();
		futures.add(combineService.process());
		pickNumFacade.process(futures);

		CommonUtil.waitWithException(futures, ex -> {
			errors.add(ex.getMessage());
		});
	}

}
