package com.tenantmanager.controller;

import com.tenantmanager.service.RentContractServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class RentContractController {

    RentContractServiceImpl rentContractService;

    public RentContractController(RentContractServiceImpl rentContractService) {
        this.rentContractService = rentContractService;
    }

    @PostMapping("/create-rent-contract")
    public void createRentContract(@RequestParam String estateAgentId, @RequestParam String tenantId, @RequestParam String startdate, @RequestParam String enddate, @RequestParam String houseId, @RequestParam String apartmentId, @RequestParam String rentContractPrice, @RequestParam String rentContractDeposit) {
        rentContractService.createRentContract(estateAgentId, tenantId, startdate, enddate, houseId, apartmentId, rentContractPrice, rentContractDeposit);
    }
}
