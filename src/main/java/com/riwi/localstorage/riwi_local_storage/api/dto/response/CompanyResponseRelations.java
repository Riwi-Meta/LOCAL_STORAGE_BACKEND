package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponseRelations {
    private String id;
    private String email;
    private Integer phone;
    private String address;


    private List<SupplierResponse> suppliers;
}
