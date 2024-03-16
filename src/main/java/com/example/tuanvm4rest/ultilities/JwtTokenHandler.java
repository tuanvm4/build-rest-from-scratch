package com.example.tuanvm4rest.ultilities;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenHandler {

    private static final String SECRET_KEY = "your_secret_key_here,your_secret_key_here";

    public static String generateToken(Map<String, Object> claims, long expirationInMillis) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationInMillis))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public static Map<String, Object> verifyToken(String token) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public static void main(String[] args) {
        // Example usage
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", "123456");
        claims.put("username", "johndoe");
        claims.put("gender", "male");


        String token = generateToken(claims, 3600000); // Token valid for 1 hour
        System.out.println("Generated token: " + token);

        Map<String, Object> verifiedClaims = verifyToken(token);
        System.out.println("Verified claims: " + verifiedClaims);
    }
}