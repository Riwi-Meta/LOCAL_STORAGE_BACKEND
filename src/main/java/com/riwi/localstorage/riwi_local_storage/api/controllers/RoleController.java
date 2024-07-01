package com.riwi.localstorage.riwi_local_storage.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.RoleRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.RoleRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.RoleResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.services.RoleService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "roles")
@AllArgsConstructor
public class RoleController {
    @Autowired
    private final RoleService service;

    @PostMapping
    public ResponseEntity<RoleResponse> create(
        @Validated @RequestBody RoleRequest request
    ){
        return ResponseEntity.ok(this.service.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RoleResponse> update(
            @PathVariable String id,
            @Validated @RequestBody RoleRequestUpdate request) {
        return ResponseEntity.ok(this.service.update(id, request));
    }


    @GetMapping
    public ResponseEntity<Page<RoleResponse>>getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) Sort sortType
    ){
        /*if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }*/
        Pageable pageable;
        pageable = PageRequest.of(page, size, sortType);
        return ResponseEntity.ok(this.service.getAll(pageable));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<RoleResponse>> getById(@PathVariable String id){
        return ResponseEntity.ok(this.service.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> disable(@PathVariable String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

}