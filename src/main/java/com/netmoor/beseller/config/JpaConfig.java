package com.netmoor.beseller.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * JpaConfig.
 *
 * @author Nikolay_Batov
 */
@Configuration
@EntityScan(basePackages = "com.netmoor.beseller.model")
@EnableJpaRepositories(basePackages = "com.netmoor.beseller.repository")
public class JpaConfig {
}
