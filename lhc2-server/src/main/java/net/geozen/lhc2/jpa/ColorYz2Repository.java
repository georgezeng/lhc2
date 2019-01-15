package net.geozen.lhc2.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.geozen.lhc2.domain.ColorYz2;

public interface ColorYz2Repository extends PagingAndSortingRepository<ColorYz2, Long> {
	List<ColorYz2> findAllByTablesAndTypeOrderByPhaseAsc(String tables, String type);
	List<ColorYz2> findAllByTablesAndType(String tables, String type);
}
