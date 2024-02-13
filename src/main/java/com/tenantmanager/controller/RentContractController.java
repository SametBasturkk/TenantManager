package com.tenantmanager.controller;

import com.tenantmanager.dto.RentContractDTO;
import com.tenantmanager.service.impl.RentContractServiceImpl;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RateLimiter(name = "simpleRateLimit")
public class RentContractController {

    private final RentContractServiceImpl rentContractService;

    public RentContractController(RentContractServiceImpl rentContractService) {
        this.rentContractService = rentContractService;
    }

    @PostMapping("/create-rent-contract")
    public ResponseEntity createRentContract(@RequestBody RentContractDTO rentContractDTO) {
        rentContractService.createRentContract(rentContractDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rent contract created");
    }

    @PostMapping("/delete-rent-contract")
    public ResponseEntity deleteRentContract(@RequestParam Long rentContractId) {
        rentContractService.deleteRentContract(rentContractId);
        return ResponseEntity.status(HttpStatus.OK).body("Rent contract deleted");
    }

    @PostMapping("/update-rent-contract")
    public ResponseEntity updateRentContract(@RequestParam Long rentContractId, @RequestBody RentContractDTO rentContract) {
        rentContractService.updateRentContract(rentContractId, rentContract);
        return ResponseEntity.status(HttpStatus.OK).body("Rent contract updated");
    }

    @GetMapping("/get-rent-contract-by-tenant-id")
    public ResponseEntity getRentContractByTenantId(@RequestParam Long tenantId) {
        return ResponseEntity.status(HttpStatus.OK).body(rentContractService.getRentContractByTenantId(tenantId));
    }


    public ResponseEntity fallback(Exception e) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
    }
}
