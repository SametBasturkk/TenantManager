package com.tenantmanager.service;

import com.tenantmanager.model.House;

public interface HouseService {

   public void createHouse(String ownerId,String houseType, String houseAddress, String housePrice, String houseRooms, String apartmentId);

   House getHouseById(String houseId);
}
