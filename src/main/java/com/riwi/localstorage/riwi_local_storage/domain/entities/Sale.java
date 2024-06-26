package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @Column(name = "branch_id", nullable = false)
    private String branchId;

    @Column(name = "cash_store_id", nullable = false)
    private String cashStoreId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "customer", nullable = true)
    private String customer;

    @Column(name = "tax", nullable = false)
    private Double tax;

    @Column(name = "sub_total", nullable = false)
    private Double subTotal;

    @Column(name = "total", nullable = false)
    private Double total;

    // Type must be change to Discount to "Sale" in the future
    // @ManyToOne
    // @JoinColumn(name = "discount_id", nullable = true)
    private Double discount;
}
