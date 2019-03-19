package net.geozen.lhc2.service;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc2.jpa.PickNumRepository;

@Service
public class PickNumFacade {
	@Autowired
	private PickNumService service;

	@Autowired
	private PickNumRepository repository;

	public void process(List<Future<Exception>> futures) throws Exception {
//		repository.deleteAll();
//		futures.add(service.process(19, 7, 20, 15, 15));
//		futures.add(service.process(16, 7, 20, 15, 15));
//		futures.add(service.process(14, 10, 20, 8, 15));
//		futures.add(service.process(10, 7, 20, 15, 15));
//		futures.add(service.process(9, 10, 20, 8, 15));
//		futures.add(service.process(3, 10, 20, 8, 15));
	}

}
