package com.tenantmanager.service.impl;

import com.tenantmanager.dto.EstateAgentDTO;
import com.tenantmanager.exception.DbException;
import com.tenantmanager.model.EstateAgent;
import com.tenantmanager.repository.EstateAgentRepository;
import com.tenantmanager.service.api.EstateAgentService;
import com.tenantmanager.util.DTOConverter;
import com.tenantmanager.util.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstateAgentServiceImpl implements EstateAgentService {

    private final EstateAgentRepository estateAgentRepository;

    private final Validator validatorService;

    private final DTOConverter converter;

    private final ModelMapper modelMapper;

    public EstateAgentServiceImpl(EstateAgentRepository estateAgentRepository, Validator validatorService, DTOConverter converter, ModelMapper modelMapper) {
        this.estateAgentRepository = estateAgentRepository;
        this.validatorService = validatorService;
        this.converter = converter;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public EstateAgent createEstateAgent(EstateAgentDTO estateAgentDTO) {
        EstateAgent estateAgent = modelMapper.map(estateAgentDTO, EstateAgent.class);
        return estateAgentRepository.save(estateAgent);
    }

    @Override
    public List<EstateAgent> getEstateAgentByNameAndSurname(String estateAgentName, String estateAgentSurname) {
        List<EstateAgent> estateAgentList = estateAgentRepository.findByEstateAgentNameAndEstateAgentSurname(estateAgentName, estateAgentSurname);
        if (estateAgentList.isEmpty()) {
            throw new DbException("EstateAgent not found");
        }
        return estateAgentList;
    }

    @Override
    public EstateAgent getEstateAgentByTCKN(String TCKN) {
        EstateAgent estateAgent = estateAgentRepository.findByEstateAgentTCKN(TCKN);
        if (estateAgent == null) {
            throw new DbException("EstateAgent not found");
        }
        return estateAgent;
    }

    @Override
    public EstateAgent getEstateAgentById(Long estateAgentId) {
        return estateAgentRepository.findById(estateAgentId).orElseThrow(() -> new DbException("EstateAgent not found"));
    }


    @Override
    @Transactional
    public void deleteEstateAgent(Long estateAgentId) {
        estateAgentRepository.deleteById(estateAgentId);
    }

    @Override
    public void updateEstateAgent(Long estateAgentId, EstateAgentDTO estateAgentDTO) {
        EstateAgent estateAgentToUpdate = estateAgentRepository.findById(estateAgentId).orElseThrow(() -> new DbException("EstateAgent not found"));
        modelMapper.map(estateAgentDTO, estateAgentToUpdate);
        estateAgentRepository.save(estateAgentToUpdate);
    }


}
