package com.tenantmanager.service.api;

import com.tenantmanager.dto.TenantDTO;
import com.tenantmanager.model.Tenant;

import java.util.List;

public interface TenantService {

    public List<Tenant> getTenantByNameAndSurname(String tenantName, String tenantSurname);

    public Tenant getTenantByTCKN(String TCKN);

    public Tenant createTenant(TenantDTO tenantDTO);

    public Tenant getTenantById(Long tenantId);

    public void deleteTenant(Long tenantId);

    public void updateTenant(Long tenantId, TenantDTO tenant);
}
