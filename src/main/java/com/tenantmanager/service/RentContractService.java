package com.tenantmanager.service;

public interface RentContractService {

public void createRentContract(String estateAgentId, String tenantId, String startdate, String enddate, String houseId, String apartmentId, String rentContractPrice, String rentContractDeposit);
}
