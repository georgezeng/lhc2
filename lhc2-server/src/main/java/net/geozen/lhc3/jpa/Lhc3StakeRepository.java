package net.geozen.lhc3.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.Lhc3Stake;

public interface Lhc3StakeRepository extends JpaRepository<Lhc3Stake, Long> {
	Optional<Lhc3Stake> findFirstByTypeOrderByPhaseDesc(String type);
}