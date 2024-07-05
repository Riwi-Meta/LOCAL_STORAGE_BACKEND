package com.riwi.localstorage.riwi_local_storage.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.BranchRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.BranchResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IBranchService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/branch")
@AllArgsConstructor
public class BranchController {


    @Autowired
    private final IBranchService iBranchService;

    @GetMapping
    public ResponseEntity<List<BranchResponse>> read() {
        return ResponseEntity.ok(this.iBranchService.readAll());
    }

    @PostMapping
    public ResponseEntity<BranchResponse> create(
            @Validated
            @RequestBody BranchRequest request) {

        return ResponseEntity.ok(this.iBranchService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BranchResponse> update(
            @PathVariable String id ,
            @Validated
            @RequestBody BranchRequest request) {

        return ResponseEntity.ok(this.iBranchService.update(id, request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.iBranchService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
