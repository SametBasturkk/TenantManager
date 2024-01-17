package com.TenantManager.TenantManager.controller;

import com.TenantManager.TenantManager.util.DTOConverter;
import com.TenantManager.TenantManager.dto.OwnerDTO;
import com.TenantManager.TenantManager.exception.CustomResponseException;
import com.TenantManager.TenantManager.service.OwnerServiceImpl;
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
    public ResponseEntity createOwner(@RequestBody com.TenantManager.TenantManager.model.Owner owner) {
        com.TenantManager.TenantManager.model.Owner newOwner = new com.TenantManager.TenantManager.model.Owner();
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
