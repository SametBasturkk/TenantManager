package com.tenantmanager.service.impl;

import com.tenantmanager.dto.HouseDTO;
import com.tenantmanager.exception.DbException;
import com.tenantmanager.model.Apartment;
import com.tenantmanager.model.House;
import com.tenantmanager.model.Owner;
import com.tenantmanager.repository.HouseRepository;
import com.tenantmanager.service.api.ApartmentService;
import com.tenantmanager.service.api.HouseService;
import com.tenantmanager.service.api.OwnerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HouseServiceImpl implements HouseService {


    private final HouseRepository houseRepository;

    private final ApartmentService apartmentService;

    private final OwnerService ownerService;

    public HouseServiceImpl(HouseRepository houseRepository, ApartmentService apartmentService, OwnerService ownerService) {
        this.houseRepository = houseRepository;
        this.apartmentService = apartmentService;
        this.ownerService = ownerService;
    }


    @Override
    @Transactional
    public void createHouse(HouseDTO houseDTO) {
        House houseModel = new House();
        Owner owner = ownerService.getOwnerById(houseDTO.getOwnerId());
        Apartment apartment = apartmentService.getApartmentById(houseDTO.getApartmentId());

        if (owner == null || apartment == null) {
            throw new DbException("Owner or Apartment not found");
        }

        houseModel.setOwner(owner);
        houseModel.setHouseType(houseDTO.getHouseType());
        houseModel.setHouseAddress(houseDTO.getHouseAddress());
        houseModel.setHousePrice(houseDTO.getHousePrice());
        houseModel.setHouseRooms(houseDTO.getHouseRooms());
        houseModel.setApartment(apartment);
        houseRepository.save(houseModel);
    }

    @Override
    public House getHouseById(Long houseId) {
        return houseRepository.findById(houseId).orElseThrow(() -> new DbException("House not found"));
    }

    @Override
    @Transactional
    public void deleteHouse(Long houseId) {
        houseRepository.deleteById(houseId);
    }

    @Override
    @Transactional
    public void updateHouseOwner(Long houseId, Long ownerId) {
        House house = houseRepository.findById(houseId).orElseThrow(() -> new DbException("House not found"));
        Owner owner = ownerService.getOwnerById(ownerId);
        house.setOwner(owner);
        houseRepository.save(house);
    }

    @Override
    public House getHouseByOwnerId(Long ownerId) {
        House house = houseRepository.findByOwnerId(ownerId);
        if (house == null) {
            throw new DbException("House not found");
        }
        return house;
    }
}
