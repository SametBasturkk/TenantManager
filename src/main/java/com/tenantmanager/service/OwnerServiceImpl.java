package com.tenantmanager.service;

import com.tenantmanager.model.Owner;
import com.tenantmanager.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    private final ValidatorServiceImpl validatorService;

    public OwnerServiceImpl(OwnerRepository ownerRepository, ValidatorServiceImpl validatorService) {
        this.ownerRepository = ownerRepository;
        this.validatorService = validatorService;
    }


    @Override
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
    public Owner getOwnerById(String ownerId) {
        return ownerRepository.findById(Long.parseLong(ownerId)).orElse(null);
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
