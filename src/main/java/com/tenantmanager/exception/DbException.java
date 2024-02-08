package com.tenantmanager.exception;

public class DbException extends RuntimeException {
    public DbException(String message, Exception e) {
        super(message + " " + e.getMessage());
    }
    public DbException(String e) {
        super(e);
    }
}
