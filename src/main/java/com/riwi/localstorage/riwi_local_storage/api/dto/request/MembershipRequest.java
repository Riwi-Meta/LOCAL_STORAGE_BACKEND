package com.riwi.localstorage.riwi_local_storage.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MembershipRequest {

  private String type;

  private Double price;

  private String description;
}
