package com.tenantmanager.service.impl;

import com.tenantmanager.exception.DbException;
import com.tenantmanager.model.EstateAgent;
import com.tenantmanager.repository.EstateAgentRepository;
import com.tenantmanager.service.api.EstateAgentService;
import com.tenantmanager.util.DTOConverter;
import com.tenantmanager.util.Validator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstateAgentServiceImpl implements EstateAgentService {

    private final EstateAgentRepository estateAgentRepository;

    private final Validator validatorService;

    private final DTOConverter converter;

    public EstateAgentServiceImpl(EstateAgentRepository estateAgentRepository, Validator validatorService, DTOConverter converter) {
        this.estateAgentRepository = estateAgentRepository;
        this.validatorService = validatorService;
        this.converter = converter;
    }


    @Override
    @Transactional
    public EstateAgent createEstateAgent(EstateAgent estateAgent) {

        return estateAgentRepository.save(estateAgent);
    }

    @Override
    public List getEstateAgentByNameAndSurname(String estateAgentName, String estateAgentSurname) {
        return estateAgentRepository.findByEstateAgentNameAndEstateAgentSurname(estateAgentName, estateAgentSurname);
    }

    @Override
    public EstateAgent getEstateAgentByTCKN(String TCKN) {
        return estateAgentRepository.findByEstateAgentTCKN(TCKN);
    }

    @Override
    public EstateAgent getEstateAgentById(Long estateAgentId) {
        return estateAgentRepository.findById(estateAgentId).orElseThrow(() -> new DbException("EstateAgent not found"));
    }


}