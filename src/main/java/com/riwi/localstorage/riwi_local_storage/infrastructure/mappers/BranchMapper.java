package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.BranchRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.BranchResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    @Mapping(target = "id", ignore = true)
    Branch branchRequestToBranch(BranchRequest request);

    BranchResponse branchToBranchResponse(Branch branch);

    @Mapping(target = "id", ignore = true)
    void branchToUpdate(BranchRequest request, @MappingTarget Branch branch);


}
