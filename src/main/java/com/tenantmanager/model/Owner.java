package com.tenantmanager.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

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
    @Email
    private String ownerMail;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "owner")
    private List<House> ownerHouses;
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
