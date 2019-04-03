package net.geozen.lhc3.jpa.fd;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.fd.Lhc3FdSw;

public interface Lhc3FdSwRepository extends JpaRepository<Lhc3FdSw, Long> {
	Optional<Lhc3FdSw> findByPhase(String phase);
}
