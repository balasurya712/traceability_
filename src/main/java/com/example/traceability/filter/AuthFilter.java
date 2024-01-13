package com.example.traceability.filter;

import java.io.IOException;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.traceability.models.Supplier;
import com.example.traceability.models.User;
import com.example.traceability.repository.SupplierRepository;
import com.example.traceability.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public  class AuthFilter extends OncePerRequestFilter{
    
    String secerateKey="tmPvyTA/jc3OAfg4FUA0DNr25OOP49T9fBIUNsZ8xnUuIjEf3XCjngUmKdbKlfag";

    @Autowired
    UserRepository repo;
    public boolean validateToken(String token) {
        try {
            
            // String supplierName=extractUser(token);
            // User user = repo.findByUsername(supplierName).get();
            // if(user!=null){
            // String name = user.getUsername();
            // System.out.println(""+user.getUsername());
            // }
            
            // System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            // System.out.println(supplierName);
            // + "  " + user.getUsername()
            // System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            // if(supplierName.equals( user.getUsername()))
            Jwts.parser().setSigningKey(secerateKey).parseClaimsJws(token);
            // else
            // return false;
            return true;
        } catch (Exception e) {
           return false;
        }
    }
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

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
            if(new AntPathRequestMatcher("/auth/**").matches(request)){
                filterChain.doFilter(request, response);
                return ;
            }
            String header = request.getHeader("Authorization");
            System.out.println(header);
            String token=header.substring(7);
        boolean validity=validateToken(token);
        System.out.println(validity);
        if(!validity){
            throw new RestClientException("token invalid");
        }
        filterChain.doFilter(request, response);
    }

    
   
}
