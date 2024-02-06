package com.tenantmanager.dto;

import com.tenantmanager.model.House;

import java.util.List;

public class OwnerDTO {
    private String ownerName;
    private String ownerSurname;
    private String ownerPhone;
    private String ownerMail;
    private List<House> ownerHouse;
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


    public List<House> getOwnerHouse() {
        return ownerHouse;
    }

    public void setOwnerHouse(List<House> ownerHouse) {
        this.ownerHouse = ownerHouse;
    }
}
