package com.tenantmanager.service.api;

import com.tenantmanager.dto.OwnerDTO;
import com.tenantmanager.model.Owner;

import java.util.List;

public interface OwnerService {

    public List<Owner> getOwnerByNameAndSurname(String ownerName, String ownerSurname);

    public Owner getOwnerByTCKN(String TCKN);

    public Owner createOwner(OwnerDTO ownerDTO);

    public Owner getOwnerById(Long ownerId);

    public void deleteOwner(Long ownerId);

    public void updateOwner(Long ownerId, OwnerDTO owner);
}
