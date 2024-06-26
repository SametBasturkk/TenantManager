package com.tenantmanager.controller;

import com.tenantmanager.dto.OwnerDTO;
import com.tenantmanager.service.impl.OwnerServiceImpl;
import com.tenantmanager.service.impl.TokenManagerServiceImpl;
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
    private final DTOConverter converter;
    private final TokenManagerServiceImpl tokenManagerServiceImpl;

    public OwnerController(OwnerServiceImpl ownerService, DTOConverter converter, TokenManagerServiceImpl tokenManagerServiceImpl) {
        this.ownerService = ownerService;
        this.converter = converter;
        this.tokenManagerServiceImpl = tokenManagerServiceImpl;
    }


    @PostMapping("/create-owner")
    public ResponseEntity createOwner(@RequestBody @Valid OwnerDTO ownerDTO) {
        OwnerDTO response = converter.ownerModelToDto(ownerService.createOwner(ownerDTO));
        return ResponseEntity.status(HttpStatus.CREATED).header("JWT", tokenManagerServiceImpl.generateToken("test")).body(response);
    }

    @GetMapping("/get-owner-by-name-surname")
    public ResponseEntity getOwnerByNameAndSurname(@RequestParam String ownerName, String ownerSurname) {
        return ResponseEntity.status(HttpStatus.OK).body(converter.ownersModelToDto(ownerService.getOwnerByNameAndSurname(ownerName, ownerSurname)));
    }

    @GetMapping("/get-owner-by-tckn")
    public ResponseEntity getOwnerByTCKN(@RequestParam String TCKN) {
        OwnerDTO response = converter.ownerModelToDto(ownerService.getOwnerByTCKN(TCKN));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/delete-owner")
    public ResponseEntity deleteOwner(@RequestParam Long ownerId) {
        ownerService.deleteOwner(ownerId);
        return ResponseEntity.status(HttpStatus.OK).body("Owner deleted");
    }

    @PostMapping("/update-owner")
    public ResponseEntity updateOwner(@RequestParam Long ownerId, @RequestBody OwnerDTO owner) {
        ownerService.updateOwner(ownerId, owner);
        return ResponseEntity.status(HttpStatus.OK).body("Owner updated");
    }

    public ResponseEntity fallback(Exception e) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
    }
}
