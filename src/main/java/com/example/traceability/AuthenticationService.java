package com.example.traceability;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class AuthenticationService {
    
    String secerateKey="tmPvyTA/jc3OAfg4FUA0DNr25OOP49T9fBIUNsZ8xnUuIjEf3XCjngUmKdbKlfag";

    
    public String generateToken(String username, String pwd) {
        Claims claim=Jwts.claims().setSubject(username);
        Map <String , Object> map=new HashMap<>();
        map.put("role","ADMIN");
        claim.putAll(map);
        String token=Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS256,secerateKey).compact();
        Claims claims=Jwts.parser()
        .setSigningKey(secerateKey)
        .parseClaimsJws(token)
        .getBody();
        String role=claims.get("role").toString();
        System.out.println(role);
        return token;
    }

    
    public String extractUser(String token){
        return extractClaims(token, Claims::getSubject);
    }


    public <T> T extractClaims(String token, Function<Claims,T> claimsResolver){
        Claims claim=extractAllClaims(token);
        return claimsResolver.apply(claim);
    }
    
    public Claims extractAllClaims(String token){
        return Jwts.parser()
        .setSigningKey(secerateKey)
        .parseClaimsJws(token)
        .getBody();
    }

    public boolean isTokenValid(String token,String name){
        String supplierName=extractUser(token);
        return supplierName.equals(name);
    }
}
