package com.example.springsecuritydemo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;

@Service
public class JwtService {

    private static final String SECRET_KEY = "f85IhI7qFykaFKkVm2Pbq61YAo+RVnn6EqKEIPOxXABfl73nVOpQPo5UhrDYuFlv";

    public String extractUserEmail(String token) {
        return null;
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .decryptWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKeySpec getSignInKey() {
        SignatureAlgorithm sa = SignatureAlgorithm.HS256;
        return new SecretKeySpec(SECRET_KEY.getBytes(), sa.getJcaName());
    }

}
