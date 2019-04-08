package net.geozen.lhc3.service.fd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.geozen.lhc3.def.jpa.BaseRepository;
import net.geozen.lhc3.domain.fd.Lhc3FdSw;
import net.geozen.lhc3.jpa.fd.Lhc3FdSwRepository;
import net.geozen.lhc3.service.base.BaseSwZValueCalService;

@Service
public class Lhc3FdSwZValueService extends BaseSwZValueCalService<Lhc3FdSw> {
	@Autowired
	private Lhc3FdSwRepository swRepository;

	@Override
	protected BaseRepository<Lhc3FdSw> getSwRepository() {
		return swRepository;
	}

	@Override
	protected List<Integer> getNums(int pos) {
		return null;
	}

}
