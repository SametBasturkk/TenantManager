package com.tenantmanager.service.api;

import com.tenantmanager.model.Apartment;

import java.util.List;

public interface ApartmentService {

    public void createApartment(String apartmentName, String apartmentAddress);

    public Apartment getApartmentById(Long apartmentId);

    public List<Apartment> getApartments();

    public void deleteApartment(Long apartmentId);

    void updateApartment(Long apartmentId, String apartmentName, String apartmentAddress);
}
