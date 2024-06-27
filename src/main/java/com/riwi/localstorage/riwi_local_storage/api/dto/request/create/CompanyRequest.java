package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {

    @Email(message = "The email must be a valid email")
    private String email;

    @NotBlank(message = "The phone number is required")
    @Size(max = 22)
    private Integer phone;

    @NotBlank(message = "Adress is required")
    @Size(max = 100)
    private String address;
    
}
