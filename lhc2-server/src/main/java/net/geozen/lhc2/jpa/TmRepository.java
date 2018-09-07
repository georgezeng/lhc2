package net.geozen.lhc2.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.geozen.lhc2.domain.Tm;

public interface TmRepository extends PagingAndSortingRepository<Tm, Long> {
	
}
