package com.riwi.localstorage.riwi_local_storage.domain.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    // Inventory - Product: One-to-Many (1:M)  A Inventory can have many Products.
    @OneToMany(mappedBy = "inventory", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Product> product;

    // Branch - Inventory: One-to-Many (1:M) A branch can have many inventories.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;

    // Inventory - Sale_Detail: One-to-Many (1:M) A inventory can have many Sale_Details.
    @OneToMany(mappedBy = "inventory", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<SaleDetail> saleDetails;

    // Inventory - Supplier_Order: One-to-Many (1:M) An inventory can be part of many supplier orders.
    @OneToMany(mappedBy = "inventory", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<SupplierOrder> supplierOrders;

} 
