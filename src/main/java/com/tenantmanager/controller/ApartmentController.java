package com.tenantmanager.controller;

import com.tenantmanager.service.ApartmentServiceImpl;
import com.tenantmanager.util.DTOConverter;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RateLimiter(name = "simpleRateLimit", fallbackMethod = "fallback")
public class ApartmentController {

    ApartmentServiceImpl apartmentService;

    DTOConverter converter;

    public ApartmentController(ApartmentServiceImpl apartmentService, DTOConverter converter) {
        this.apartmentService = apartmentService;
        this.converter = converter;
    }


    @PostMapping("/create-apartment")
    public ResponseEntity createApartment(@RequestParam String apartmentName, String apartmentAddress) {
        apartmentService.createApartment(apartmentName, apartmentAddress);
        return ResponseEntity.status(HttpStatus.CREATED).body("Apartment created");
    }

    @GetMapping("/get-apartments")
    public ResponseEntity getApartments() {
        return ResponseEntity.status(HttpStatus.OK).body(converter.apartmentsModelToDto(apartmentService.getApartments()));
    }

    @PostMapping("/remove-apartment")
    public ResponseEntity removeApartment(@RequestParam Long apartmentId) {
        apartmentService.removeApartment(apartmentId);
        return ResponseEntity.status(HttpStatus.OK).body("Apartment removed");
    }

    public ResponseEntity fallback(Exception e) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
    }

}
