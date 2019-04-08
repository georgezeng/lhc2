package net.geozen.lhc3.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.Lhc3ColorYz;

public interface Lhc3ColorYzRepository extends JpaRepository<Lhc3ColorYz, Long> {
	List<Lhc3ColorYz> findAllByTablesAndTypeOrderByPhaseAsc(String tables, String type);

	List<Lhc3ColorYz> findAllByTablesAndType(String tables, String type);

	Optional<Lhc3ColorYz> findFirstByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(String tables, String type, String phase);
}
