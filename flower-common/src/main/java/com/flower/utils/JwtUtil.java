package com.flower.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class JwtUtil {

    private static final String SECRET_KEY = "Flower-Secret-Key-2026-Flower-Sale-Management-System";

    private static SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public static String createJWT(Map<String, Object> claims) {
        return Jwts.builder()
                .claims(claims)
                .signWith(getKey())
                .compact();
    }

    public static Claims parseJWT(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
