package com.tenantmanager.service.impl;

import com.tenantmanager.exception.DbException;
import com.tenantmanager.model.Tenant;
import com.tenantmanager.repository.TenantRepository;
import com.tenantmanager.service.api.TenantService;
import com.tenantmanager.util.Validator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    private final Validator validatorService;

    public TenantServiceImpl(TenantRepository tenantRepository, Validator validatorService) {
        this.tenantRepository = tenantRepository;
        this.validatorService = validatorService;
    }


    @Override
    @Transactional
    public Tenant createTenant(Tenant tenant) {

        return tenantRepository.save(tenant);
    }

    @Override
    public List getTenantByNameAndSurname(String tenantName, String tenantSurname) {
        List<Tenant> tenantList = tenantRepository.findByTenantNameAndTenantSurname(tenantName, tenantSurname);
        if (tenantList.isEmpty()) {
            throw new IllegalArgumentException("Tenant not found");
        }
        return tenantList;
    }

    @Override
    public Tenant getTenantByTCKN(String TCKN) {
        return tenantRepository.findByTenantTCKN(TCKN);
    }

    @Override
    public Tenant getTenantById(Long tenantId) {
        return tenantRepository.findById(tenantId).orElseThrow(() -> new DbException("Tenant not found"));
    }


}