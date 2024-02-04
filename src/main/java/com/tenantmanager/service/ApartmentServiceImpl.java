package com.tenantmanager.service;

import com.tenantmanager.model.Apartment;
import com.tenantmanager.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class ApartmentServiceImpl implements AparmentService {

    private final ApartmentRepository apartmentRepository;


    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public void createApartment(String apartmentName, String apartmentAddress) {
        Apartment apartment = new Apartment();
        apartment.setApartmentName(apartmentName);
        apartment.setApartmentAddress(apartmentAddress);
        apartmentRepository.save(apartment);
    }

    @Override
    public Apartment getApartmentById(String apartmentId) {
        return apartmentRepository.findById(Long.parseLong(apartmentId)).orElse(null);
    }
}
