package com.tenantmanager.controller;

import com.tenantmanager.service.ApartmentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ApartmentController {

    ApartmentServiceImpl apartmentService;
    public ApartmentController(ApartmentServiceImpl apartmentService) {
        this.apartmentService = apartmentService;
    }

    @PostMapping("/create-apartment")
    public ResponseEntity createApartment(@RequestParam String apartmentName, String apartmentAddress) {
        apartmentService.createApartment(apartmentName, apartmentAddress);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
