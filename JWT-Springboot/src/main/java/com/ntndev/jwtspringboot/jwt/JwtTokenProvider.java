package com.ntndev.jwtspringboot.jwt;


import com.ntndev.jwtspringboot.security.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {

    @Value("${com.ntndev.jwtspringboot.jwt.secret}")
    private String JWT_SECRET;

    @Value("${com.ntndev.jwtspringboot.jwt.expiration}")
    private int JWT_EXPIRATION;

    //Tao jwt tu thong tin cua user
    public String generateToken(CustomUserDetails customUserDetails){
        Date now = new Date();
        Date dateExpired = new Date(now.getTime() + JWT_EXPIRATION);

        //Tao chuoi jwt tu userName
        return Jwts.builder()
                .setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(dateExpired)
                .signWith(SignatureAlgorithm.ES512, JWT_SECRET)
                .compact();

    }

    // Lay thong tin user tu jwt
    public String getUserNameFromJwt (String token){
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET)
                .parseClaimsJws(token).getBody();
        //tra lai thong tin userName
        return claims.getSubject();
    }

    //Validate thong tin cua chuoi jwt
    public boolean validateToken(String authToken){
        try {
            Jwts.parser().setSigningKey(JWT_SECRET)
                    .parseClaimsJws(authToken);
            return true;
        }catch (MalformedJwtException ex){
            log.error("Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            log.error("Expired JWT Token");
        }catch (UnsupportedJwtException ex){
            log.error("Unsupported JWT Token");
        }catch (IllegalArgumentException ex){
            log.error("JWT claims String is empty");
        }
        return false;
    }

}
