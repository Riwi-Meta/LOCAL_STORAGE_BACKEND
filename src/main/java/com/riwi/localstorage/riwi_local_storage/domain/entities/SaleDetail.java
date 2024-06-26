package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sale_detail")
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "inventory_id", nullable = false)
    private String inventoryId;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(name = "total", nullable = false)
    private Double total;

    // Type must be change to Discount to "Sale" in the future
    // @ManyToOne
    // @JoinColumn(name = "sale_id", nullable = false)
    private Double sale;
}
