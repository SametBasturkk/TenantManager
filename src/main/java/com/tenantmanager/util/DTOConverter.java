package com.tenantmanager.util;

import com.tenantmanager.dto.ApartmentDTO;
import com.tenantmanager.dto.EstateAgentDTO;
import com.tenantmanager.dto.OwnerDTO;
import com.tenantmanager.dto.TenantDTO;
import com.tenantmanager.exception.DtoModelConvertException;
import com.tenantmanager.model.Apartment;
import com.tenantmanager.model.EstateAgent;
import com.tenantmanager.model.Owner;
import com.tenantmanager.model.Tenant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTOConverter {
    public static OwnerDTO ownerModelToDto(Owner owner) throws DtoModelConvertException {
        try {
            OwnerDTO ownerDTO = new OwnerDTO();
            ownerDTO.setOwnerName(owner.getOwnerName());
            ownerDTO.setOwnerSurname(owner.getOwnerSurname());
            ownerDTO.setOwnerPhone(owner.getOwnerPhone());
            ownerDTO.setOwnerMail(owner.getOwnerMail());
            ownerDTO.setOwnerHouse(owner.getOwnerHouses());
            ownerDTO.setOwnerTCKN(owner.getOwnerTCKN());
            return ownerDTO;
        } catch (DtoModelConvertException e) {
            throw new DtoModelConvertException("Error converting Owner to DTO", e);
        }
    }


    public static Owner ownerDtoToModel(OwnerDTO ownerDTO) throws DtoModelConvertException {
        try {
            Owner owner = new Owner();
            owner.setOwnerName(ownerDTO.getOwnerName());
            owner.setOwnerSurname(ownerDTO.getOwnerSurname());
            owner.setOwnerPhone(ownerDTO.getOwnerPhone());
            owner.setOwnerMail(ownerDTO.getOwnerMail());
            owner.setOwnerHouses(ownerDTO.getOwnerHouse());
            owner.setOwnerTCKN(ownerDTO.getOwnerTCKN());
            return owner;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting OwnerDTO to Model", e);
        }
    }

    public static Tenant tenantDtoToModel(TenantDTO tenantDTO) throws DtoModelConvertException {
        try {
            Tenant tenant = new Tenant();
            tenant.setTenantName(tenantDTO.getTenantName());
            tenant.setTenantSurname(tenantDTO.getTenantSurname());
            tenant.setTenantPhone(tenantDTO.getTenantPhone());
            tenant.setTenantMail(tenantDTO.getTenantMail());
            tenant.setTenantTCKN(tenantDTO.getTenantTCKN());
            return tenant;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting TenantDTO to Model", e);
        }
    }

    public static TenantDTO tenantModelToDto(Tenant tenant) throws DtoModelConvertException {
        try {
            TenantDTO tenantDTO = new TenantDTO();
            tenantDTO.setTenantName(tenant.getTenantName());
            tenantDTO.setTenantSurname(tenant.getTenantSurname());
            tenantDTO.setTenantPhone(tenant.getTenantPhone());
            tenantDTO.setTenantMail(tenant.getTenantMail());
            tenantDTO.setTenantTCKN(tenant.getTenantTCKN());
            return tenantDTO;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting Tenant to DTO", e);
        }
    }

    public static EstateAgent estateAgentDtoToModel(EstateAgentDTO estateAgentDTO) throws DtoModelConvertException {
        try {
            EstateAgent estateAgent = new EstateAgent();
            estateAgent.setEstateAgentName(estateAgentDTO.getEstateAgentName());
            estateAgent.setEstateAgentSurname(estateAgentDTO.getEstateAgentSurname());
            estateAgent.setEstateAgentPhone(estateAgentDTO.getEstateAgentPhone());
            estateAgent.setEstateAgentMail(estateAgentDTO.getEstateAgentMail());
            estateAgent.setEstateAgentTCKN(estateAgentDTO.getEstateAgentTCKN());
            return estateAgent;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting EstateAgentDTO to Model", e);
        }
    }

    public static EstateAgentDTO estateAgentModelToDto(EstateAgent estateAgent) throws DtoModelConvertException {

        try {
            EstateAgentDTO estateAgentDTO = new EstateAgentDTO();
            estateAgentDTO.setEstateAgentName(estateAgent.getEstateAgentName());
            estateAgentDTO.setEstateAgentSurname(estateAgent.getEstateAgentSurname());
            estateAgentDTO.setEstateAgentPhone(estateAgent.getEstateAgentPhone());
            estateAgentDTO.setEstateAgentMail(estateAgent.getEstateAgentMail());
            estateAgentDTO.setEstateAgentTCKN(estateAgent.getEstateAgentTCKN());
            return estateAgentDTO;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting EstateAgent to DTO", e);
        }
    }

    public static ApartmentDTO apartmentModelToDto(Apartment apartment) throws DtoModelConvertException {
        try {
            ApartmentDTO apartmentDTO = new ApartmentDTO();
            apartmentDTO.setApartmentName(apartment.getApartmentName());
            apartmentDTO.setApartmentAddress(apartment.getApartmentAddress());
            apartmentDTO.setHouses(apartment.getHouses());
            apartmentDTO.setUuid(apartment.getUuid());
            return apartmentDTO;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting Apartment to DTO", e);
        }
    }

    public List<ApartmentDTO> apartmentsModelToDto(List<Apartment> apartments) throws DtoModelConvertException {
        try {
            List<ApartmentDTO> apartmentDTOList = new ArrayList<>();

            for (Apartment apartment : apartments) {
                ApartmentDTO apartmentDTO = apartmentModelToDto(apartment);
                apartmentDTOList.add(apartmentDTO);
            }

            return apartmentDTOList;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting Apartment to DTO", e);
        }
    }

    public static List<EstateAgentDTO> estateAgentsModelToDto(List<EstateAgent> estateAgents) throws DtoModelConvertException {
        try {
            List<EstateAgentDTO> estateAgentDTOList = new ArrayList<>();

            for (EstateAgent estateAgent : estateAgents) {
                EstateAgentDTO estateAgentDTO = estateAgentModelToDto(estateAgent);
                estateAgentDTOList.add(estateAgentDTO);
            }
            return estateAgentDTOList;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting EstateAgent to DTO", e);
        }


    }

    public static List<OwnerDTO> ownersModelToDto(List<Owner> owners) throws DtoModelConvertException {
        try {
            List<OwnerDTO> ownersDTOList = new ArrayList<>();

            for (Owner owner : owners) {
                OwnerDTO ownerDTO = ownerModelToDto(owner);
                ownersDTOList.add(ownerDTO);
            }
            return ownersDTOList;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting Owner to DTO", e);
        }

    }

    public static List<TenantDTO> tenantsModelToDto(List<Tenant> tenants) throws DtoModelConvertException {
        try {
            List<TenantDTO> tenantsDtoList = new ArrayList<>();

            for (Tenant tenant : tenants) {
                TenantDTO tenantDTO = tenantModelToDto(tenant);
                tenantsDtoList.add(tenantDTO);
            }
            return tenantsDtoList;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting Tenant to DTO", e);
        }

    }
}
