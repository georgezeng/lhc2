package net.geozen.lhc2.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = { "net.geozen.lhc2.jpa", "net.geozen.lhc3.jpa" })
@EntityScan(basePackages = { "net.geozen.lhc2.domain", "net.geozen.lhc3.domain" })
@EnableTransactionManagement
@Configuration
public class JpaConfig {

	@Bean
	public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
		return new OpenEntityManagerInViewFilter();
	}

}