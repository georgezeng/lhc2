package net.geozen.lhc2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import lombok.Getter;
import net.geozen.lhc2.jpa.ColorYz2Repository;
import net.geozen.lhc2.jpa.ColorYzRepository;
import net.geozen.lhc2.jpa.TimesYzRepository;
import net.geozen.lhc2.service.bs.BsyzCalculationService;
import net.geozen.lhc2.service.ds.DsyzCalculationService;
import net.geozen.lhc2.service.dxds.Dxds1ayzCalculationService;
import net.geozen.lhc2.service.dxds.Dxds1byzCalculationService;
import net.geozen.lhc2.service.dxds.Dxds2yzCalculationService;
import net.geozen.lhc2.service.fd.FdyzCalculationService;
import net.geozen.lhc2.service.hs.HsyzCalculationService;
import net.geozen.lhc2.service.mw.MwyzCalculationService;
import net.geozen.lhc2.service.pd.PdyzCalculationService;
import net.geozen.lhc2.service.qq.QqyzCalculationService;
import net.geozen.lhc2.service.seq.SeqyzCalculationService;
import net.geozen.lhc2.service.slq.a.SlqayzCalculationService;
import net.geozen.lhc2.service.slq.b.SlqbyzCalculationService;
import net.geozen.lhc2.service.slq.bs.SlqbsyzCalculationService;
import net.geozen.lhc2.service.slq.c.SlqcyzCalculationService;
import net.geozen.lhc2.service.slq.d.SlqdyzCalculationService;
import net.geozen.lhc2.service.slq.wx.SlqwxyzCalculationService;
import net.geozen.lhc2.service.slq.zs.SlqzsyzCalculationService;
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
	private SlqayzCalculationService slqaService;

	@Autowired
	private SlqbyzCalculationService slqbService;

	@Autowired
	private SlqcyzCalculationService slqcService;

	@Autowired
	private SlqdyzCalculationService slqdService;
	
	@Autowired
	private SlqbsyzCalculationService slqbsService;
	
	@Autowired
	private SlqwxyzCalculationService slqwxService;
	
	@Autowired
	private SlqzsyzCalculationService slqzsService;

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
	private Dxds1ayzCalculationService dxds1aService;

	@Autowired
	private Dxds1byzCalculationService dxds1bService;

	@Autowired
	private Dxds2yzCalculationService dxds2Service;

	@Autowired
	private PickNumFacade pickNumFacade;

	@Autowired
	private CombineService combineService;

	@Autowired
	private TimesColorService timeService;
	
	@Autowired
	private ZValueCalService zvalueCalService;
	
	@Autowired
	private TimesYzRepository timesYzRepository;

	@Autowired
	private ColorYzRepository colorYzRepository;

	@Autowired
	private ColorYz2Repository colorYz2Repository;

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
		futures.add(slqaService.process());
		futures.add(slqbService.process());
		futures.add(slqcService.process());
		futures.add(slqdService.process());
		futures.add(slqbsService.process());
		futures.add(slqwxService.process());
		futures.add(slqzsService.process());
		futures.add(pdService.process());
		futures.add(z2Service.process());
		futures.add(z7Service.process());
		futures.add(z13Service.process());
		futures.add(dsService.process());
		futures.add(fdService.process());
		futures.add(dxds1aService.process());
		futures.add(dxds2Service.process());

		List<String> errors = new ArrayList<>();
		CommonUtil.waitWithException(futures, ex -> {
			errors.add(ex.getMessage());
		});

		if (errors.isEmpty()) {
			futures.clear();
			futures.add(dxds1bService.process());
			CommonUtil.waitWithException(futures, ex -> {
				errors.add(ex.getMessage());
			});
			if (errors.isEmpty()) {
				summary(errors);
			}
		}

		return new AsyncResult<>(errors);
	}

	public void summary(List<String> errors) throws Exception {
		List<Future<Exception>> futures = new ArrayList<>();
		futures.add(combineService.process());
		pickNumFacade.process(futures);
		zvalueCalService.process();

		CommonUtil.waitWithException(futures, ex -> {
			errors.add(ex.getMessage());
		});

		if (errors.isEmpty()) {
			futures.clear();
			
			timesYzRepository.deleteAll();
			colorYzRepository.deleteAll();
			colorYz2Repository.deleteAll();
			
//			futures.add(timeService.process(10, "P1"));
//			futures.add(timeService.process(16, "P1"));
			
//			futures.add(timeService.process(33, "P2"));
//			futures.add(timeService.process(24, "P2"));
//			futures.add(timeService.process(20, "P2"));
//			futures.add(timeService.process(12, "P2"));
//			futures.add(timeService.process(10, "P2"));
//			futures.add(timeService.process(8, "P2"));
//			futures.add(timeService.process(4, "P2"));
			
			
//			futures.add(timeService.process(16, "P2"));
//			futures.add(timeService.process(1, "P2"));
			
			futures.add(timeService.process(16, "P3"));
//			futures.add(timeService.process(4, "P3"));
			
//			futures.add(timeService.process(8, "P3"));
//			futures.add(timeService.process(4, "P3"));
//			futures.add(timeService.process(3, "P3"));
//			futures.add(timeService.process(2, "P3"));
			CommonUtil.waitWithException(futures, ex -> {
				errors.add(ex.getMessage());
			});
		}
	}

}
