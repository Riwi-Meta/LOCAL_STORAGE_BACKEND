package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
