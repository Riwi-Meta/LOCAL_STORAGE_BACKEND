package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.BranchRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.BranchResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Branch;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target="enable", ignore= true)
    @Mapping(target="cash", ignore= true)
    @Mapping(target="store.id", source= "storeId")
    @Mapping(target="inventory", ignore= true)
    @Mapping(target="sales", ignore= true)
    Branch branchRequestToBranch(BranchRequest request);

    BranchResponse branchToBranchResponse(Branch branch);

    
    @Mapping(target = "id", ignore = true)
    @Mapping(target="enable", ignore= true)
    @Mapping(target="cash", ignore= true)
    @Mapping(target="store.id", source= "storeId")
    @Mapping(target="inventory", ignore= true)
    @Mapping(target="sales", ignore= true)
    void branchToUpdate(BranchRequest request, @MappingTarget Branch branch);
}
