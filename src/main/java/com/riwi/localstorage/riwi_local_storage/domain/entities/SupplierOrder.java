package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Entity
@Table(name = "supplier_order")
public class SupplierOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "note", nullable = true)
    private String note;

    @Column(name = "inventory_id", nullable = false)
    private String inventoryId;

    @Column(name = "supplier_id", nullable = false)
    private String supplierId;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "sub_total", nullable = false)
    private Double subTotal;

    @Column(name = "tax", nullable = false)
    private Double tax;
}