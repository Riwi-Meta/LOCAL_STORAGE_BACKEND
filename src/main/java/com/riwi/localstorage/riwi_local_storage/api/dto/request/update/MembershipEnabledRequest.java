package com.riwi.localstorage.riwi_local_storage.api.dto.request.update;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MembershipEnabledRequest {

  @NotNull(message = "The enabled field must not be null")
  private boolean enabled;
}
