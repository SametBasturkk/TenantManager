package com.tenantmanager.dto;

public class HouseDTO {
    private Long ownerId;
    private String houseType;
    private String houseAddress;
    private Integer housePrice;
    private Integer houseRooms;
    private Long apartmentId;


    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public Integer getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(Integer housePrice) {
        this.housePrice = housePrice;
    }

    public Integer getHouseRooms() {
        return houseRooms;
    }

    public void setHouseRooms(Integer houseRooms) {
        this.houseRooms = houseRooms;
    }

    public Long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Long apartmentId) {
        this.apartmentId = apartmentId;
    }
}
