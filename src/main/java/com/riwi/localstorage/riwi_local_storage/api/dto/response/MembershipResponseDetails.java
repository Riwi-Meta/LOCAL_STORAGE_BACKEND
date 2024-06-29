package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MembershipResponseDetails extends MembershipResponse {
  
  private List<SubscriptionResponse> subscriptions;
}
