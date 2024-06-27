package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MembershipResponseDetails {
  private String id;
  private String type;
  private Double price;
  private String description;
  
  //organizar suscripcion
  //private List<SuscriptionResponse> suscriptions;
}
