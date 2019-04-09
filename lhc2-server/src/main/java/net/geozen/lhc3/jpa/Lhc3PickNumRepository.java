package net.geozen.lhc3.jpa;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.Lhc3PickNum;

public interface Lhc3PickNumRepository extends JpaRepository<Lhc3PickNum, Long> {
	Optional<Lhc3PickNum> findByExpectedAndTypeAndPhase(int expected, String type, String phase);

	Optional<Lhc3PickNum> findFirstByExpectedAndTypeAndPhaseLessThanOrderByPhaseDesc(int expected, String type, String phase);
	
	Page<Lhc3PickNum> findAllByExpectedAndType(int expected, String type, Pageable pageable);
}