package net.geozen.lhc3.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import net.geozen.lhc3.domain.Lhc3ColorYz2;

public interface Lhc3ColorYz2Repository extends PagingAndSortingRepository<Lhc3ColorYz2, Long> {
	Page<Lhc3ColorYz2> findAllByTablesAndType(String tables, String type, Pageable pageable);
	List<Lhc3ColorYz2> findAllByTablesAndType(String tables, String type);
	Optional<Lhc3ColorYz2> findFirstByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(String tables, String type, String phase);
	List<Lhc3ColorYz2> findTop100ByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(String tables, String type, String phase);
}
