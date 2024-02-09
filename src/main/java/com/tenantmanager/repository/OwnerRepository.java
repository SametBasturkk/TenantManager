package com.tenantmanager.repository;

import com.tenantmanager.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findByOwnerNameAndOwnerSurname(String ownerName, String ownerSurname);
    Owner findByOwnerTCKN(String TCKN);


}
