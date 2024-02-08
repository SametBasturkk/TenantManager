package com.tenantmanager.exception;

public class DtoModelConvertException extends RuntimeException {
    public DtoModelConvertException(String message,Exception e) {
        super(message + " " + e.getMessage());
    }
    public DtoModelConvertException(String e) {
        super(e);
    }
}
