package net.geozen.lhc2.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import net.geozen.lhc2.domain.PickNum;

@Transactional
public interface PickNumRepository extends PagingAndSortingRepository<PickNum, Long> {
	Page<PickNum> findAllByExpectedAndType(int expected, String type, Pageable pageable);
	PickNum findByExpectedAndTypeAndPhase(int expected, String type, int phase);
}
