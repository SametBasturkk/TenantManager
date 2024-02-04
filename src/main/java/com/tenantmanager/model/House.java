package com.tenantmanager.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "houses")
public class House {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String uuid;
    @OneToOne
    private Owner owner;
    @Column(nullable = false)
    private String houseAddress;
    @Column(nullable = false)
    private String houseType;
    @Column(nullable = false)
    private String housePrice;
    @Column(nullable = false)
    private String houseRooms;
    @ManyToOne
    @JoinColumn(name = "apartment")
    private Apartment apartment;

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
        setUuid();
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(String housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseRooms() {
        return houseRooms;
    }

    public void setHouseRooms(String houseRooms) {
        this.houseRooms = houseRooms;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID().toString();
    }


}