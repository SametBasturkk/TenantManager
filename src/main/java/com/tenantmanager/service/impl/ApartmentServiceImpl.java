package com.tenantmanager.service.impl;

import com.tenantmanager.model.Apartment;
import com.tenantmanager.repository.ApartmentRepository;
import com.tenantmanager.service.api.ApartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;


    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    @Transactional
    public void createApartment(String apartmentName, String apartmentAddress) {
        Apartment apartment = new Apartment();
        apartment.setApartmentName(apartmentName);
        apartment.setApartmentAddress(apartmentAddress);
        apartmentRepository.save(apartment);
    }

    @Override
    public Apartment getApartmentById(Long apartmentId) {
        return apartmentRepository.findById(apartmentId).orElse(null);
    }

    @Override
    public List getApartments() {
        List apartments = new ArrayList<>(apartmentRepository.findAll());
        return apartments;
    }

    @Override
    @Transactional
    public void deleteApartment(Long apartmentId) {
        apartmentRepository.deleteById(apartmentId);
    }
}
