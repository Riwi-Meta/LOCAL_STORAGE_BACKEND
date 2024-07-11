package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.MembershipRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.MembershipResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Membership;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.MembershipRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IMembershipService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.MembershipMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.MembershipNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MembershipService implements IMembershipService {

  @Autowired
  private final MembershipRepository membershipRepository;

  @Autowired
  private final MembershipMapper membershipMapper;

  @Override
  public MembershipResponse create(MembershipRequest request) {
    if (verifyName(request.getType()) != null) {
      throw new IllegalArgumentException("The type cant be repeated");
    }
    Membership membership = membershipMapper.requestToEntity(request);
    return membershipMapper.entityToResponse(
        membershipRepository.save(membership));
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

  @Override
  public Membership findMembership(String id) {
    return this.membershipRepository.findById(id)
        .orElseThrow(() -> new MembershipNotFoundException(id));
  }

  @Override
  public Page<MembershipResponse> getAll(Pageable pageable) {
    return this.membershipRepository.findAll(pageable)
        .map(membership -> membershipMapper.entityToResponse(membership));
  }

  @Override
  public MembershipResponse update(String id, MembershipRequest request) {
    Membership existingMembership = findMembership(id);
    if (verifyName(request.getType()) != null) {
      throw new IllegalArgumentException("The type cant be repeated");
    }
    membershipMapper.updateEntity(request, existingMembership);
    return membershipMapper.entityToResponse(
        membershipRepository.save(existingMembership));
  }

  private Membership verifyName(String type) {
    return this.membershipRepository.findByType(type);
  }
}
