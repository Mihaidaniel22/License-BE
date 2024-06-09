package com.endava.expensesmanager.generator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtGenerator {
    private static final Key SECRET_KEY = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

    public static String createJWT(String username, Integer userId, long ttlMillis) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("id", userId);

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + ttlMillis * 1000;
        Date exp = new Date(expMillis);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SECRET_KEY)
                .compact();
    }
}
