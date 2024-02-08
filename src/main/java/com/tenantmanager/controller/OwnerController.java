package com.tenantmanager.controller;

import com.tenantmanager.dto.OwnerDTO;
import com.tenantmanager.exception.DtoModelConvertException;
import com.tenantmanager.model.Owner;
import com.tenantmanager.service.impl.OwnerServiceImpl;
import com.tenantmanager.util.DTOConverter;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RateLimiter(name = "simpleRateLimit")
public class OwnerController {

    private final OwnerServiceImpl ownerService;
    private DTOConverter converter;

    public OwnerController(OwnerServiceImpl ownerService, DTOConverter converter) {
        this.ownerService = ownerService;
        this.converter = converter;
    }


    @PostMapping("/create-owner")
    public ResponseEntity createOwner(@RequestBody @Valid Owner owner) {
        OwnerDTO response = converter.ownerModelToDto(ownerService.createOwner(owner));
        try {
            if (response == null) {
                throw new DtoModelConvertException("Owner not created");
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }
        } catch (DtoModelConvertException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/get-owner-by-name-surname")
    public ResponseEntity getOwnerByNameAndSurname(@RequestParam String ownerName, String ownerSurname) {
        return ResponseEntity.status(HttpStatus.OK).body(converter.ownersModelToDto(ownerService.getOwnerByNameAndSurname(ownerName, ownerSurname)));
    }

    @GetMapping("/get-owner-by-tckn")
    public ResponseEntity getOwnerByTCKN(@RequestParam String TCKN) {
        OwnerDTO response = converter.ownerModelToDto(ownerService.getOwnerByTCKN(TCKN));
        try {
            if (response == null) {
                throw new DtoModelConvertException("Owner not found");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (DtoModelConvertException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    public ResponseEntity fallback(Exception e) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
    }
}
