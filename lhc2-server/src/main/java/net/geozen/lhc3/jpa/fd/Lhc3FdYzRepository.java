package net.geozen.lhc3.jpa.fd;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.fd.Lhc3FdYz;

public interface Lhc3FdYzRepository extends JpaRepository<Lhc3FdYz, Long> {
	Optional<Lhc3FdYz> findByPhase(String phase);
}
