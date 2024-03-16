package com.example.tuanvm4rest.ultilities;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.*;
import com.nimbusds.jwt.*;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Date;

public class JwtExampleRS256 {

    public static void main(String[] args) throws JOSEException, ParseException {
        // Generate an RSA key pair
        KeyPair keyPair = generateRSAKeyPair();

        // Create a JWT with a payload using RS256 for signing
        String jwt = createJwt(keyPair);

        System.out.println("Generated JWT:");
        System.out.println(jwt);

        // Verify the JWT using RS256 for verification
        boolean isValid = verifyJwt(jwt, keyPair);

        System.out.println("JWT Verification Result: " + isValid);
    }

    private static KeyPair generateRSAKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048); // Key size: 2048 bits
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating RSA key pair", e);
        }
    }

    private static String createJwt(KeyPair keyPair) throws JOSEException {
        // Create an RSA key signer
        JWSSigner signer = new RSASSASigner((RSAPrivateKey) keyPair.getPrivate());

        // Create a JWT header with the RS256 algorithm
        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256).keyID("key123").build();

        // Create a JWT payload
        Payload payload = new Payload("{'sub':'1234567890','name':'John Doe','iat':" + new Date().getTime() + "}");

        // Create the signed JWT
        JWSObject jwsObject = new JWSObject(header, payload);
        jwsObject.sign(signer);

        // Serialize the JWT to a string
        return jwsObject.serialize();
    }

    private static boolean verifyJwt(String jwt, KeyPair keyPair) throws ParseException, JOSEException {
        // Parse the JWT string
        JWSObject jwsObject = JWSObject.parse(jwt);

        // Create an RSA key verifier
        JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey) keyPair.getPublic());

        // Verify the signature
        return jwsObject.verify(verifier);
    }
}
