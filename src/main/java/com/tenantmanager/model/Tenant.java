package com.tenantmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Table(name = "tenants")
public class Tenant {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String tenantName;
    @Column(nullable = false)
    private String tenantSurname;
    @Column(nullable = false)
    private String tenantPhone;
    @Column(nullable = false)
    @Email
    private String tenantMail;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<RentContract> rentContracts;
    @Column(nullable = false, unique = true, name = "tenant_TCKN")
    private String tenantTCKN;

    public String getTenantTCKN() {
        return tenantTCKN;
    }

    public void setTenantTCKN(String tenantTCKN) {
        this.tenantTCKN = tenantTCKN;
    }

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

    public List<RentContract> getRentContracts() {
        return rentContracts;
    }

    public void setRentContracts(List<RentContract> rentContracts) {
        this.rentContracts = rentContracts;
    }
}
