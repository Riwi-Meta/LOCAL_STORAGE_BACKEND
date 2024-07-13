package com.riwi.localstorage.riwi_local_storage.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.StoreRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.StoreResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IStoreService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "stores")
@AllArgsConstructor
public class StoreController {

    @Autowired
    private final IStoreService service;

    /*----------------------
     * GET ALL STORE
     * ---------------------
     */

    @GetMapping
    public ResponseEntity<Page<StoreResponse>> getAll(
            @PageableDefault(page = 0, size = 10, sort = "status") Pageable pageable) {
        Page<StoreResponse> responses = this.service.getAll(pageable);
        return ResponseEntity.ok(responses);
    }

    /*--------------------
    * GET BY ID
    * -------------------
    */

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<StoreResponse>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    /*--------------------
     * CREATE STORE
     * -------------------
     */

    @PostMapping
    public ResponseEntity<StoreResponse> create(
            @Validated @RequestBody StoreRequest request) {
        return ResponseEntity.ok(this.service.create(request));
    }

    /*----------------------
     * UPDATE STORE
     * ---------------------
     */

    // insert here your code

    /*----------------------
     * DELETE STORE (DISABLE STORE - SOFT DELETE)
     * ---------------------
     */

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        this.service.delete(id);
        
        return ResponseEntity.noContent().build();
    }
}
