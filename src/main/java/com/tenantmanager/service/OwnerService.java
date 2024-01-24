package com.tenantmanager.service;

import com.tenantmanager.model.Owner;

public interface OwnerService {
    public void addOwner(Owner owner);

    public Owner getOwnerByNameAndSurname(String ownerName, String ownerSurname);

    public Owner getOwnerByTCKN(String TCKN);

}
