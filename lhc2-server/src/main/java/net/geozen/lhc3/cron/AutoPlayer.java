package net.geozen.lhc3.cron;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.geozen.lhc2.utils.CommonUtil;
import net.geozen.lhc3.constant.SystemConfigKeys;
import net.geozen.lhc3.domain.Lhc3Tm;
import net.geozen.lhc3.domain.SystemConfig;
import net.geozen.lhc3.jpa.SystemConfigRepository;
import net.geozen.lhc3.service.Lhc3FdService;
import net.geozen.lhc3.service.Lhc3SeqaService;
import net.geozen.lhc3.service.Lhc3SeqbService;
import net.geozen.lhc3.service.Lhc3SeqcService;
import net.geozen.lhc3.service.Lhc3SeqdService;
import net.geozen.lhc3.service.Lhc3SeqeService;
import net.geozen.lhc3.service.Lhc3SeqfService;
import net.geozen.lhc3.service.Lhc3SeqgService;
import net.geozen.lhc3.service.Lhc3SeqhService;
import net.geozen.lhc3.service.Lhc3SeqiService;
import net.geozen.lhc3.service.Lhc3SeqjService;
import net.geozen.lhc3.service.Lhc3SeqkService;
import net.geozen.lhc3.service.Lhc3SeqlService;
import net.geozen.lhc3.service.Lhc3SeqmService;
import net.geozen.lhc3.service.Lhc3SeqnService;
import net.geozen.lhc3.service.Lhc3SeqoService;
import net.geozen.lhc3.service.Lhc3SeqpService;
import net.geozen.lhc3.service.Lhc3SeqqService;
import net.geozen.lhc3.service.Lhc3SeqrService;
import net.geozen.lhc3.service.NumImporter;

@Component
public class AutoPlayer {
	@Autowired
	private SystemConfigRepository configRepository;

	@Autowired
	private NumImporter importer;

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

	// @Scheduled(cron = "50 0/5 * * * ?")
//	@Scheduled(cron = "0 * * * * ?")
	@PostConstruct
	public void run() throws Exception {
		Optional<SystemConfig> configOp = configRepository.findByKey(SystemConfigKeys.LOTTERY_SITE);
		int limitedRows = 50;
		if (configOp.isPresent()) {
			limitedRows = Integer.valueOf(configOp.get().getValue());
		}
		List<Lhc3Tm> tmList = importer.importTm();
		List<Future<Exception>> futures = new ArrayList<>();
		if (!tmList.isEmpty()) {
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
//			CommonUtil.wait(futures);
		}
	}
}
