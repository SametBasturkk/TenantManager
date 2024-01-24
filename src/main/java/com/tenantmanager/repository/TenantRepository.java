package com.tenantmanager.repository;

import com.tenantmanager.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TenantRepository extends JpaRepository<Tenant, Long> {

}
