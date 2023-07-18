package com.example.springapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springapp.configurations.JwtUtil;
import com.example.springapp.model.LoginRequest;
import com.example.springapp.model.LoginResponse;
import com.example.springapp.model.Role;
import com.example.springapp.model.User;
import com.example.springapp.repository.RoleRepository;
import com.example.springapp.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service 
public class AuthServiceImpl implements AuthService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

//    @Override
//    public User registerUserService(User user) throws Exception 
//    {
//        User temp = userRepository.findByUsername(user.getUsername());
//        if (temp != null) {
//            throw new Exception("User Already Exists");
//        } 
//        else 
//        {
//            Role role = roleRepository.findById("USER").isPresent() ? roleRepository.findById("USER").get() : null;
//            Set<Role> userRoles = new HashSet<>();
//            userRoles.add(role);
//            user.setRoles(userRoles);
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            return userRepository.save(user);
//        }
//    }
    @Override
    public User registerUserService(User user) throws Exception
    {
        User temp = userRepository.findByUsername(user.getUsername());
        if (temp != null)
        {
            throw new Exception("User Already Exists");
        }
        else 
        {
            String email = user.getUsername(); // assuming the email is stored in the username field
            System.out.println("Mail id is "+email);
            Role role = null;
            if (email!=null && email.equals("admin123@gmail.com")) 
            {
                role = roleRepository.findById("ADMIN").orElse(null);
            } 
            else 
            {
                role = roleRepository.findById("USER").orElse(null);
            }
            if (role == null)
            {
                throw new Exception("Invalid Role");
            }
            
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(role);
            user.setRoles(userRoles);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
    }


    public LoginResponse loginUserService(LoginRequest loginRequest) throws Exception {

        authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(loginRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return new LoginResponse(userRepository.findByUsername(loginRequest.getUsername()), token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
    
    
    public User getUserprofile(Long id)
    {
    	Optional<User> opt= userRepository.findById(id);
    	return opt.get();
    }
    
    
    public User editUserProfile(User user,Long id)
    {
    	Optional<User> opt= userRepository.findById(id);
    	if(opt.isPresent())
    	{
    	User u = opt.get();
    	u.setFirstName(user.getFirstName());
    	u.setLastName(user.getLastName());
    	u.setPhoneNumber(user.getPhoneNumber());
    	
    	return userRepository.save(u);
    	}
    	return user;
    }
    
    
    
}
