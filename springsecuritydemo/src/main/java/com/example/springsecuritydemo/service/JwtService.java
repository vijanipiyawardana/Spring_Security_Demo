package com.example.springsecuritydemo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String extractUserEmail(String token) {
        return null;
    }

    private Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey("")
//                .parseClaimsJws(token)
//                .getBody();
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build().parseClaimsJws(token)
                .getBody();
    }

}
