package com.TenantManager.TenantManager.models;

import java.util.List;
import java.util.UUID;


public class OwnerHouse {

  private UUID ownerID;
  private String ownerName;
  private String ownerSurname;
  private String ownerPhone;
  private String ownerMail;
  private String ownerHouse;
  private List<RentContract> rentContracts;


  public UUID getOwnerID() {
    return ownerID;
  }

  public void setOwnerID() {
    this.ownerID = UUID.randomUUID();
  }

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

  public String getOwnerHouse() {
    return ownerHouse;
  }

  public void setOwnerHouse(String ownerHouse) {
    this.ownerHouse = ownerHouse;
  }

  public List<RentContract> getRentContracts() {
    return rentContracts;
  }

  public void setRentContracts(List<RentContract> rentContracts) {
    this.rentContracts = rentContracts;
  }
}
