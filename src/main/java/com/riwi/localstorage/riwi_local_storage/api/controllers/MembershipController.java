package com.riwi.localstorage.riwi_local_storage.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import com.riwi.localstorage.riwi_local_storage.util.enums.MembershipSortCriteria;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.BadRequestException;

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
  private final IMembershipService imembershipService;

  @Operation(summary = "Create membership")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
  })
  @PostMapping
  public ResponseEntity<MembershipResponse> create(@Validated @RequestBody MembershipRequest request) {
    System.out.println(request);
    return ResponseEntity.ok(this.imembershipService.create(request));
  }

  @GetMapping
  public ResponseEntity<Page<MembershipResponse>> getAll(
      @RequestParam(required = false) MembershipSortCriteria sortCriteria,
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int size,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      String msg = bindingResult.getFieldError().getDefaultMessage();
      throw new BadRequestException(msg);
    }

    if (page < 1) {
      page = 1;
    }
    if (sortCriteria == null) {
      sortCriteria = MembershipSortCriteria.NAME_ASC;
    }
    Sort sort = Sort.by(sortCriteria.getDirection(), sortCriteria.getField());

    Pageable pageable = PageRequest.of(page - 1, size, sort);

    return ResponseEntity.ok(this.imembershipService.getAll(pageable));
  }

  @PatchMapping("/{id}/status")
  public ResponseEntity<Void> updateMembershipStatus(@PathVariable String id,
      @Validated @RequestBody MembershipEnabledRequest membershipEnabledRequest) {

    imembershipService.updateMembershipStatus(id, membershipEnabledRequest.isEnabled());

    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<MembershipResponse> get(@PathVariable String id) {
    return ResponseEntity.ok(this.imembershipService.getById(id));
  }
}
