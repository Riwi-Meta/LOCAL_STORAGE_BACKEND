package com.riwi.localstorage.riwi_local_storage.api.dto.request.update;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateLocationRequest {

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String branchId;

}
