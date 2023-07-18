package com.example.springapp.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springapp.model.LoginRequest;
import com.example.springapp.model.LoginResponse;
import com.example.springapp.model.User;
import com.example.springapp.service.AuthService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AuthController
{

    @Autowired
    AuthService authService;


    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception
    {
        return authService.registerUserService(user);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) throws Exception
    {
        return authService.loginUserService(loginRequest);
    }
    
    
    @GetMapping("/home")
    public String homepage()
    {
    	return "Home Page";
    }
    
    @GetMapping("/currentuser")
    public String getUSer(Principal principal)
    {
    	return principal.getName();
    }
    
    
    
    @PutMapping("/profile/{id}")
    public ResponseEntity<User> profileedit(@RequestBody User user,@PathVariable("id") long id)
    {
       User u = authService.editUserProfile(user, id);
       return ResponseEntity.ok(u);
    }
    
    @GetMapping("/profile/{id}")
    public ResponseEntity<User> profilepage(@PathVariable("id") long id )
    {
        User user = authService.getUserprofile(id);
    	return ResponseEntity.ok(user);
    }
    
    

}