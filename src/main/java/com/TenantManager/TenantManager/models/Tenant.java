package com.TenantManager.TenantManager.models;

import java.util.List;
import java.util.UUID;

public class Tenant {

  private UUID tenantID;
  private String tenantName;
  private String tenantSurname;
  private String tenantPhone;
  private String tenantMail;
  private List<RentContract> rentContracts;


  public UUID getTenantID() {
    return tenantID;
  }

  public void setTenantID(UUID tenantID) {
    this.tenantID = tenantID;
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
