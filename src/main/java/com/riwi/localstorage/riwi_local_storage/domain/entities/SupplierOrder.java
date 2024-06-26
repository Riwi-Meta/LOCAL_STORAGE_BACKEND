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