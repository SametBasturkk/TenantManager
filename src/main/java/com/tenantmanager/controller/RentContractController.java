package com.tenantmanager.controller;

import com.tenantmanager.dto.RentContractDTO;
import com.tenantmanager.service.RentContractServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class RentContractController {

    RentContractServiceImpl rentContractService;

    public RentContractController(RentContractServiceImpl rentContractService) {
        this.rentContractService = rentContractService;
    }

    @PostMapping("/create-rent-contract")
    public ResponseEntity createRentContract(@RequestBody RentContractDTO rentContract) {
        rentContractService.createRentContract(rentContract);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rent contract created");
    }
}
