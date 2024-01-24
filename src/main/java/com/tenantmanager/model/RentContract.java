package com.tenantmanager.model;

import jakarta.persistence.*;


import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "rentcontracts")
public class RentContract {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private long id;
    @Column
    private String uuid;
    @Column(nullable = false)
    private Tenant tenant;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    @Column(nullable = false)
    private String rentContractPrice;
    @Column(nullable = false)
    private String rentContractDeposit;



    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRentContractPrice() {
        return rentContractPrice;
    }

    public void setRentContractPrice(String rentContractPrice) {
        this.rentContractPrice = rentContractPrice;
    }

    public String getRentContractDeposit() {
        return rentContractDeposit;
    }

    public void setRentContractDeposit(String rentContractDeposit) {
        this.rentContractDeposit = rentContractDeposit;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = UUID.randomUUID().toString();
    }

}
