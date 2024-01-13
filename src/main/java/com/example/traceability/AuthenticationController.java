package com.example.traceability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.traceability.models.User;
import com.example.traceability.service.impl.UserServiceCollection;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService service;

    @Autowired
    UserServiceCollection userServiceCollection;
    @Autowired
    UserService userService;

    @GetMapping("path")
    public String getMethodName() {
        return "sdfs";
    }
    

    @PostMapping("/save")
    public String login(@RequestBody User user){
        userServiceCollection.saveData(user);
        return service.generateToken(user.getUsername(),user.getPassword());
    }

    @GetMapping("/verify/{name}")
    public boolean getMethodName(HttpServletRequest request, @PathVariable String name) {
        return service.isTokenValid(request.getHeader("Authorization").split(" ",2)[1],name);
    }

    @GetMapping("/ga")
    public ResponseEntity<?> grantedauth() {
        return new ResponseEntity<>(userServiceCollection.findUser(),HttpStatus.OK);
        // return service2;
    }

     @GetMapping("/aa")
    public ResponseEntity<?> all() {
        return new ResponseEntity<>(userServiceCollection.findUserAll(),HttpStatus.OK);
        // return service2;
    }
    
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?> runtimeExeHandle(){
        return new ResponseEntity<>("UNAUTHORIZED EXE", HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<?> nullPointerExeHandle(){
        return new ResponseEntity<>("Null Pointer EXE", HttpStatus.CONFLICT);
    }
}