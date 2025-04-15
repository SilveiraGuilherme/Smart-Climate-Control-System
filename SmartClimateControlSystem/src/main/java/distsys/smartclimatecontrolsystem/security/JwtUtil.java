package distsys.smartclimatecontrolsystem.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;
import java.util.Date;
import java.nio.charset.StandardCharsets;

public class JwtUtil {

    // At least 32 characters (256 bits) for HS256
    public static final String SECRET = "mysecretkey1234567890mysecretkey!"; 

    public static final SecretKey SECRET_KEY = new SecretKeySpec(
        SECRET.getBytes(StandardCharsets.UTF_8),
        SignatureAlgorithm.HS256.getJcaName()
    );

    public static String generateToken(String subject) {
        long expirationTimeMillis = 3600000; // 1 hour
        return Jwts.builder()
            .setSubject(subject)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expirationTimeMillis))
            .signWith(SECRET_KEY)
            .compact();
    }
}