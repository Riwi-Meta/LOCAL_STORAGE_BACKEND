package com.riwi.localstorage.riwi_local_storage.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.MembershipRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.MembershipEnabledRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.MembershipResponse;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IMembershipService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/memberships")
public class MembershipController {

  @Autowired
  private final IMembershipService membershipService;

  @Operation(summary = "Create membership")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @PostMapping
  public ResponseEntity<MembershipResponse> create(@Validated @RequestBody MembershipRequest request) {
    System.out.println(request);
    return ResponseEntity.ok(this.membershipService.create(request));
  }
  
  @GetMapping
    public ResponseEntity<Page<MembershipResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(this.membershipService.getAll(page - 1, size));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateMembershipStatus(@PathVariable String id,
            @Validated @RequestBody MembershipEnabledRequest membershipEnabledRequest) {

        imembershipService.updateMembershipStatus(id, membershipEnabledRequest.isEnabled());

        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<MembershipResponse> get (@PathVariable String id){
        return ResponseEntity.ok(this.membershipService.getById(id));
    }
}



