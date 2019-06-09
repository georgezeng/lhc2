package net.geozen.lhc3.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.Lhc3TimesYz;

public interface Lhc3TimesYzRepository extends JpaRepository<Lhc3TimesYz, Long> {
	Page<Lhc3TimesYz> findAllByTablesAndType(String tables, String type, Pageable pageable);

	List<Lhc3TimesYz> findAllByTablesAndType(String tables, String type);

	Optional<Lhc3TimesYz> findFirstByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(String tables, String type, String phase);
	
	List<Lhc3TimesYz> findTop100ByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(String tables, String type, String phase);
}
