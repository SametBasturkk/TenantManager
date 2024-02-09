package com.tenantmanager.service.impl;

import com.tenantmanager.dto.RentContractDTO;
import com.tenantmanager.model.*;
import com.tenantmanager.repository.RentContractRepository;
import com.tenantmanager.service.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentContractServiceImpl implements RentContractService {


    private final RentContractRepository rentContractRepository;
    private final EstateAgentService estateAgentService;
    private final TenantService tenantService;
    private final HouseService houseService;
    private final ApartmentService apartmentService;
    private final ModelMapper modelMapper;


    public RentContractServiceImpl(RentContractRepository rentContractRepository, EstateAgentService estateAgentService, TenantService tenantService, HouseService houseService, ApartmentService apartmentService, ModelMapper modelMapper) {
        this.rentContractRepository = rentContractRepository;
        this.estateAgentService = estateAgentService;
        this.tenantService = tenantService;
        this.houseService = houseService;
        this.apartmentService = apartmentService;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public void createRentContract(RentContractDTO rentContractDTO) {
        RentContract rentContract = new RentContract();
        EstateAgent estateAgent = estateAgentService.getEstateAgentById(rentContractDTO.getEstateAgentId());
        Tenant tenant = tenantService.getTenantById(rentContractDTO.getTenantId());
        Apartment apartment = apartmentService.getApartmentById(rentContractDTO.getApartmentId());
        House house = houseService.getHouseById(rentContractDTO.getHouseId());

        if (estateAgent == null || tenant == null || apartment == null) {
            throw new IllegalArgumentException("Estate agent, tenant or apartment not found");
        }

        rentContract.setStartDate(rentContractDTO.getStartDate());
        rentContract.setEndDate(rentContractDTO.getEndDate());
        rentContract.setRentContractEstateAgent(estateAgent);
        rentContract.setTenant(tenant);
        rentContract.setHouse(house);
        rentContract.setRentContractPrice(rentContractDTO.getRentContractDeposit());
        rentContract.setRentContractDeposit(rentContractDTO.getRentContractPrice());


        rentContractRepository.save(rentContract);

    }

    @Override
    @Transactional
    public void deleteRentContract(Long rentContractId) {
        rentContractRepository.deleteById(rentContractId);
    }

    @Override
    @Transactional
    public void updateRentContract(Long rentContractId, RentContractDTO rentContractDTO) {
        RentContract rentContract = rentContractRepository.findById(rentContractId).orElseThrow(() -> new IllegalArgumentException("Rent contract not found"));
        modelMapper.map(rentContractDTO, rentContract);
        rentContractRepository.save(rentContract);
    }

    @Override
    public Object getRentContractByTenantId(Long tenantId) {
        return rentContractRepository.findByTenantId(tenantId);
    }
}
