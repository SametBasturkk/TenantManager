package com.tenantmanager.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tenantmanager.dto.ApartmentDTO;
import com.tenantmanager.dto.EstateAgentDTO;
import com.tenantmanager.dto.OwnerDTO;
import com.tenantmanager.dto.TenantDTO;
import com.tenantmanager.exception.DtoModelConvertException;
import com.tenantmanager.model.Apartment;
import com.tenantmanager.model.EstateAgent;
import com.tenantmanager.model.Owner;
import com.tenantmanager.model.Tenant;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTOConverter {

    private static ModelMapper modelMapper = new ModelMapper();
    private static ObjectLogger logObject = new ObjectLogger();


    public static OwnerDTO ownerModelToDto(Owner owner) throws DtoModelConvertException {
        try {
            OwnerDTO ownerDTO = modelMapper.map(owner, OwnerDTO.class);
            logObject.objectLogAsJSON(ownerDTO);
            return ownerDTO;
        } catch (DtoModelConvertException | JsonProcessingException e) {
            throw new DtoModelConvertException("Error converting Owner to DTO", e);
        }
    }


    public static Owner ownerDtoToModel(OwnerDTO ownerDTO) throws DtoModelConvertException {
        try {
            Owner owner = modelMapper.map(ownerDTO, Owner.class);
            return owner;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting OwnerDTO to Model", e);
        }
    }

    public static Tenant tenantDtoToModel(TenantDTO tenantDTO) throws DtoModelConvertException {
        try {
            Tenant tenant = modelMapper.map(tenantDTO, Tenant.class);
            return tenant;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting TenantDTO to Model", e);
        }
    }

    public static TenantDTO tenantModelToDto(Tenant tenant) throws DtoModelConvertException {
        try {
            TenantDTO tenantDTO = modelMapper.map(tenant, TenantDTO.class);
            return tenantDTO;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting Tenant to DTO", e);
        }
    }

    public static EstateAgent estateAgentDtoToModel(EstateAgentDTO estateAgentDTO) throws DtoModelConvertException {
        try {
            EstateAgent estateAgent = modelMapper.map(estateAgentDTO, EstateAgent.class);
            return estateAgent;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting EstateAgentDTO to Model", e);
        }
    }

    public static EstateAgentDTO estateAgentModelToDto(EstateAgent estateAgent) throws DtoModelConvertException {

        try {
            EstateAgentDTO estateAgentDTO = modelMapper.map(estateAgent, EstateAgentDTO.class);
            return estateAgentDTO;
        } catch (Exception e) {
            throw new DtoModelConvertException("Error converting EstateAgent to DTO", e);
        }
    }

    public static ApartmentDTO apartmentModelToDto(Apartment apartment) throws DtoModelConvertException {
        try {
            ApartmentDTO apartmentDTO = modelMapper.map(apartment, ApartmentDTO.class);
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
