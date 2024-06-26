package com.riwi.localstorage.riwi_local_storage.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.response.MembershipResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IMembershipService;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/membership")
@AllArgsConstructor
public class MembershipController {

    private final IMembershipService membershipService;

    
    @GetMapping
    public ResponseEntity<Page<MembershipResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size){
            return ResponseEntity.ok(this.membershipService.getAll(page -1, size));
    }
  
}
