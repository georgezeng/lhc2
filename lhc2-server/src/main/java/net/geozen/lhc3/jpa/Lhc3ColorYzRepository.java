package net.geozen.lhc3.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.Lhc3ColorYz;

public interface Lhc3ColorYzRepository extends JpaRepository<Lhc3ColorYz, Long> {
	Page<Lhc3ColorYz> findAllByTablesAndType(String tables, String type, Pageable pageable);

	List<Lhc3ColorYz> findAllByTablesAndType(String tables, String type);

	Optional<Lhc3ColorYz> findFirstByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(String tables, String type, String phase);
	
	List<Lhc3ColorYz> findTop100ByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(String tables, String type, String phase);
}
