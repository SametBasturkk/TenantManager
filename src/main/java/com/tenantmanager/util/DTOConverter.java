package com.tenantmanager.util;

import com.tenantmanager.dto.EstateAgentDTO;
import com.tenantmanager.dto.OwnerDTO;
import com.tenantmanager.dto.TenantDTO;
import com.tenantmanager.model.EstateAgent;
import com.tenantmanager.model.Owner;
import com.tenantmanager.model.Tenant;
import org.springframework.stereotype.Service;

@Service
public class DTOConverter {
    public static OwnerDTO ownerModelToDto(Owner owner) {
        try {
            OwnerDTO ownerDTO = new OwnerDTO();
            ownerDTO.setOwnerName(owner.getOwnerName());
            ownerDTO.setOwnerSurname(owner.getOwnerSurname());
            ownerDTO.setOwnerPhone(owner.getOwnerPhone());
            ownerDTO.setOwnerMail(owner.getOwnerMail());
            ownerDTO.setOwnerHouse(owner.getOwnerHouse());
            ownerDTO.setOwnerTCKN(owner.getOwnerTCKN());
            return ownerDTO;
        } catch (Exception e) {
            return null;
        }
    }

    public static Owner ownerDtoToModel(OwnerDTO ownerDTO) {
        try {
            Owner owner = new Owner();
            owner.setOwnerName(ownerDTO.getOwnerName());
            owner.setOwnerSurname(ownerDTO.getOwnerSurname());
            owner.setOwnerPhone(ownerDTO.getOwnerPhone());
            owner.setOwnerMail(ownerDTO.getOwnerMail());
            owner.setOwnerHouse(ownerDTO.getOwnerHouse());
            owner.setOwnerTCKN(ownerDTO.getOwnerTCKN());
            return owner;
        } catch (Exception e) {
            return null;
        }
    }

    public static Tenant tenantDtoToModel(TenantDTO tenantDTO) {
        try {
            Tenant tenant = new Tenant();
            tenant.setTenantName(tenantDTO.getTenantName());
            tenant.setTenantSurname(tenantDTO.getTenantSurname());
            tenant.setTenantPhone(tenantDTO.getTenantPhone());
            tenant.setTenantMail(tenantDTO.getTenantMail());
            tenant.setTenantTCKN(tenantDTO.getTenantTCKN());
            return tenant;
        } catch (Exception e) {
            return null;
        }
    }

    public static TenantDTO tenantModelToDto(Tenant tenant) {
        try {
            TenantDTO tenantDTO = new TenantDTO();
            tenantDTO.setTenantName(tenant.getTenantName());
            tenantDTO.setTenantSurname(tenant.getTenantSurname());
            tenantDTO.setTenantPhone(tenant.getTenantPhone());
            tenantDTO.setTenantMail(tenant.getTenantMail());
            tenantDTO.setTenantTCKN(tenant.getTenantTCKN());
            return tenantDTO;
        } catch (Exception e) {
            return null;
        }
    }

    public static EstateAgent estateAgentDtoToModel(EstateAgentDTO estateAgentDTO) {
        try {
            EstateAgent estateAgent = new EstateAgent();
            estateAgent.setEstateAgentName(estateAgentDTO.getEstateAgentName());
            estateAgent.setEstateAgentSurname(estateAgentDTO.getEstateAgentSurname());
            estateAgent.setEstateAgentPhone(estateAgentDTO.getEstateAgentPhone());
            estateAgent.setEstateAgentMail(estateAgentDTO.getEstateAgentMail());
            estateAgent.setEstateAgentTCKN(estateAgentDTO.getEstateAgentTCKN());
            return estateAgent;
        } catch (Exception e) {
            return null;
        }
    }

    public static EstateAgentDTO estateAgentModelToDto(EstateAgent estateAgent) {
        try {
            EstateAgentDTO estateAgentDTO = new EstateAgentDTO();
            estateAgentDTO.setEstateAgentName(estateAgent.getEstateAgentName());
            estateAgentDTO.setEstateAgentSurname(estateAgent.getEstateAgentSurname());
            estateAgentDTO.setEstateAgentPhone(estateAgent.getEstateAgentPhone());
            estateAgentDTO.setEstateAgentMail(estateAgent.getEstateAgentMail());
            estateAgentDTO.setEstateAgentTCKN(estateAgent.getEstateAgentTCKN());
            return estateAgentDTO;
        } catch (Exception e) {
            return null;
        }
    }


}