package com.tenantmanager.service;

import com.tenantmanager.dto.HouseDTO;
import com.tenantmanager.model.House;

public interface HouseService {

   public void createHouse(HouseDTO house);

   House getHouseById(Long houseId);
}
