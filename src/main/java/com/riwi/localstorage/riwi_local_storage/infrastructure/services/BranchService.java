package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.BranchRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.BranchResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Branch;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.BranchRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IBranchService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.BranchMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class BranchService implements IBranchService {

    @Autowired
    private final BranchRepository branchRepository;

    @Autowired
    private final BranchMapper branchMapper;


    @Override
    public BranchResponse create(BranchRequest request) {
        Branch branch = branchMapper.branchRequestToBranch(request);
        branch.setEnable(true);
        return branchMapper.branchToBranchResponse(this.branchRepository.save(branch));
    }

    @Override
    public Optional<BranchResponse> getById(String id) {

        return branchRepository.findById(id)
                .map(branchMapper::branchToBranchResponse);
    }

    @Override
    public BranchResponse update(String id, BranchRequest request) {

        Branch branch = find(id);
        branchMapper.branchToUpdate(request, branch);
        return branchMapper.branchToBranchResponse(this.branchRepository.save(branch));
    }

    @Override
    public void delete(String id) {
        //We will just modify the isEname attribute.
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<BranchResponse> readAll() {
        return this.branchRepository.findAll()
                .stream()
                .map(branchMapper::branchToBranchResponse)
                .toList();
    }

    public Branch find(String Id){
        return this.branchRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("No such branch"));
    }

    public BranchResponse findById(String id){

        return this.branchRepository.findById(id)
             .map(branchMapper::branchToBranchResponse)
                .orElseThrow(() -> new RuntimeException("No such branch"));
    }
}