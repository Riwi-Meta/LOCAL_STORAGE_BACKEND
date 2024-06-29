package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.MembershipRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.MembershipNotFoundException;

import com.riwi.localstorage.riwi_local_storage.api.dto.response.MembershipResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Membership;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.MembershipRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IMembershipService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.MembershipMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MembershipService implements IMembershipService {

    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    MembershipMapper membershipMapper;

    @Override
    public MembershipResponse create(MembershipRequest request) {
        Membership membership = membershipMapper.requestToEntity(request);
        return membershipMapper.entityToResponse(membershipRepository.save(membership));
    }

    @Override
    public MembershipResponse getById(String id) {
        Membership membership = this.findMembership(id);

        return membershipMapper.entityToResponse(membership);

    }

    @Override
    public void updateMembershipStatus(String id, boolean enabled) {
        Membership membership = findMembership(id);

        membership.setEnabled(enabled);
        this.membershipRepository.save(membership);
    }

    private Membership findMembership(String id) {

        return this.membershipRepository.findById(id).orElseThrow(() -> new MembershipNotFoundException(id));
    }

    @Override
    public Page<MembershipResponse> getAll(Pageable pageable) {

        return this.membershipRepository.findAll(pageable)
                .map(membership -> membershipMapper.entityToResponse(membership));
    }

    @Override
    public MembershipResponse update(String id, MembershipRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
