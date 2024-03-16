package com.example.tuanvm4rest.ultilities;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenHandlerRSA {

    private static final String RSA_ALGORITHM = "RSA";
    private static final int RSA_KEY_SIZE = 2048;

    private static PrivateKey privateKey;
    private static PublicKey publicKey;

    static {
        try {
            // Generate a new RSA key pair
            java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance(RSA_ALGORITHM);
            keyPairGenerator.initialize(RSA_KEY_SIZE);
            java.security.KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Set the private and public keys
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();

            // Print the public key
            System.out.println("Public Key: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
            System.out.println("Private Key: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to generate RSA key pair", e);
        }
    }

    public static String generateToken(Map<String, Object> claims, long expirationInMillis) {
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationInMillis))
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    public static Map<String, Object> verifyToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(publicKey)
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
        claims.put("isRich", true);

        String token = generateToken(claims, 3600000); // Token valid for 1 hour
        System.out.println("Generated token: " + token);

        Map<String, Object> verifiedClaims = verifyToken(token);
        System.out.println("Verified claims: " + verifiedClaims);
    }
}