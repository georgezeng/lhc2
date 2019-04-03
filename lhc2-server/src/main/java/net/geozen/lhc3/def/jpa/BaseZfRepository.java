package net.geozen.lhc3.def.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.base.PosBaseEntity;

public interface BaseZfRepository<Z extends PosBaseEntity> extends JpaRepository<Z, Long> {
	Optional<Z> findByPhase(String phase);
}
