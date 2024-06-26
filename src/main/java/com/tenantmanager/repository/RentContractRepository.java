package com.tenantmanager.repository;

import com.tenantmanager.model.RentContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RentContractRepository extends JpaRepository<RentContract, Long> {

    Object findByTenantId(Long tenantId);
}
