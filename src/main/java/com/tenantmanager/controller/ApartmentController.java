package com.tenantmanager.controller;

import com.tenantmanager.service.impl.ApartmentServiceImpl;
import com.tenantmanager.util.DTOConverter;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RateLimiter(name = "simpleRateLimit")
public class ApartmentController {

    private final ApartmentServiceImpl apartmentService;

    private final DTOConverter converter;

    private static final Logger logger = LoggerFactory.getLogger(ApartmentController.class);


    public ApartmentController(ApartmentServiceImpl apartmentService, DTOConverter converter) {
        this.apartmentService = apartmentService;
        this.converter = converter;
    }


    @PostMapping("/create-apartment")
    public ResponseEntity createApartment(@RequestParam String apartmentName, String apartmentAddress) {
        apartmentService.createApartment(apartmentName, apartmentAddress);
        logger.info("Apartment created");
        return ResponseEntity.status(HttpStatus.CREATED).body("Apartment created");
    }

    @GetMapping("/get-apartments")
    public ResponseEntity getApartments() {
        logger.info("Apartments retrieved");
        return ResponseEntity.status(HttpStatus.OK).body(converter.apartmentsModelToDto(apartmentService.getApartments()));
    }

    @PostMapping("/delete-apartment")
    public ResponseEntity deleteApartment(@RequestParam Long apartmentId) {
        apartmentService.deleteApartment(apartmentId);
        logger.info("Apartment deleted");
        return ResponseEntity.status(HttpStatus.OK).body("Apartment deleted");
    }

    @PostMapping("/update-apartment")
    public ResponseEntity updateApartment(@RequestParam Long apartmentId, @RequestParam String apartmentName, String apartmentAddress) {
        apartmentService.updateApartment(apartmentId, apartmentName, apartmentAddress);
        logger.info("Apartment updated");
        return ResponseEntity.status(HttpStatus.OK).body("Apartment updated");
    }

    public ResponseEntity fallback(Exception e) {
        logger.error("Too many requests");
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
    }

}
