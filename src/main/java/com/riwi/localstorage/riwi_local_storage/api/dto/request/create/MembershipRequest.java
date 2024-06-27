package com.riwi.localstorage.riwi_local_storage.api.dto.request.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class MembershipRequest {
    
    private String name;
}
