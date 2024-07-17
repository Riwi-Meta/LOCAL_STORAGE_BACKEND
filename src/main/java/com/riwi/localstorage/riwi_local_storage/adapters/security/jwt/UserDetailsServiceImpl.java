package com.riwi.localstorage.riwi_local_storage.adapters.security.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.domain.entities.User;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmail(email);

        if(user == null) { 
            throw new UsernameNotFoundException("User not found with that email address");
        }

        return user;
    }
}