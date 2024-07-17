package com.riwi.localstorage.riwi_local_storage.adapters.security.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.adapters.security.jwt.JwtService;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Role;
import com.riwi.localstorage.riwi_local_storage.domain.entities.User;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails user = userRepository.findOneByEmail(request.getUsername());

        String token = jwtService.getToken(user);

        return AuthResponse.builder()
               .token(token)
               .build();
    }

    public AuthResponse register(RegisterRequest request) {

        User user = new User();
        Role role = new Role();

        role.setId(request.getRole());

        user.setFirstname(request.getFirstName());
        user.setLastname(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setRole(role);

        this.userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

}
