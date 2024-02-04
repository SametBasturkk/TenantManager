package com.tenantmanager.service;

import com.tenantmanager.model.Apartment;

public interface ApartmentService {

   public void createApartment(String apartmentName, String apartmentAddress);
    public Apartment getApartmentById(String apartmentId);
}
