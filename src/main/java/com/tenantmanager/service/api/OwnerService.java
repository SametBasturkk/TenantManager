package com.tenantmanager.service.api;

import com.tenantmanager.dto.OwnerDTO;
import com.tenantmanager.model.Owner;

import java.util.List;

public interface OwnerService {

    public List getOwnerByNameAndSurname(String ownerName, String ownerSurname);

    public Owner getOwnerByTCKN(String TCKN);

    public Owner createOwner(Owner owner);

    public Owner getOwnerById(Long ownerId);

    void deleteOwner(Long ownerId);

    void updateOwner(Long ownerId, OwnerDTO owner);
}
