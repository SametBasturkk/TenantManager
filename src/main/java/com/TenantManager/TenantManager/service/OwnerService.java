package com.TenantManager.TenantManager.service;

import com.TenantManager.TenantManager.model.Owner;

public interface OwnerService {
    public void addOwner(Owner owner);

    public Owner getOwnerByNameAndSurname(String ownerName, String ownerSurname);

    public Owner getOwnerByTCKN(String TCKN);

}
