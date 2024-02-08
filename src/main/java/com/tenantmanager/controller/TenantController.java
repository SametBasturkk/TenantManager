package com.tenantmanager.controller;

import com.tenantmanager.dto.TenantDTO;
import com.tenantmanager.exception.CustomResponseException;
import com.tenantmanager.model.Tenant;
import com.tenantmanager.service.impl.TenantServiceImpl;
import com.tenantmanager.util.DTOConverter;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RateLimiter(name = "simpleRateLimit")
public class TenantController {

    private final TenantServiceImpl tenantService;
    private DTOConverter converter;

    public TenantController(TenantServiceImpl tenantService, DTOConverter converter) {
        this.tenantService = tenantService;
        this.converter = converter;
    }

    @PostMapping("/create-tenant")
    public ResponseEntity createTenant(@RequestBody @Valid Tenant tenant) {
        TenantDTO response = converter.tenantModelToDto(tenantService.createTenant(tenant));
        try {
            if (response == null) {
                throw new CustomResponseException("Tenant not created");
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }
        } catch (CustomResponseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/get-tenant-by-name-surname")
    public ResponseEntity getTenantByNameAndSurname(@RequestParam String tenantName, String tenantSurname) {
        return ResponseEntity.status(HttpStatus.OK).body(converter.tenantsModelToDto(tenantService.getTenantByNameAndSurname(tenantName, tenantSurname)));

    }

    @GetMapping("/get-tenant-by-tckn")
    public ResponseEntity getTenantByTCKN(@RequestParam String TCKN) {
        TenantDTO response = converter.tenantModelToDto(tenantService.getTenantByTCKN(TCKN));
        try {
            if (response == null) {
                throw new CustomResponseException("Tenant not found");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (CustomResponseException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    public ResponseEntity fallback(Exception e) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
    }
}
