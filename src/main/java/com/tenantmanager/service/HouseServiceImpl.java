package com.tenantmanager.service;

import com.tenantmanager.model.Apartment;
import com.tenantmanager.model.House;
import com.tenantmanager.model.Owner;
import com.tenantmanager.repository.HouseRepository;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService {


    HouseRepository houseRepository;

    AparmentService apartmentService;

    OwnerService ownerService;

    public HouseServiceImpl(HouseRepository houseRepository, AparmentService apartmentService, OwnerService ownerService) {
        this.houseRepository = houseRepository;
        this.apartmentService = apartmentService;
        this.ownerService = ownerService;
    }


    @Override
    public void createHouse(String ownerId, String houseType, String houseAddress, String housePrice, String houseRooms, String apartmentId) {
        House house = new House();
        Owner owner = ownerService.getOwnerById(ownerId);
        Apartment apartment = apartmentService.getApartmentById(apartmentId);
        if (owner == null || apartment == null) {
            throw new RuntimeException("Owner or Apartment not found");
        }
        
        house.setOwner(owner);
        house.setHouseType(houseType);
        house.setHouseAddress(houseAddress);
        house.setHousePrice(housePrice);
        house.setHouseRooms(houseRooms);
        house.setApartment(apartment);
        houseRepository.save(house);
    }
}
