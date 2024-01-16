package com.TenantManager.TenantManager.model;

import java.util.Date;
import java.util.UUID;

public class RentContract {

  private UUID rentContractID;

  private Owner owner;

  private Tenant tenant;

  private Date startDate;

  private Date endDate;

  private String rentContractPrice;

  private String rentContractDeposit;


  public UUID getRentContractID() {
    return rentContractID;
  }

  public void setRentContractID(UUID rentContractID) {
    this.rentContractID = rentContractID;
  }

  public Owner getOwnerHouse() {
    return owner;
  }

  public void setOwnerHouse(Owner owner) {
    this.owner = owner;
  }

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
}
