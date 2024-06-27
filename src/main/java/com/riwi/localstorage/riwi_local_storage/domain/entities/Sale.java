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
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

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

    //Relation with entity user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    //Relation with entity discount
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id", referencedColumnName = "id", nullable = false)
    private Discount discount;

    //Relation with entity saleDetail
    @OneToMany(mappedBy = "sale", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<SaleDetail> salesDetails;

    //Relation with entity branch
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", referencedColumnName = "id", nullable = false)
    private Branch branch;

    //Relation with entity cash
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cash_id", referencedColumnName = "id", nullable = false)
    private Cash cash;

    
}
