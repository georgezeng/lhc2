package net.geozen.lhc3.def.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.base.PosBaseEntity;

public interface BaseRepository<Y extends PosBaseEntity> extends JpaRepository<Y, Long> {
	Optional<Y> findByPhase(String phase);
}
