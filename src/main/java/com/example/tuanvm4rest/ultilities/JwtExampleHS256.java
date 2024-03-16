package com.example.tuanvm4rest.ultilities;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.*;

import java.text.ParseException;
import java.util.Date;

public class JwtExampleHS256 {

    public static void main(String[] args) throws JOSEException, ParseException {
        // Your shared secret (you can change this)
        String sharedSecret = "your_shared_secret_dont_use_in_production";

        // Create a JWT with a payload
        String jwt = createJwt(sharedSecret);

        System.out.println("Generated JWT:");
        System.out.println(jwt);

        // Verify the JWT
        boolean isValid = verifyJwt(jwt, sharedSecret);

        System.out.println("JWT Verification Result: " + isValid);
    }

    private static String createJwt(String sharedSecret) throws JOSEException {
        // Create a JWT signer with the shared secret
        JWSSigner signer = new MACSigner(sharedSecret);

        // Create a JWT header with the HMAC SHA-256 algorithm
        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.HS256).build();

        // Create a JWT payload
        Payload payload = new Payload("{'sub':'1234567890','name':'John Doe and Tuan Co','iat':" + new Date().getTime() + "}");

        // Create the signed JWT
        JWSObject jwsObject = new JWSObject(header, payload);
        jwsObject.sign(signer);

        // Serialize the JWT to a string
        return jwsObject.serialize();
    }

    private static boolean verifyJwt(String jwt, String sharedSecret) throws ParseException, JOSEException {
        // Parse the JWT string
        JWSObject jwsObject = JWSObject.parse(jwt);

        // Create a verifier with the shared secret
        JWSVerifier verifier = new MACVerifier(sharedSecret);

        // Verify the signature
        return jwsObject.verify(verifier);
    }
}
