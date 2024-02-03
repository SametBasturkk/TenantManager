package com.tenantmanager.service;

public interface ValidatorService {

    public boolean validateTCKN(String TCKN);

    public boolean validatePhoneNumber(String phoneNumber);

    public boolean validateEmail(String email);



}
