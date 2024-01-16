package com.TenantManager.TenantManager.model;

public class House {

  private Apartment apartment;

  private Owner owner;

  private String houseAddress;

  private String houseType;

  private String housePrice;

  private String houseRooms;


  public Apartment getApartment() {
    return apartment;
  }

  public void setApartment(Apartment apartment) {
    this.apartment = apartment;
  }

  public Owner getOwnerHouse() {
    return owner;
  }

  public void setOwnerHouse(Owner owner) {
    this.owner = owner;
  }

  public String getHouseAddress() {
    return houseAddress;
  }

  public void setHouseAddress(String houseAddress) {
    this.houseAddress = houseAddress;
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
}
