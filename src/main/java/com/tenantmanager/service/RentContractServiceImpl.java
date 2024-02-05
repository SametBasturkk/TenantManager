package com.tenantmanager.service;

import com.tenantmanager.dto.RentContractDTO;
import com.tenantmanager.model.*;
import com.tenantmanager.repository.RentContractRepository;
import org.springframework.stereotype.Service;

@Service
public class RentContractServiceImpl implements RentContractService {


    RentContractRepository rentContractRepository;
    EstateAgentService estateAgentService;
    TenantService tenantService;
    HouseService houseService;
    ApartmentService apartmentService;


    public RentContractServiceImpl(RentContractRepository rentContractRepository, EstateAgentService estateAgentService, TenantService tenantService, HouseService houseService, ApartmentService apartmentService) {
        this.rentContractRepository = rentContractRepository;
        this.estateAgentService = estateAgentService;
        this.tenantService = tenantService;
        this.houseService = houseService;
        this.apartmentService = apartmentService;
    }


    @Override
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
}
