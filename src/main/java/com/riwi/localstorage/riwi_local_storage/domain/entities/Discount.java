package com.riwi.localstorage.riwi_local_storage.domain.entities;

import com.riwi.localstorage.riwi_local_storage.util.enums.DiscountType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "discount")
public class Discount {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", updatable = false, nullable = false)
  private String id;

  @Enumerated(EnumType.STRING)
  @Column(name = "type", nullable = false)
  private DiscountType type;

  @Column(name = "amount", nullable = false)
  private Double amount;

  @Column(name = "discount_date", nullable = false)
  private Date discountDate;

  @Column(name = "is_active", nullable = false)
  private Boolean isActive;

  @Column(name = "code", nullable = false)
  private String code;
}
