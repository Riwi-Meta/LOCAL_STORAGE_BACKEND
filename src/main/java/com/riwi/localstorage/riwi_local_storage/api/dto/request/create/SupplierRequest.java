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
public class SupplierRequest {
    @NotBlank(message = "The name is required")
    @Size(max = 100,  message = "The name must be less than 100 characters")
    private String name; 

    @NotBlank(message = "Contact is required")
    @Size(max = 100,  message = "The contact must be less than 100 characters")
    private String contact;

    @NotBlank(message = "Adress is required")
    @Size(max = 100)
    private String address;

    @NotBlank(message = "The phone number is required")
    @Size(max = 22)
    private Integer phone;

    @Email(message = "The email must be a valid email")
    private String email;

}
