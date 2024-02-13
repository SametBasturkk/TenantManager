package com.tenantmanager.service.api;

import com.tenantmanager.dto.EstateAgentDTO;
import com.tenantmanager.model.EstateAgent;

import java.util.List;

public interface EstateAgentService {

    public List getEstateAgentByNameAndSurname(String estateAgentName, String estateAgentSurname);

    public EstateAgent getEstateAgentByTCKN(String TCKN);

    public EstateAgent createEstateAgent(EstateAgentDTO estateAgentDTO);

    public EstateAgent getEstateAgentById(Long estateAgentId);

    public void deleteEstateAgent(Long estateAgentId);

    public void updateEstateAgent(Long estateAgentId, EstateAgentDTO estateAgent);
}
