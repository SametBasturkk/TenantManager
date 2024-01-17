package com.TenantManager.TenantManager.exception;

public class CustomResponseException extends Exception {
    public CustomResponseException(String message) {
        super(message);
        consoleOutputOfException(message);
    }

    public static void consoleOutputOfException(String message) {
        System.out.println(message);
    }
}
