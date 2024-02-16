package com.tenantmanager.repository;

import com.tenantmanager.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface HouseRepository extends JpaRepository<House,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM houses WHERE owner_id = ?1")
    House findByOwnerId(Long ownerId);
}
