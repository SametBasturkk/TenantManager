package com.tenantmanager.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private long id;
    @Column(nullable = false)
    private String ownerName;
    @Column(nullable = false)
    private String ownerSurname;
    @Column(nullable = false)
    private String ownerPhone;
    @Column(nullable = false)
    private String ownerMail;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<House> ownerHouses;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<RentContract> rentContracts;
    @Column(nullable = false, unique = true, name = "owner_tckn")
    private String ownerTCKN;



    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public void setOwnerMail(String ownerMail) {
        this.ownerMail = ownerMail;
    }


    public List<RentContract> getRentContracts() {
        return rentContracts;
    }

    public void setRentContracts(List<RentContract> rentContracts) {
        this.rentContracts = rentContracts;
    }

    public String getOwnerTCKN() {
        return ownerTCKN;
    }

    public void setOwnerTCKN(String ownerTCKN) {
        this.ownerTCKN = ownerTCKN;
    }


    public List<House> getOwnerHouses() {
        return ownerHouses;
    }

    public void setOwnerHouses(List<House> ownerHouses) {
        this.ownerHouses = ownerHouses;
    }
}
