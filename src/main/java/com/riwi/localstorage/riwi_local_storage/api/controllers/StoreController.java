package com.riwi.localstorage.riwi_local_storage.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

     //insert here your code

     /*--------------------
     * GET BY ID
     * -------------------
     */

     //insert here your code

    /*--------------------
     * CREATE STORE
     * -------------------
     */
       
        @PostMapping
        public ResponseEntity<StoreResponse>create(
            @Validated @RequestBody StoreRequest request
        ){
            return ResponseEntity.ok(this.service.create(request));
        }

    /*----------------------
     * UPDATE STORE
     * ---------------------
     */

     //insert here your code

    /*----------------------
     * DELETE STORE (DISABLE STORE - SOFT DELETE)
     * ---------------------
     */

     //insert here your code
    
}
