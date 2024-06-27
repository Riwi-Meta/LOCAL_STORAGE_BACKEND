package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.MembershipRequest;
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
  public void delete(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public Page<MembershipResponse> getAll(Pageable pageable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  @Override
  public Optional<MembershipResponse> getById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
  }

  @Override
  public MembershipResponse update(String id, MembershipRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

}
