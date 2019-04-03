package net.geozen.lhc3.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.geozen.lhc3.domain.SystemConfig;

public interface SystemConfigRepository extends JpaRepository<SystemConfig, Long> {
	Optional<SystemConfig> findByKey(String key);
}
