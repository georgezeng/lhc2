package net.geozen.lhc3.def.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.base.PosBaseEntity;

public interface BaseYzRepository<Y extends PosBaseEntity> extends JpaRepository<Y, Long> {
	Y findByPhase(String phase);
}
