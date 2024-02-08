package com.tenantmanager.service.api;

import com.tenantmanager.model.Tenant;

import java.util.List;

public interface TenantService {

    public List getTenantByNameAndSurname(String tenantName, String tenantSurname);

    public Tenant getTenantByTCKN(String TCKN);

    public Tenant createTenant(Tenant tenant);

    Tenant getTenantById(Long tenantId);
}