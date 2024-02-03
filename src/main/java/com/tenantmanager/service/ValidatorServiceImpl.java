package com.tenantmanager.service;

import org.springframework.stereotype.Service;

@Service
public class ValidatorServiceImpl implements ValidatorService {

    @Override
    public boolean validateTCKN(String TCKN) {
        if (TCKN.length() != 11 || TCKN.charAt(0) == '0') {
            return false;
        }

        int total = calculateSumOfDigits(TCKN, 10);
        int lastDigit = Integer.parseInt(TCKN.substring(10, 11));

        return (total % 10) == lastDigit;
    }

    @Override
    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 10 && phoneNumber.charAt(0) == '5';
    }

    @Override
    public boolean validateEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    private int calculateSumOfDigits(String number, int length) {
        int total = 0;
        for (int i = 0; i < length; i++) {
            char digitChar = number.charAt(i);
            if (Character.isDigit(digitChar)) {
                total += Character.getNumericValue(digitChar);
            }
        }
        return total;
    }
}
