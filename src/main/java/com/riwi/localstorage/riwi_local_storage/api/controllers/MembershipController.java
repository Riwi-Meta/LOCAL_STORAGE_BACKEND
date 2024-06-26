package com.riwi.localstorage.riwi_local_storage.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.MembershipEnabledRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.MembershipResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IMembershipService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/memberships")
@AllArgsConstructor
public class MembershipController {

    @Autowired
    private final IMembershipService imembershipService;

    @GetMapping
    public ResponseEntity<Page<MembershipResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(this.imembershipService.getAll(page - 1, size));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateMembershipStatus(@PathVariable String id,
            @Validated @RequestBody MembershipEnabledRequest membershipEnabledRequest) {

        imembershipService.updateMembershipStatus(id, membershipEnabledRequest.isEnabled());

        return ResponseEntity.ok().build();
    }
}
