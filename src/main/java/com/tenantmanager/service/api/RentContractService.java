package com.tenantmanager.service.api;

import com.tenantmanager.dto.RentContractDTO;

public interface RentContractService {

public void createRentContract(RentContractDTO rentContractDTO);

    void deleteRentContract(Long rentContractId);

    void updateRentContract(Long rentContractId, RentContractDTO rentContract);

    Object getRentContractByTenantId(Long tenantId);
}
