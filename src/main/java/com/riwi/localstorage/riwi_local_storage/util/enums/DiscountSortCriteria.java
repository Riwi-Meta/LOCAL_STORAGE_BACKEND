package com.riwi.localstorage.riwi_local_storage.util.enums;

import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DiscountSortCriteria {
  IS_NOT_ACTIVE("isActive", Sort.Direction.ASC, false),
  IS_ACTIVE("isActive", Sort.Direction.DESC, true),
  START_DATE_ASC("startDate", Sort.Direction.ASC, null),
  START_DATE_DESC("startDate", Sort.Direction.DESC, null),
  END_DATE_ASC("endDate", Sort.Direction.ASC, null),
  END_DATE_DESC("endDate", Sort.Direction.DESC, null);

  private final String field;
  private final Sort.Direction direction;
  private final Boolean isActiveFilter;
}