package com.djordje.realtime_notifications.controller;

import com.djordje.realtime_notifications.dto.LoginRequestDTO;
import com.djordje.realtime_notifications.dto.LoginResponseDTO;
import com.djordje.realtime_notifications.model.User;
import com.djordje.realtime_notifications.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        System.out.println("Connected------");
        userService.register(user);
        return "User registered successfully";
    }

    @GetMapping("/ping")
    public String ping() {
        System.out.println("Ping endpoint called!");

        return "Backend is up!";
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        String token =  userService.login(loginRequestDTO.getUsername(),loginRequestDTO.getPassword());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}