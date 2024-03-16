package com.example.tuanvm4rest.ultilities.test;

import com.example.tuanvm4rest.ultilities.JwtTokenHandlerRSA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class JwtTokenHandlerRSATest {

    @Test
    public void testSuccessfulVerification() {
        // Arrange
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", "123456");
        claims.put("username", "johndoe");

        String token = JwtTokenHandlerRSA.generateToken(claims, 3600000);

        // Act
        Map<String, Object> verifiedClaims = JwtTokenHandlerRSA.verifyToken(token);

        // Assert
        // Assert
        Assertions.assertEquals(claims.get("userId"), verifiedClaims.get("userId"));
        Assertions.assertEquals(claims.get("username"), verifiedClaims.get("username"));
        Assertions.assertNotNull(verifiedClaims.get("iat"));
        Assertions.assertNotNull(verifiedClaims.get("exp"));    }

    @Test
    public void testFailedVerification() {
        // Arrange
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", "123456");
        claims.put("username", "johndoe");

        String token = JwtTokenHandlerRSA.generateToken(claims, 3600000);

        // Tamper with the token
        String[] tokenParts = token.split("\\.");
        String tamperedToken = tokenParts[0] + "." + tokenParts[1] + ".Invalid_Signature";

        // Act and Assert
        Assertions.assertThrows(io.jsonwebtoken.JwtException.class, () -> {
            JwtTokenHandlerRSA.verifyToken(tamperedToken);
        });
    }
}