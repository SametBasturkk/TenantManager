package com.tenantmanager.model;

import jakarta.persistence.*;


import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tenants")
public class Tenant {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String tenantID;
    @Column(nullable = false)
    private String tenantName;
    @Column(nullable = false)
    private String tenantSurname;
    @Column(nullable = false)
    private String tenantPhone;
    @Column(nullable = false)
    private String tenantMail;
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<RentContract> rentContracts;


    public String getTenantID() {
        return tenantID;
    }

    public void setTenantID(UUID tenantID) {
        this.tenantID = UUID.randomUUID().toString();
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
