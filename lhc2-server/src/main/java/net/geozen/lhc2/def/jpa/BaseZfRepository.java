package net.geozen.lhc2.def.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.geozen.lhc2.domain.base.BaseEntity;

public interface BaseZfRepository<Z extends BaseEntity> extends PagingAndSortingRepository<Z, Long> {
	Z findByPhase(int phase);
}
