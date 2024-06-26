package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.response.MembershipResponse;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.MembershipRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IMembershipService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.MembershipMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MembershipService  implements  IMembershipService {

    @Autowired
    private MembershipMapper membershipMapper;

    @Autowired
    private final MembershipRepository membershipRepository;

    @Override
    public Page<MembershipResponse> getAll(int page, int size) {
        if(page < 0)
        page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.membershipRepository.findAll(pagination).map(membership -> membershipMapper.toResponse(membership));
    }
  
}
