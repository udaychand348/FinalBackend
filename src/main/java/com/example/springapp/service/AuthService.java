package com.example.springapp.service;

import com.example.springapp.model.LoginRequest;
import com.example.springapp.model.LoginResponse;
import com.example.springapp.model.User;

public interface AuthService 
{
    User registerUserService(User user) throws Exception;

    User getUserprofile(Long id);
    
    User editUserProfile(User user,Long id);
    
    LoginResponse loginUserService(LoginRequest loginRequest) throws Exception;
}