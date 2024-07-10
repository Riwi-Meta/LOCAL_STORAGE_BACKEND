package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import com.riwi.localstorage.riwi_local_storage.domain.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponse {
    private String id;
    private String name;
     private User user;
    
}
