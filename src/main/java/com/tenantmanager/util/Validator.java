package com.tenantmanager.util;

import org.springframework.stereotype.Component;

@Component
public class Validator implements ValidatorService {
    public static final String TCKN_REGEX = "^[1-9]{1}[0-9]{10}$";
    public static final String PHONE_NUMBER_REGEX = "(^05\\d{2})(\\s|-)?(\\d{3})(\\s|-)?(\\d{4})";
    public static final String NAME_REGEX = "^[a-zA-Z]+$";
    public static final String SURNAME_REGEX = "^[a-zA-Z]+$";
    public static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

}
