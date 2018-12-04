package com.example.springbootmysqldb.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;

public class  JwtUtil {
    public static void addAuthentication(HttpServletResponse res, String username) {
        String token = Jwts.builder().setSubject(username).setExpiration(Date.from(Instant.ofEpochSecond(System.currentTimeMillis() / 1000 + 3 * 60))).signWith(SignatureAlgorithm.HS512, "P@tit0").compact();
        Date date = Date.from(Instant.ofEpochSecond(System.currentTimeMillis() / 1000 + 3 * 60));
        res.addHeader("Authorization", "Bearer " + token);
    }

    public static Authentication getAuthentication(HttpServletRequest servletRequest) {
        String token = servletRequest.getHeader("Authorization");
        if(token != null) {
            String user = Jwts.parser().setSigningKey("P@tit0").parseClaimsJws(token.replace("Bearer ", "")).getBody().getSubject();
            Date date = Jwts.parser().setSigningKey("P@tit0").parseClaimsJws(token.replace("Bearer ", "")).getBody().getExpiration();
            if(date.getTime() > System.currentTimeMillis()) {
                return user != null ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) : null;
            }
            return null;
        }
        return null;
    }
}
