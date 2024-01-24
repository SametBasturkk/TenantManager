package com.tenantmanager.controller;

import com.tenantmanager.util.DTOConverter;
import com.tenantmanager.dto.OwnerDTO;
import com.tenantmanager.exception.CustomResponseException;
import com.tenantmanager.model.Owner;
import com.tenantmanager.service.OwnerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final OwnerServiceImpl ownerService;
    private DTOConverter converter;

    public RestController(OwnerServiceImpl ownerService, DTOConverter converter) {
        this.ownerService = ownerService;
        this.converter = converter;
    }

    @PostMapping("/create-owner")
    public ResponseEntity createOwner(@RequestBody Owner owner) {
        Owner newOwner = new Owner();
        newOwner.setOwnerName(owner.getOwnerName());
        newOwner.setOwnerSurname(owner.getOwnerSurname());
        newOwner.setOwnerPhone(owner.getOwnerPhone());
        newOwner.setOwnerMail(owner.getOwnerMail());
        newOwner.setOwnerHouse(owner.getOwnerHouse());
        newOwner.setOwnerTCKN(owner.getOwnerTCKN());

        ownerService.addOwner(newOwner);

        return ResponseEntity.ok(newOwner);
    }

    @GetMapping("/get-owner-by-name-surname")
    public ResponseEntity getOwnerByNameAndSurname(@RequestParam String ownerName, String ownerSurname) {
        OwnerDTO response = converter.modelToDto(ownerService.getOwnerByNameAndSurname(ownerName, ownerSurname));
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

    @GetMapping("/get-owner-by-tckn")
    public ResponseEntity getOwnerByTCKN(@RequestParam String TCKN) {
        OwnerDTO response = converter.modelToDto(ownerService.getOwnerByTCKN(TCKN));
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
