package com.riwi.localstorage.riwi_local_storage.adapters.security.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    //private final AuthService authService;
    
    @PostMapping(value = "login")
    public String login(@RequestBody LoginRequest request)
    {
        return "You're trying to login";
    }

    @PostMapping(value = "register")
    public String register(@RequestBody RegisterRequest request)
    {
        return "You're trying to register";
    }
}
