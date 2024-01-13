package com.example.traceability;


import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtServerRequestService {
    
    String secerateKey="tmPvyTA/jc3OAfg4FUA0DNr25OOP49T9fBIUNsZ8xnUuIjEf3XCjngUmKdbKlfag";

     public String extractUser(String token){
        return extractAllClaims(token).getSubject();
    }
    
    @Deprecated
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
