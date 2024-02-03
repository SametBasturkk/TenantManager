package com.estateAgentmanager.repository;

import com.tenantmanager.model.EstateAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface EstateAgentRepository extends JpaRepository<EstateAgent, Long> {
    List findByEstateAgentNameAndEstateAgentSurname(String estateAgentName, String estateAgentSurname);
    EstateAgent findByEstateAgentTCKN(String TCKN);

}
