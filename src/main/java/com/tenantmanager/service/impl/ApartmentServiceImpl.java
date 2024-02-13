package com.tenantmanager.service.impl;

import com.tenantmanager.exception.DbException;
import com.tenantmanager.model.Apartment;
import com.tenantmanager.repository.ApartmentRepository;
import com.tenantmanager.service.api.ApartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final ModelMapper modelMapper;


    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, ModelMapper modelMapper) {
        this.apartmentRepository = apartmentRepository;
        this.modelMapper = modelMapper;
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
        return apartmentRepository.findById(apartmentId).orElseThrow(() -> new DbException("Apartment not found"));
    }

    @Override
    public List<Apartment> getApartments() {
        List<Apartment> apartments = new ArrayList<>(apartmentRepository.findAll());
        if (apartments.isEmpty()) {
            throw new DbException("No apartments found");
        }
        return apartments;
    }

    @Override
    @Transactional
    public void deleteApartment(Long apartmentId) {
        apartmentRepository.deleteById(apartmentId);
    }

    @Override
    @Transactional
    public void updateApartment(Long apartmentId, String apartmentName, String apartmentAddress) {
        Apartment apartment = apartmentRepository.findById(apartmentId).orElseThrow(() -> new DbException("Apartment not found"));
        modelMapper.map(apartment, apartment);
        apartmentRepository.save(apartment);
    }
}
