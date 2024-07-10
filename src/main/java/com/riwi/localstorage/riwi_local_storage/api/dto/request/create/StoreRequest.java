package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import com.riwi.localstorage.riwi_local_storage.domain.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreRequest {

    private Integer id;
    private String name;
    private User user;
    
}
