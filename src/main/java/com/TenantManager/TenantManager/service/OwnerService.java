package com.TenantManager.TenantManager.service;

import com.TenantManager.TenantManager.model.OwnerHouse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

  private List<OwnerHouse> owners = new ArrayList<>();

  public void addOwner(OwnerHouse owner) {
    owners.add(owner);
  }

  public OwnerHouse getOwnerByName(String ownerName) {
    for (OwnerHouse owner : owners) {
      if (owner.getOwnerName().equals(ownerName)) {
        return owner;
      }
    }
    return null;
  }


}
