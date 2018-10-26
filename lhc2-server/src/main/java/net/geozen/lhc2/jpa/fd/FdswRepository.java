package net.geozen.lhc2.jpa.fd;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.geozen.lhc2.domain.fd.Fdsw;

public interface FdswRepository extends PagingAndSortingRepository<Fdsw, Long> {
	Fdsw findByPhase(int phase);
}
