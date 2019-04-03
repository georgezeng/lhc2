package net.geozen.lhc3.def.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.base.PosBaseEntity;

public interface BaseSwRepository<S extends PosBaseEntity> extends JpaRepository<S, Long> {
	Optional<S> findByPhase(String phase);
}
