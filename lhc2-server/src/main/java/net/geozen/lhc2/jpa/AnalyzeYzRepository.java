package net.geozen.lhc2.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import net.geozen.lhc2.domain.AnalyzeYz;

@Transactional
public interface AnalyzeYzRepository extends PagingAndSortingRepository<AnalyzeYz, Long> {
	AnalyzeYz findByExpectedAndTypeAndPhase(int expected, String type, int pahse);

	Page<AnalyzeYz> findAllByExpectedAndType(int expected, String type, Pageable pageable);
}
