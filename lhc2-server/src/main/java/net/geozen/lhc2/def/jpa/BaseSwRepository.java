package net.geozen.lhc2.def.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.geozen.lhc2.domain.base.BaseEntity;

public interface BaseSwRepository<S extends BaseEntity> extends PagingAndSortingRepository<S, Long> {
	S findByPhase(int phase);
}
