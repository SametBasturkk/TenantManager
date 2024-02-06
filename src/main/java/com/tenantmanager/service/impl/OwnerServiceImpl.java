package com.tenantmanager.service.impl;

import com.tenantmanager.model.Owner;
import com.tenantmanager.repository.OwnerRepository;
import com.tenantmanager.service.api.OwnerService;
import com.tenantmanager.util.Validator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    private final Validator validatorService;

    public OwnerServiceImpl(OwnerRepository ownerRepository, Validator validatorService) {
        this.ownerRepository = ownerRepository;
        this.validatorService = validatorService;
    }


    @Override
    @Transactional
    public Owner createOwner(Owner owner) {

        if (!validatorService.validateTCKN(owner.getOwnerTCKN())) {
            throw new IllegalArgumentException("Invalid TCKN");
        }

        if (!validatorService.validatePhoneNumber(owner.getOwnerPhone())) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        if (!validatorService.validateEmail(owner.getOwnerMail())) {
            throw new IllegalArgumentException("Invalid Email");
        }


        return ownerRepository.save(owner);
    }

    @Override
    public Owner getOwnerById(Long ownerId) {
        return ownerRepository.findById(ownerId).orElse(null);
    }

    @Override
    public List getOwnerByNameAndSurname(String ownerName, String ownerSurname) {
        List<Owner> ownerList = ownerRepository.findByOwnerNameAndOwnerSurname(ownerName, ownerSurname);
        if (ownerList.isEmpty()) {
            throw new IllegalArgumentException("Owner not found");
        }
        return ownerList;
    }

    @Override
    public Owner getOwnerByTCKN(String TCKN) {
        return ownerRepository.findByOwnerTCKN(TCKN);
    }


}
