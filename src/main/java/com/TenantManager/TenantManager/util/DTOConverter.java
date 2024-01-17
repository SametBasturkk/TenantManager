package com.TenantManager.TenantManager.util;

import com.TenantManager.TenantManager.dto.OwnerDTO;
import com.TenantManager.TenantManager.model.Owner;
import org.springframework.stereotype.Service;

@Service
public class DTOConverter {
    public static OwnerDTO modelToDto(Owner owner) {
        try {
            OwnerDTO ownerDTO = new OwnerDTO();
            ownerDTO.setOwnerName(owner.getOwnerName());
            ownerDTO.setOwnerSurname(owner.getOwnerSurname());
            ownerDTO.setOwnerPhone(owner.getOwnerPhone());
            ownerDTO.setOwnerMail(owner.getOwnerMail());
            ownerDTO.setOwnerHouse(owner.getOwnerHouse());
            return ownerDTO;
        } catch (Exception e) {
            return null;
        }
    }

    public static com.TenantManager.TenantManager.model.Owner dtoToModel(OwnerDTO ownerDTO) {
        try {
            Owner owner = new Owner();
            owner.setOwnerName(ownerDTO.getOwnerName());
            owner.setOwnerSurname(ownerDTO.getOwnerSurname());
            owner.setOwnerPhone(ownerDTO.getOwnerPhone());
            owner.setOwnerMail(ownerDTO.getOwnerMail());
            owner.setOwnerHouse(ownerDTO.getOwnerHouse());
            return owner;
        } catch (Exception e) {
            return null;
        }
    }
}
