package com.TenantManager.TenantManager.service;

import com.TenantManager.TenantManager.model.Owner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private List<Owner> owners = new ArrayList<>();

    public void addOwner(Owner owner) {
        owners.add(owner);
    }

    public Owner getOwnerByNameAndSurname(String ownerName, String ownerSurname) {
        for (Owner owner : owners) {
            if (owner.getOwnerName().equals(ownerName) && owner.getOwnerSurname().equals(ownerSurname)) {
                return owner;
            }
        }
        return null;
    }

    public Owner getOwnerByTCKN(String TCKN) {
        for (Owner owner : owners) {
            if (owner.getOwnerTCKN().equals(TCKN)) {
                return owner;
            }
        }
        return null;
    }


}
