package net.geozen.lhc2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
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

@Service
@Getter
public class CalculationService {
	private final List<Future<Exception>> futures1 = new ArrayList<>();
	private final List<Future<Exception>> futures2 = new ArrayList<>();

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
	private PickNumService pickNumService;

	@Autowired
	private CombineService combineService;

//	@Async
	public void process(List<String> errors) throws Exception {
		futures1.clear();
		futures1.add(sxService.process());
		futures1.add(swService.process());
		futures1.add(mwService.process());
		futures1.add(hsService.process());
		futures1.add(bsService.process());
		futures1.add(zsService.process());
		futures1.add(qqService.process());
		futures1.add(seqService.process());
		futures1.add(slqService.process());
		futures1.add(pdService.process());
		futures1.add(z2Service.process());
		futures1.add(z7Service.process());
		futures1.add(z13Service.process());
		futures1.add(dsService.process());
		futures1.add(fdService.process());
		
		int count = 0;
		while(count < futures1.size()) {
			for (Future<Exception> f : futures1) {
				if (f.isDone()) {
					if (f.get() != null) {
						errors.add(f.get().getMessage());
						break;
					}
					count++;
				}
			}
		}
	}

	public void addFuture(Future<Exception> future) {
		futures1.add(future);
	}

	public void summary(List<String> errors) throws Exception {
		futures2.clear();
		futures2.add(combineService.process());
		futures2.add(pickNumService.process());
		
		int count = 0;
		while(count < futures2.size()) {
			for (Future<Exception> f : futures2) {
				if (f.isDone()) {
					if (f.get() != null) {
						errors.add(f.get().getMessage());
						break;
					}
					count++;
				}
			}
		}
	}

}
