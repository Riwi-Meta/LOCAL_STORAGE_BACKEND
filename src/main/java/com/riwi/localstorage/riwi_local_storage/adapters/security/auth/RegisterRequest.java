package com.riwi.localstorage.riwi_local_storage.adapters.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String firstName;
    String lastName;
    String phone;
    String email;
    String password;
}
