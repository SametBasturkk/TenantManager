package com.tenantmanager.controller;

import com.tenantmanager.dto.TenantDTO;
import com.tenantmanager.exception.CustomResponseException;
import com.tenantmanager.model.Tenant;
import com.tenantmanager.service.TenantServiceImpl;
import com.tenantmanager.util.DTOConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TenantController {

    private final TenantServiceImpl tenantService;
    private DTOConverter converter;

    public TenantController(TenantServiceImpl tenantService, DTOConverter converter) {
        this.tenantService = tenantService;
        this.converter = converter;
    }

    @PostMapping("/create-tenant")
    public ResponseEntity createTenant(@RequestBody Tenant tenant) {
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
        List<Tenant> tenantList = tenantService.getTenantByNameAndSurname(tenantName, tenantSurname);
        List<TenantDTO> responseList = new ArrayList<>();
        for (Tenant tenant : tenantList) {
            responseList.add(converter.tenantModelToDto(tenant));
        }
        try {
            if (responseList.isEmpty()) {
                throw new CustomResponseException("Tenant not found");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(responseList);
            }
        } catch (CustomResponseException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
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
}
