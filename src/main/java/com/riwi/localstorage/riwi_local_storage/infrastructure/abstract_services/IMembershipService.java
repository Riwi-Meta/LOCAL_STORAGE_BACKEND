package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import org.springframework.data.domain.Page;


import com.riwi.localstorage.riwi_local_storage.api.dto.response.MembershipResponse;


public interface IMembershipService{

    public Page<MembershipResponse> getAll(int page, int size);

    public void updateMembershipStatus(String id, boolean enabled);

    public MembershipResponse getById(String id);
}
