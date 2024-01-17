package com.TenantManager.TenantManager.service;

import com.TenantManager.TenantManager.model.Owner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private List<Owner> owners = new ArrayList<>();

    @Override
    public void addOwner(Owner owner) {
        owners.add(owner);
    }

    @Override
    public Owner getOwnerByNameAndSurname(String ownerName, String ownerSurname) {
        for (Owner owner : owners) {
            if (owner.getOwnerName().equals(ownerName) && owner.getOwnerSurname().equals(ownerSurname)) {
                return owner;
            }
        }
        return null;
    }

    @Override
    public Owner getOwnerByTCKN(String TCKN) {
        for (Owner owner : owners) {
            if (owner.getOwnerTCKN().equals(TCKN)) {
                return owner;
            }
        }
        return null;
    }


}
