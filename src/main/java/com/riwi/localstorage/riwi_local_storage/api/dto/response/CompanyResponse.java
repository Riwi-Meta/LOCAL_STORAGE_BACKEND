package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {

  private String id;
  private String email;
  private Long phone;
  private String address;
}
