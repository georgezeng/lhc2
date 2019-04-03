package net.geozen.lhc3.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.Lhc3Tm;

public interface Lhc3TmRepository extends JpaRepository<Lhc3Tm, Long> {
	Optional<Lhc3Tm> findByPhase(String phase);
}
