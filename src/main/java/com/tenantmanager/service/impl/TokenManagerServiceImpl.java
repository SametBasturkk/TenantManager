package com.tenantmanager.service.impl;

import com.tenantmanager.configuration.TokenManagerConfiguration;
import com.tenantmanager.service.api.TokenManagerService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenManagerServiceImpl implements TokenManagerService {


    @Override
    public String generateToken(String content) {
        return Jwts.builder().setSubject(content).setExpiration(new Date(System.currentTimeMillis() + TokenManagerConfiguration.getEXPIRATION())).signWith(SignatureAlgorithm.HS256, TokenManagerConfiguration.getSECRET()).compact();
    }

}
