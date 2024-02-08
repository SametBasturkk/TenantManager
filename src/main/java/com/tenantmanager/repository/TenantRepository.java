package com.tenantmanager.repository;

import com.tenantmanager.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TenantRepository extends JpaRepository<Tenant, Long> {

    @Query("SELECT t FROM Tenant t WHERE t.tenantName = ?1 AND t.tenantSurname = ?2")
    List findByTenantNameAndTenantSurname(String tenantName, String tenantSurname);

    @Query(value = "SELECT * FROM tenants WHERE tenant_tckn = ?1", nativeQuery = true)
    Tenant findByTenantTCKN(String TCKN);

}
