package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierResponseRelations {
    private Long id; 
    private String name; 
    private String contact;
    private String address; 
    private Integer phone;
    private String email;

    private CompanyResponse company;
}
