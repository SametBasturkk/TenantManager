package com.tenantmanager.dto;

import java.util.Date;

public class RentContractDTO {
    private Long estateAgentId;
    private Long tenantId;
    private Date startDate;
    private Date endDate;
    private Long houseId;
    private Long apartmentId;
    private Integer rentContractPrice;
    private Integer rentContractDeposit;

    public Long getEstateAgentId() {
        return estateAgentId;
    }

    public void setEstateAgentId(Long estateAgentId) {
        this.estateAgentId = estateAgentId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
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

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Long apartmentId) {
        this.apartmentId = apartmentId;
    }


    public Integer getRentContractPrice() {
        return rentContractPrice;
    }

    public void setRentContractPrice(Integer rentContractPrice) {
        this.rentContractPrice = rentContractPrice;
    }

    public Integer getRentContractDeposit() {
        return rentContractDeposit;
    }

    public void setRentContractDeposit(Integer rentContractDeposit) {
        this.rentContractDeposit = rentContractDeposit;
    }
}
