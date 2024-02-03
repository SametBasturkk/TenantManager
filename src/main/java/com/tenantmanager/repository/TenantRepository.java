package com.tenantmanager.repository;

import com.tenantmanager.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    List findByTenantNameAndTenantSurname(String tenantName, String tenantSurname);
    Tenant findByTenantTCKN(String TCKN);

}
