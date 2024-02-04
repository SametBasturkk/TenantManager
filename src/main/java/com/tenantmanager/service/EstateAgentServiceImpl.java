package com.tenantmanager.service;

import com.tenantmanager.model.EstateAgent;
import com.tenantmanager.repository.EstateAgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstateAgentServiceImpl implements EstateAgentService {

    private final EstateAgentRepository estateAgentRepository;

    private final ValidatorServiceImpl validatorService;

    public EstateAgentServiceImpl(EstateAgentRepository estateAgentRepository, ValidatorServiceImpl validatorService) {
        this.estateAgentRepository = estateAgentRepository;
        this.validatorService = validatorService;
    }


    @Override
    public EstateAgent createEstateAgent(EstateAgent estateAgent) {

        if (!validatorService.validateTCKN(estateAgent.getEstateAgentTCKN())) {
            throw new IllegalArgumentException("Invalid TCKN");
        }

        if (!validatorService.validatePhoneNumber(estateAgent.getEstateAgentPhone())) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        if (!validatorService.validateEmail(estateAgent.getEstateAgentMail())) {
            throw new IllegalArgumentException("Invalid Email");
        }


        return estateAgentRepository.save(estateAgent);
    }

    @Override
    public List getEstateAgentByNameAndSurname(String estateAgentName, String estateAgentSurname) {
        List<EstateAgent> estateAgentList = estateAgentRepository.findByEstateAgentNameAndEstateAgentSurname(estateAgentName, estateAgentSurname);
        if (estateAgentList.isEmpty()) {
            throw new IllegalArgumentException("EstateAgent not found");
        }
        return estateAgentList;
    }

    @Override
    public EstateAgent getEstateAgentByTCKN(String TCKN) {
        return estateAgentRepository.findByEstateAgentTCKN(TCKN);
    }

    @Override
    public EstateAgent getEstateAgentById(String estateAgentId) {
        return estateAgentRepository.findById(Long.parseLong(estateAgentId)).orElse(null);
    }


}
