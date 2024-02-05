package com.tenantmanager.dto;

public class TenantDTO {
    private String tenantName;
    private String tenantSurname;
    private String tenantPhone;
    private String tenantMail;
    private String tenantTCKN;

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantSurname() {
        return tenantSurname;
    }

    public void setTenantSurname(String tenantSurname) {
        this.tenantSurname = tenantSurname;
    }

    public String getTenantPhone() {
        return tenantPhone;
    }

    public void setTenantPhone(String tenantPhone) {
        this.tenantPhone = tenantPhone;
    }

    public String getTenantMail() {
        return tenantMail;
    }

    public void setTenantMail(String tenantMail) {
        this.tenantMail = tenantMail;
    }

    public String getTenantTCKN() {
        return tenantTCKN;
    }

    public void setTenantTCKN(String tenantTCKN) {
        this.tenantTCKN = tenantTCKN;
    }
}
