package com.tenantmanager.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
public class TokenManagerConfiguration {
    private static String SECRET;

    private static long EXPIRATION;

    public static String getSECRET() {
        return SECRET;
    }

    public static void setSECRET(String SECRET) {
        TokenManagerConfiguration.SECRET = SECRET;
    }

    public static long getEXPIRATION() {
        return EXPIRATION;
    }

    public static void setEXPIRATION(long EXPIRATION) {
        TokenManagerConfiguration.EXPIRATION = EXPIRATION;
    }
}
