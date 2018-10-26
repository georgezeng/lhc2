package net.geozen.lhc2.def.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.geozen.lhc2.domain.base.BaseEntity;

public interface BaseYzRepository<Y extends BaseEntity> extends PagingAndSortingRepository<Y, Long> {
	Y findByPhase(int phase);
}
