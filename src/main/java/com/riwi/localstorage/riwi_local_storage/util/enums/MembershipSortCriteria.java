package com.riwi.localstorage.riwi_local_storage.util.enums;

import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MembershipSortCriteria {
  NAME_ASC("type", Sort.Direction.ASC),
  NAME_DESC("type", Sort.Direction.DESC),
  PRICE_ASC("price", Sort.Direction.ASC),
  PRICE_DESC("price", Sort.Direction.DESC);

  private final String field;
  private final Sort.Direction direction;
}
