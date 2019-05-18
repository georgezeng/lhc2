package net.geozen.lhc3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.geozen.lhc2.utils.CommonUtil;
import net.geozen.lhc3.constant.SystemConfigKeys;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.domain.SystemConfig;
import net.geozen.lhc3.jpa.SystemConfigRepository;
import net.geozen.lhc3.service.fd.Lhc3FdService;
import net.geozen.lhc3.service.seqa.Lhc3SeqaService;
import net.geozen.lhc3.service.seqb.Lhc3SeqbService;
import net.geozen.lhc3.service.seqc.Lhc3SeqcService;
import net.geozen.lhc3.service.seqd.Lhc3SeqdService;
import net.geozen.lhc3.service.seqe.Lhc3SeqeService;
import net.geozen.lhc3.service.seqf.Lhc3SeqfService;
import net.geozen.lhc3.service.seqg.Lhc3SeqgService;
import net.geozen.lhc3.service.seqh.Lhc3SeqhService;
import net.geozen.lhc3.service.seqi.Lhc3SeqiService;
import net.geozen.lhc3.service.seqj.Lhc3SeqjService;
import net.geozen.lhc3.service.seqk.Lhc3SeqkService;
import net.geozen.lhc3.service.seql.Lhc3SeqlService;
import net.geozen.lhc3.service.seqm.Lhc3SeqmService;
import net.geozen.lhc3.service.seqn.Lhc3SeqnService;
import net.geozen.lhc3.service.seqo.Lhc3SeqoService;
import net.geozen.lhc3.service.seqp.Lhc3SeqpService;
import net.geozen.lhc3.service.seqq.Lhc3SeqqService;
import net.geozen.lhc3.service.seqr.Lhc3SeqrService;

@Component
@Slf4j
public class Lhc3CalculationService {
	@Autowired
	private SystemConfigRepository configRepository;

	@Autowired
	private Lhc3SeqaService seqaService;

	@Autowired
	private Lhc3SeqbService seqbService;

	@Autowired
	private Lhc3SeqcService seqcService;

	@Autowired
	private Lhc3SeqdService seqdService;

	@Autowired
	private Lhc3SeqeService seqeService;

	@Autowired
	private Lhc3SeqfService seqfService;

	@Autowired
	private Lhc3SeqgService seqgService;

	@Autowired
	private Lhc3SeqhService seqhService;

	@Autowired
	private Lhc3SeqiService seqiService;

	@Autowired
	private Lhc3SeqjService seqjService;

	@Autowired
	private Lhc3SeqkService seqkService;

	@Autowired
	private Lhc3SeqlService seqlService;

	@Autowired
	private Lhc3SeqmService seqmService;

	@Autowired
	private Lhc3SeqnService seqnService;

	@Autowired
	private Lhc3SeqoService seqoService;

	@Autowired
	private Lhc3SeqpService seqpService;

	@Autowired
	private Lhc3SeqqService seqqService;

	@Autowired
	private Lhc3SeqrService seqrService;

	@Autowired
	private Lhc3FdService fdService;

	@Autowired
	private Lhc3PickNumService pickNumService;

	@Autowired
	private Lhc3TimesColorService timesColorService;
	
	@Autowired
	private NumImporter importer;

	@Async
	public void cal() {
		while(true) {
			try {
				log.info("calculation started...");
				List<Lhc3Tm> tmList = importer.importTm();
				if (!tmList.isEmpty()) {
					Optional<SystemConfig> configOp = configRepository.findByKey(SystemConfigKeys.LOTTERY_SITE);
					int limitedRows = 50;
					if (configOp.isPresent()) {
						limitedRows = Integer.valueOf(configOp.get().getValue());
					}
					List<Future<Exception>> futures = new ArrayList<>();
					futures.add(seqaService.cal(tmList, limitedRows));
					futures.add(seqbService.cal(tmList, limitedRows));
					futures.add(seqcService.cal(tmList, limitedRows));
					futures.add(seqdService.cal(tmList, limitedRows));
					futures.add(seqeService.cal(tmList, limitedRows));
					futures.add(seqfService.cal(tmList, limitedRows));
					futures.add(seqgService.cal(tmList, limitedRows));
					futures.add(seqhService.cal(tmList, limitedRows));
					futures.add(seqiService.cal(tmList, limitedRows));
					futures.add(seqjService.cal(tmList, limitedRows));
					futures.add(seqkService.cal(tmList, limitedRows));
					futures.add(seqlService.cal(tmList, limitedRows));
					futures.add(seqmService.cal(tmList, limitedRows));
					futures.add(seqnService.cal(tmList, limitedRows));
					futures.add(seqoService.cal(tmList, limitedRows));
					futures.add(seqpService.cal(tmList, limitedRows));
					futures.add(seqqService.cal(tmList, limitedRows));
					futures.add(seqrService.cal(tmList, limitedRows));
					futures.add(fdService.cal(tmList, limitedRows));
					CommonUtil.wait(futures);
					futures.clear();
					futures.add(pickNumService.cal(tmList));
					CommonUtil.wait(futures);
					futures.clear();
					futures.add(timesColorService.cal(tmList, 13, "P1"));
					futures.add(timesColorService.cal(tmList, 12, "P2"));
					futures.add(timesColorService.cal(tmList, 12, "P3"));
					CommonUtil.wait(futures);
					log.info("calculation finished...");
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

}
