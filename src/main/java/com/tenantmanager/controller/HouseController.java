package com.tenantmanager.controller;

import com.tenantmanager.dto.HouseDTO;
import com.tenantmanager.service.HouseServiceImpl;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@RateLimiter(name = "simpleRateLimit", fallbackMethod = "fallback")
public class HouseController {


    HouseServiceImpl houseService;

    public HouseController(HouseServiceImpl houseService) {
        this.houseService = houseService;
    }


    @PostMapping("/create-house")
    public ResponseEntity createHouse(@RequestBody HouseDTO house) {
        houseService.createHouse(house);
        return ResponseEntity.status(HttpStatus.CREATED).body("House created");
    }

    public ResponseEntity fallback(Exception e) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
    }
}
