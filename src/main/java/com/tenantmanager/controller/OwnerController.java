package com.tenantmanager.controller;

import com.tenantmanager.dto.OwnerDTO;
import com.tenantmanager.exception.CustomResponseException;
import com.tenantmanager.model.Owner;
import com.tenantmanager.service.OwnerServiceImpl;
import com.tenantmanager.util.DTOConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class OwnerController {

    private final OwnerServiceImpl ownerService;
    private DTOConverter converter;

    public OwnerController(OwnerServiceImpl ownerService, DTOConverter converter) {
        this.ownerService = ownerService;
        this.converter = converter;
    }

    @PostMapping("/create-owner")
    public ResponseEntity createOwner(@RequestBody Owner owner) {
        OwnerDTO response = converter.ownerModelToDto(ownerService.createOwner(owner));
        try {
            if (response == null) {
                throw new CustomResponseException("Owner not created");
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }
        } catch (CustomResponseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/get-owner-by-name-surname")
    public ResponseEntity getOwnerByNameAndSurname(@RequestParam String ownerName, String ownerSurname) {
        List<Owner> ownerList = ownerService.getOwnerByNameAndSurname(ownerName, ownerSurname);
        List<OwnerDTO> responseList = new ArrayList<>();
        for (Owner owner : ownerList) {
            responseList.add(converter.ownerModelToDto(owner));
        }
        try {
            if (responseList.isEmpty()) {
                throw new CustomResponseException("Owner not found");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(responseList);
            }
        } catch (CustomResponseException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get-owner-by-tckn")
    public ResponseEntity getOwnerByTCKN(@RequestParam String TCKN) {
        OwnerDTO response = converter.ownerModelToDto(ownerService.getOwnerByTCKN(TCKN));
        try {
            if (response == null) {
                throw new CustomResponseException("Owner not found");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (CustomResponseException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
