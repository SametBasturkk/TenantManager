package com.tenantmanager.service.impl;

import com.tenantmanager.configuration.TokenManagerConfiguration;
import com.tenantmanager.service.api.TokenManagerService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenManagerServiceImpl implements TokenManagerService {

    private static TokenManagerConfiguration tokenManagerConfiguration;


    TokenManagerServiceImpl(TokenManagerConfiguration TokenManagerConfiguration) {
        this.tokenManagerConfiguration = TokenManagerConfiguration;
    }


    @Override
    public String generateToken(String content) {
        return Jwts.builder()
                .setSubject(content)
                .setExpiration(new Date(System.currentTimeMillis() + tokenManagerConfiguration.getExpiration()))
                .signWith(SignatureAlgorithm.HS256, tokenManagerConfiguration.getSecret())
                .compact();
    }

}
