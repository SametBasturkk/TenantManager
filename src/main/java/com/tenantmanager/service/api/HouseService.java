package com.tenantmanager.service.api;

import com.tenantmanager.dto.HouseDTO;
import com.tenantmanager.model.House;

public interface HouseService {

    public void createHouse(HouseDTO house);

    public House getHouseById(Long houseId);

    public void deleteHouse(Long houseId);

    public void updateHouseOwner(Long houseId, Long ownerId);

    public Object getHouseByOwnerId(Long ownerId);
}
