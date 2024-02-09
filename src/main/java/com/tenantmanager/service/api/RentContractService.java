package com.tenantmanager.service.api;

import com.tenantmanager.dto.RentContractDTO;

public interface RentContractService {

    public void createRentContract(RentContractDTO rentContractDTO);

    public void deleteRentContract(Long rentContractId);

    public void updateRentContract(Long rentContractId, RentContractDTO rentContract);

    public Object getRentContractByTenantId(Long tenantId);
}
