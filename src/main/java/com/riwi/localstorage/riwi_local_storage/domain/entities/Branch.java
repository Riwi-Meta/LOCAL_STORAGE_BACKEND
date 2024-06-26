package com.riwi.localstorage.riwi_local_storage.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "branches")
public class Branch {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(length = 50)
    private String email;

    @Column(length = 50)
    private String city;
    
    @Column(length = 50)
    private String province;

    @Column(length = 50)
    private String country;

    @Column( name = "postal_code", length = 50)
    private String postalCode;

    @Column(length = 50)
    private String phone;

    // Relation with entity store
    // Type must be changed to "Store" in the future
    // @ManyToOne
    // @JoinColumn(name = "store_id", referencedColumnName = "id",nullable = false)
    private String store;

    //Relation with entity inventory
    // Branch - Inventory: One-to-Many (1:M) A branch can have many inventories.
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Inventory> inventory;
    
    // Relation with entity sale
    @OneToMany(mappedBy = "branch", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Sale> sales;

}
