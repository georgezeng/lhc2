package net.geozen.lhc2.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.geozen.lhc2.domain.TimesYz;

public interface TimesYzRepository extends PagingAndSortingRepository<TimesYz, Long> {
	List<TimesYz> findAllByTablesAndTypeOrderByPhaseAsc(String tables, String type);
	List<TimesYz> findAllByTablesAndType(String tables, String type);
}
