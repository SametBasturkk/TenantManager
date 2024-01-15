package com.TenantManager.TenantManager.models;

import java.util.List;

public class Apartment {

  private String apartmentAddress;

  private String apartmentName;

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
  }

  public List<House> getHouses() {
    return houses;
  }

  public void setHouses(List<House> houses) {
    this.houses = houses;
  }
}
