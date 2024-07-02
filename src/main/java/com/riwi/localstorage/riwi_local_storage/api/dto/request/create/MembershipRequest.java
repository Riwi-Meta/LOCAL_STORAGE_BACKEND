package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class MembershipRequest {

    @NotBlank(message = "The type is required")
    @Length(max = 20, message = "The type must be less than 20 characters")
    private String type;
    @NotNull(message = "The price is required")
    @Positive(message = "The price must be a positive number")
    private double price;
    @Length(min = 1, message = "Invalid description")
    private String description;

}
