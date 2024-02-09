package com.tenantmanager.service.api;

import com.tenantmanager.dto.HouseDTO;
import com.tenantmanager.model.House;

public interface HouseService {

   public void createHouse(HouseDTO house);

   House getHouseById(Long houseId);

    void deleteHouse(Long houseId);

    void updateHouseOwner(Long houseId, Long ownerId);

    Object getHouseByOwnerId(Long ownerId);
}
