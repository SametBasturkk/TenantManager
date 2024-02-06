package com.tenantmanager.service.api;

import com.tenantmanager.model.EstateAgent;

import java.util.List;

public interface EstateAgentService {

    public List getEstateAgentByNameAndSurname(String estateAgentName, String estateAgentSurname);

    public EstateAgent getEstateAgentByTCKN(String TCKN);

    public EstateAgent createEstateAgent(EstateAgent estateAgent);

    EstateAgent getEstateAgentById(Long estateAgentId);
}
