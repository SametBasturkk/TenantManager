package com.tenantmanager.service.impl;

import com.tenantmanager.dto.OwnerDTO;
import com.tenantmanager.exception.DbException;
import com.tenantmanager.model.Owner;
import com.tenantmanager.repository.OwnerRepository;
import com.tenantmanager.service.api.OwnerService;
import com.tenantmanager.util.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    private final Validator validatorService;

    private final ModelMapper modelMapper;

    public OwnerServiceImpl(OwnerRepository ownerRepository, Validator validatorService, ModelMapper modelMapper) {
        this.ownerRepository = ownerRepository;
        this.validatorService = validatorService;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public Owner createOwner(Owner owner) {

        return ownerRepository.save(owner);
    }

    @Override
    public Owner getOwnerById(Long ownerId) {
        return ownerRepository.findById(ownerId).orElseThrow(() -> new DbException("Owner not found"));
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

    @Override
    @Transactional
    public void deleteOwner(Long ownerId) {
        ownerRepository.deleteById(ownerId);
    }

    @Override
    @Transactional
    public void updateOwner(Long ownerId, OwnerDTO ownerDTO) {
        Owner ownerModel = ownerRepository.findById(ownerId).orElseThrow(() -> new DbException("Owner not found"));
        modelMapper.map(ownerDTO, ownerModel);
        ownerRepository.save(ownerModel);
    }

}
