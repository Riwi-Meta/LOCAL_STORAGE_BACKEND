package com.riwi.localstorage.riwi_local_storage.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.MembershipRequest;
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

}
