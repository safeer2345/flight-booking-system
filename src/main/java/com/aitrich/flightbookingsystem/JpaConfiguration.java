package com.aitrich.flightbookingsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.aitrich.flightbookingsystem.domain.repository"})
public class JpaConfiguration {
}
