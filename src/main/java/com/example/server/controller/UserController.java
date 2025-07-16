package com.example.server.controller;

import com.example.server.config.JwtUtils;
import com.example.server.model.User;
import com.example.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user){
        try{
            User newUser= userService.addUser(user);
            newUser.setPassword(null);
            return ResponseEntity.status(201).body(newUser);
        }catch (Exception e){
            return ResponseEntity.status(400).body("Bad request");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword())
        );
        if(authentication.isAuthenticated()){
            UserDetails userDetails=userService.loadUserByUsername(user.getUserName());
            String token=jwtUtils.generateToken(userDetails);
            User authenticatedUser=userService.getUserDetails(user.getUserName());
            Map<String,String> tokenMap=new HashMap<>();
            tokenMap.put("token",token);
            tokenMap.put("user_id",String.valueOf( authenticatedUser.getUser_id()));
            tokenMap.put("user_name",authenticatedUser.getUserName());
            return ResponseEntity.ok(tokenMap);
        }else {
            return ResponseEntity.status(401).body("User Name or password not vaild");
        }
    }
}
