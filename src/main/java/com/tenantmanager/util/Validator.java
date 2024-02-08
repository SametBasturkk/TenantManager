package com.tenantmanager.util;

import org.springframework.stereotype.Component;

@Component
public class Validator implements ValidatorService {
    public static final String TCKN_REGEX = "^[1-9]{1}[0-9]{10}$";
    public static final String PHONE_NUMBER_REGEX = "/^(?:\\+90.?5|0090.?5|905|0?5)(?:[01345][0-9])\\s?(?:[0-9]{3})\\s?(?:[0-9]{2})\\s?(?:[0-9]{2})$/";
    public static final String NAME_REGEX = "^[a-zA-Z]+$";
    public static final String SURNAME_REGEX = "^[a-zA-Z]+$";

}
