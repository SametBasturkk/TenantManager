package com.tenantmanager.model;

import jakarta.persistence.*;


import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "aparments")
public class Apartment {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String uuid;
    @Column(nullable = false)
    private String apartmentAddress;
    @Column(nullable = false)
    private String apartmentName;
    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
    private List<House> houses;


    public String getApartmentAddress() {
        return apartmentAddress;
    }

    public void setApartmentAddress(String apartmentAddress) {
        this.apartmentAddress = apartmentAddress;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
        setUuid();
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID().toString();
    }

}
