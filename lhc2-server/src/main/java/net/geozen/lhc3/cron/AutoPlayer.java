package net.geozen.lhc3.cron;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.geozen.lhc3.service.Lhc3CalculationService;

@Component
public class AutoPlayer {
	@Autowired
	private Lhc3CalculationService calService;

	// @Scheduled(cron = "50 0/5 * * * ?")
//	@Scheduled(cron = "0 * * * * ?")
	 @PostConstruct
	public void run() throws Exception {
		calService.cal();
	}

}
