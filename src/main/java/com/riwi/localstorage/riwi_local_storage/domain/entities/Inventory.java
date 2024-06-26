package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inventories")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "store_id", updatable = false, nullable = false)
    private String storeId;

    @Column(name = "product_id", updatable = false, nullable = false)
    private String productId;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "last_update_date", nullable = false)
    private Date lastUpdateDate;

    @Column(name = "supplier_order_id", nullable = false)
    private String supplierOrderId;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;
} 
