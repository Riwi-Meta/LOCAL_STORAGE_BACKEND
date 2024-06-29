package com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.MembershipRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.MembershipResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.CreateService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.ReadAllService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.generic.UpdateService;

public interface IMembershipService extends
    CreateService<MembershipRequest, MembershipResponse>,
    ReadAllService<MembershipResponse>,
    UpdateService<MembershipRequest, MembershipResponse, String> {

  public void updateMembershipStatus(String id, boolean enabled);

  public MembershipResponse getById(String id);
}
