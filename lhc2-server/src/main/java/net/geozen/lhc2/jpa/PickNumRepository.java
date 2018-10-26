package net.geozen.lhc2.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import net.geozen.lhc2.domain.PickNum;

public interface PickNumRepository extends PagingAndSortingRepository<PickNum, Long> {
	Page<PickNum> findAllByExpected(int expected, Pageable pageable);
}
