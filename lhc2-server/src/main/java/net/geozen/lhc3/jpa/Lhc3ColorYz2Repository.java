package net.geozen.lhc3.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.geozen.lhc3.domain.Lhc3ColorYz2;

public interface Lhc3ColorYz2Repository extends PagingAndSortingRepository<Lhc3ColorYz2, Long> {
	List<Lhc3ColorYz2> findAllByTablesAndTypeOrderByPhaseAsc(String tables, String type);
	List<Lhc3ColorYz2> findAllByTablesAndType(String tables, String type);
	Optional<Lhc3ColorYz2> findFirstByTablesAndTypeAndPhaseLessThanOrderByPhaseDesc(String tables, String type, String phase);
}
