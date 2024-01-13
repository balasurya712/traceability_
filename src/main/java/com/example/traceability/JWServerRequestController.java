package com.example.traceability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/jwt/api")
public class JWServerRequestController {
    @Autowired
    AuthenticationService service;
    @GetMapping("/request/{name}")
    public ResponseEntity<?> hello(HttpServletRequest request,@PathVariable String name) {
        boolean result=service.isTokenValid(request.getHeader("Authorization").split(" ",2)[1],name);
        if(result)
        return new ResponseEntity<>("Authorized", HttpStatus.OK);
        else
        return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/greet")
    public ResponseEntity<?> greet(){
        return ResponseEntity.ok("Welcome");
    }
    
}