package com.riwi.localstorage.riwi_local_storage.adapters.security.auth;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    public AuthResponse login(LoginRequest request) {
        // Authenticate user and generate token
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        // Create new user and generate token
        return null;
    }

}
