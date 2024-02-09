package com.tenantmanager.controller;

import com.tenantmanager.dto.TenantDTO;
import com.tenantmanager.model.Tenant;
import com.tenantmanager.service.impl.TenantServiceImpl;
import com.tenantmanager.util.DTOConverter;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get-tenant-by-name-surname")
    public ResponseEntity getTenantByNameAndSurname(@RequestParam String tenantName, String tenantSurname) {
        List<TenantDTO> response = converter.tenantsModelToDto(tenantService.getTenantByNameAndSurname(tenantName, tenantSurname));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/get-tenant-by-tckn")
    public ResponseEntity getTenantByTCKN(@RequestParam String TCKN) {
        TenantDTO response = converter.tenantModelToDto(tenantService.getTenantByTCKN(TCKN));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/delete-tenant")
    public ResponseEntity deleteTenant(@RequestParam Long tenantId) {
        tenantService.deleteTenant(tenantId);
        return ResponseEntity.status(HttpStatus.OK).body("Tenant deleted");
    }

    @PostMapping("/update-tenant")
    public ResponseEntity updateTenant(@RequestParam Long tenantId, @RequestBody TenantDTO tenant) {
        tenantService.updateTenant(tenantId, tenant);
        return ResponseEntity.status(HttpStatus.OK).body("Tenant updated");
    }

    public ResponseEntity fallback(Exception e) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
    }
}
