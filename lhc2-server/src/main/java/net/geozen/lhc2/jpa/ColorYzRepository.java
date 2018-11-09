package net.geozen.lhc2.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.geozen.lhc2.domain.ColorYz;

public interface ColorYzRepository extends PagingAndSortingRepository<ColorYz, Long> {
	List<ColorYz> findAllByTablesOrderByPhaseAsc(String tables);
}
