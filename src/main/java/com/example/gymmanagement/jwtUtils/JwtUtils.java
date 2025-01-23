package com.example.gymmanagement.jwtUtils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

//    @Value("${jwt.secret}")
    private String jwtSecret = "92851a5496b8227b6e0fb8b698312b23f429d87fc476bdfc5bf24249654bbc35";

    @Value("${jwt.expiration}")
    private long jwtExpiration; // en milisegundos, p.e. 86400000 para 24h

    public String generateToken(String username) {
        // username será "email" en tu caso
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            // Token inválido, expirado, etc.
            return false;
        }
    }
}
