package com.tenantmanager.service;

import com.tenantmanager.model.*;
import com.tenantmanager.repository.RentContractRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public void createRentContract(String estateAgentId, String tenantId, String startdate, String enddate, String houseId, String apartmentId, String rentContractPrice, String rentContractDeposit) {
        RentContract rentContract = new RentContract();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        EstateAgent estateAgent = estateAgentService.getEstateAgentById(estateAgentId);
        Tenant tenant = tenantService.getTenantById(tenantId);
        Apartment apartment = apartmentService.getApartmentById(apartmentId);
        House house = houseService.getHouseById(houseId);
        Date start;
        Date end;

        try {
            start = formatter.parse(startdate);
            end = formatter.parse(enddate);
            rentContract.setStartDate(start);
            rentContract.setEndDate(end);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format");

        }


        if (estateAgent == null || tenant == null || apartment == null) {
            throw new IllegalArgumentException("Estate agent, tenant or apartment not found");
        }

        rentContract.setRentContractEstateAgent(estateAgent);
        rentContract.setTenant(tenant);
        rentContract.setStartDate(start);
        rentContract.setEndDate(end);
        rentContract.setHouse(house);
        rentContract.setRentContractPrice(rentContractPrice);
        rentContract.setRentContractDeposit(rentContractDeposit);


        rentContractRepository.save(rentContract);

    }
}
