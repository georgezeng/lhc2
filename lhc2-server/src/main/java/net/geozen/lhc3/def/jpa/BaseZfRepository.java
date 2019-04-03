package net.geozen.lhc3.def.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.base.PosBaseEntity;

public interface BaseZfRepository<Z extends PosBaseEntity> extends JpaRepository<Z, Long> {
	Z findByPhase(String phase);
}
