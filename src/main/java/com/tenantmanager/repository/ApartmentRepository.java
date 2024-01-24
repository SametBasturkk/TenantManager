package com.tenantmanager.repository;

import com.tenantmanager.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

}
