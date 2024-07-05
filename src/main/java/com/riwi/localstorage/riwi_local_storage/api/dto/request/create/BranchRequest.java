package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchRequest {

    @Size(min = 1, max = 50, message = "The name must have a maximum of 50 characters.")
    private String name;

    @Email(message = "Invalid email")
    @Size(min = 1, max = 50, message = "The email must have a maximum of 50 characters.")
    private String email;

    @Size(min = 1, max = 50, message = "The city must have a maximum of 50 characters.")
    private String city;

    @Size(min = 1, max = 50, message = "The province must have a maximum of 50 characters.")
    private String province;

    @Size(min = 1, max = 50, message = "The country must have a maximum of 50 characters.")
    private String country;

    @Size(min = 1, max = 50, message = "The postal code must have a maximum of 50 characters.")
    private String postalCode;

    @Size(min = 1, max = 50, message = "The phone must have a maximum of 50 characters.")
    private String phone;

    @Column(nullable = false)
    private Long storeId;
}
