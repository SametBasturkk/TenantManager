package com.tenantmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TenantDTO {
    @NotBlank(message = "Tenant name cannot be blank")
    private String tenantName;

    @NotBlank(message = "Tenant surname cannot be blank")
    private String tenantSurname;

    @NotBlank(message = "Tenant phone cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String tenantPhone;

    @NotBlank(message = "Tenant mail cannot be blank")
    @Pattern(regexp = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    private String tenantMail;

    @NotBlank(message = "Tenant TCKN cannot be blank")
    @Size(min = 11, max = 11, message = "TCKN must be 11 characters")
    @Pattern(regexp = "\\d{11}", message = "TCKN must be numeric")
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
