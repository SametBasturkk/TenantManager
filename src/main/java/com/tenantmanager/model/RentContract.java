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

    @ManyToOne
    @JoinColumn(name = "estate_agent_id")
    private EstateAgent rentContractEstateAgent;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private Integer rentContractPrice;

    @Column(nullable = false)
    private Integer rentContractDeposit;
    @OneToOne
    private House house;


    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public EstateAgent getRentContractEstateAgent() {
        return rentContractEstateAgent;
    }

    public void setRentContractEstateAgent(EstateAgent rentContractEstateAgent) {
        this.rentContractEstateAgent = rentContractEstateAgent;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        setUuid(UUID.randomUUID().toString());
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


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = (uuid != null) ? uuid : UUID.randomUUID().toString();
    }

    public Integer getRentContractPrice() {
        return rentContractPrice;
    }

    public void setRentContractPrice(Integer rentContractPrice) {
        this.rentContractPrice = rentContractPrice;
    }

    public Integer getRentContractDeposit() {
        return rentContractDeposit;
    }

    public void setRentContractDeposit(Integer rentContractDeposit) {
        this.rentContractDeposit = rentContractDeposit;
    }
}
