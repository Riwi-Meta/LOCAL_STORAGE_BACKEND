package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
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

enum DiscountType {
    PERCENTAGE,
    FIXED
}
