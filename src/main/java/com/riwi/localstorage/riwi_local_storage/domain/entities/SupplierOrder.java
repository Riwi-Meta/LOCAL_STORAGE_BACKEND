package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    // @Column(name = "inventory_id", nullable = false)
    // private String inventoryId;

    // @Column(name = "supplier_id", nullable = false)
    // private String supplierId;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "sub_total", nullable = false)
    private Double subTotal;

    @Column(name = "tax", nullable = false)
    private Double tax;

    // Inventory - Supplier_Order: One-to-Many (1:M) An inventory can be part of many supplier orders.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;

    // Supplier - Supplier_Order: One-to-Many (1:M) A supplier can have many supplier orders.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;

}