package com.tenantmanager.controller;

import com.tenantmanager.dto.HouseDTO;
import com.tenantmanager.service.impl.HouseServiceImpl;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RateLimiter(name = "simpleRateLimit")
public class HouseController {


    private final HouseServiceImpl houseService;

    public HouseController(HouseServiceImpl houseService) {
        this.houseService = houseService;
    }


    @PostMapping("/create-house")
    public ResponseEntity createHouse(@RequestBody HouseDTO houseDTO) {
        houseService.createHouse(houseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("House created");
    }

    @PostMapping("/delete-house")
    public ResponseEntity deleteHouse(@RequestParam Long houseId) {
        houseService.deleteHouse(houseId);
        return ResponseEntity.status(HttpStatus.OK).body("House deleted");
    }

    @PostMapping("/update-house-owner")
    public ResponseEntity updateHouseOwner(@RequestParam Long houseId, Long ownerId) {
        houseService.updateHouseOwner(houseId, ownerId);
        return ResponseEntity.status(HttpStatus.OK).body("House owner updated");
    }

    @GetMapping("/get-house-by-owner-id")
    public ResponseEntity getHouseByOwnerId(@RequestParam Long ownerId) {
        return ResponseEntity.status(HttpStatus.OK).body(houseService.getHouseByOwnerId(ownerId));
    }


    public ResponseEntity fallback(Exception e) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
    }
}
