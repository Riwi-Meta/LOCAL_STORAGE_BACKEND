package com.riwi.localstorage.riwi_local_storage.adapters.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY = "EJEMPLO8SD3S9DF1S29F38SD8F4SDF77123";
    
    public String getToken(UserDetails user){
        return getToken(new HashMap<>(), user);
    }

    private String getToken(HashMap<String, Object> claims, UserDetails user) {
        return Jwts.builder()
        .setClaims(claims)
        .setSubject(user.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
        .signWith(getKey(), SignatureAlgorithm.HS256)
        .compact();
    }

    private Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
